package com.campusconnect.neo4j.resources;

import com.campusconnect.neo4j.da.BookDao;
import com.campusconnect.neo4j.da.UserDao;
import com.campusconnect.neo4j.types.Book;
import com.campusconnect.neo4j.types.BorrowRelation;
import com.campusconnect.neo4j.types.BorrowRequest;
import com.campusconnect.neo4j.types.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by I308260 on 2/19/2015.
 */

@Path("books")
@Consumes("application/json")
@Produces("application/json")
public class BookResource {
    private BookDao bookDao;
    private UserDao userDao;

    public BookResource(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    @POST
    public Response createBook(Book book) {
        Book createdBook = bookDao.createBook(book);
        return Response.created(null).entity(createdBook).build();
    }

    @GET
    @Path("{bookId}")
    public Response getBook(@PathParam("bookId") String bookId) {
        Book book = bookDao.getBook(bookId);
        return Response.ok().entity(book).build();
    }
    
    @POST
    @Path("{bookId}/borrow")
    public Response borrowBook(@PathParam("bookId") String bookId, BorrowRequest borrowRequest){
        //create a link to the user - pendingBorrow
        Book book = bookDao.getBook(bookId);
        User borrower = userDao.getUser(borrowRequest.getBorrowerUserId());
        bookDao.addBookToBorrower(borrower, book, borrowRequest);
        //generate notification
        return Response.ok().build();
    }
    
    @PUT
    @Path("{bookId}/users/{userId}")
    public Response updateStatus(@PathParam("bookId") String bookId, @PathParam("userId") String userId, 
                                 @QueryParam("borrowerId") String borrowerId, @QueryParam("status") String status) {
        //locked - for user
        //agreed - for borrower
        Book book = bookDao.getBook(bookId);
        User user = userDao.getUser(userId);
        User borrower = userDao.getUser(borrowerId);
        if(status.equals("agreed"))
            bookDao.updateBookStatusOnAgreement(user, book, borrower);
        else if(status.equals("success"))
            bookDao.updateBookStatusOnSuccess(user, book, borrower);
        return Response.ok().build();
    }
    
}
