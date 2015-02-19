package com.campusconnect.neo4j.resources;

import com.campusconnect.neo4j.da.BookDao;
import com.campusconnect.neo4j.types.Book;

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

    public BookResource(BookDao bookDao) {

        this.bookDao = bookDao;
    }

    @POST
    public Response createBook(Book book)
    {
        Book createdBook = bookDao.createBook(book);
        return Response.created(null).entity(createdBook).build();
    }

    @GET
    public Response getBook(String id)
    {
        Book book = bookDao.getBook(id);
        return Response.ok().entity(book).build();
    }
}
