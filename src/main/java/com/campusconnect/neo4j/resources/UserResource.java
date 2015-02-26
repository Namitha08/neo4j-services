package com.campusconnect.neo4j.resources;

import com.campusconnect.neo4j.da.BookDao;
import com.campusconnect.neo4j.da.UserDao;
import com.campusconnect.neo4j.types.*;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Created by sn1 on 1/22/15.
 */
@Path("users")
@Consumes("application/json")
@Produces("application/json")
public class UserResource {
    private UserDao userDao;
    private BookDao bookDao;
    
    public UserResource() {
    }

    public UserResource(UserDao userDao, BookDao bookDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
    }
    
    @POST
    public Response createUser(final User user) throws URISyntaxException {
        final long createdDate = System.currentTimeMillis();
        user.setCreatedDate(createdDate);
        user.setLastModifiedDate(createdDate);
        User createdUser = userDao.createUser(user);
        return Response.created(new URI("/user/" + createdUser.getId())).entity(createdUser).build();
    }
    
    @GET
    @Path("{userId}")
    public Response getUser(@PathParam("userId") final String userId) {
        User user = userDao.getUser(userId);
        return Response.ok().entity(user).build();
    }

    @PUT
    @Path("{userId}")
    public Response updateUser(@PathParam("userId") final String userId, User user) {
        user.setLastModifiedDate(System.currentTimeMillis());
        User updatedUser = userDao.updateUser(user);
        return Response.ok().entity(updatedUser).build();
    }

    @PUT
    @Path("{userId}/addresses")
    public Response addAddress(@PathParam("userId") final String userId, final Address address){
        return null;
    }
    
    @POST
    @Path("{userId}/books/{bookId}")
    public Response addBook(@PathParam("userId") final String userId, 
                            @PathParam("bookId") final String bookId,
                            @QueryParam("status") @DefaultValue("none") final String status) throws Exception {
        
        User user = userDao.getUser(userId);
        Book book = bookDao.getBook(bookId);
        long now = System.currentTimeMillis();
        bookDao.addBookToUser(new OwnsRelationship(user, book, now, status, now));
        return Response.ok().build();
    }
    
    @PUT
    @Path("{userId}/books/{bookId}")
    public Response changeBookStatus(@PathParam("userId") final String userId, 
                            @PathParam("bookId") final String bookId,
                            @QueryParam("status") @DefaultValue("none") final String status) throws Exception {
        
        User user = userDao.getUser(userId);
        Book book = bookDao.getBook(bookId);
        
        bookDao.updateOwnedBookStatus(user, book, status);
        return Response.ok().build();
    }
    
    @GET
    @Path("{userId}/books")
    public Response getBooks(@PathParam("userId") final String userId, @QueryParam("filter") String filter) throws Exception {
        if(filter == null){
            throw new Exception("filer is null");
        }
        if(filter.equals("owned")){
            final List<OwnedBook> ownedBooks = userDao.getOwnedBooks(userId);
            OwnedBooksPage ownedBooksPage = new OwnedBooksPage(0, ownedBooks.size(), ownedBooks);
            return Response.ok().entity(ownedBooksPage).build();
        } else if(filter.equals("available")) {
            final List<OwnedBook> ownedBooks = userDao.getAvailableBooks(userId);
            OwnedBooksPage ownedBooksPage = new OwnedBooksPage(0, ownedBooks.size(), ownedBooks);
            return Response.ok().entity(ownedBooksPage).build();
        } else if (filter.equals("lent")) {
            final List<OwnedBook> ownedBooks = userDao.getLentBooks(userId);
            OwnedBooksPage ownedBooksPage = new OwnedBooksPage(0, ownedBooks.size(), ownedBooks);
            return Response.ok().entity(ownedBooksPage).build();
        } else if (filter.equals("borrowed")) {
            final List<BorrowedBook> borrowedBooks = userDao.getBorrowedBooks(userId);
            BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage(0, borrowedBooks.size(), borrowedBooks);
            return Response.ok().entity(borrowedBooksPage).build();
        }
        return Response.ok().build();
    }

    private Map<String, Object> getHeadersForAddingBook(String status) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("createdDate", System.currentTimeMillis());
        properties.put("status", status);
        properties.put("lastModifiedDate", System.currentTimeMillis());
        return properties;
    }
    private Map<String, Object> getHeadersForStatusUpdate(String status) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("status", status);
        properties.put("lastModifiedDate", System.currentTimeMillis());
        return properties;
    }
    
    private Map<String, Object> getRequiredHeadersForAccess(String createdBy, String role) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("createdBy", createdBy);
        properties.put("createdDate", System.currentTimeMillis());
        properties.put("role", role);
        return properties;
    }

    private Map<String, Object> getRequiredHeadersForAddressLink(String addressType) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("createdDate", System.currentTimeMillis());
        properties.put("type", addressType);
        return properties;
    }

    private Address addAddress(User user, Address address){
//        Address createdAddress = addressDao.createAddress(address);
//        addressDao.linkAddressToUser(user, address, getRequiredHeadersForAddressLink(address.getAddressType()));
//        return createdAddress;
        return null;
    }

    private List<Address> addAddressesToUser(User user, List<Address> addresses) {
        if(addresses != null){
            List<Address> createdAddresses = new ArrayList<>();
            for (Address address : addresses) {
                createdAddresses.add(addAddress(user, address));
            }
            return createdAddresses;
        }
        return null;
    }
    
    

    //    public void approveCollegeAccess(String userId, String collegeId, String createdBy, String role){
//        User user = userDao.getUser(userId);
//        College college = collegeDao.getCollege(collegeId);
//        userDao.addCollege(college, user, getRequiredHeadersForAccess(createdBy, role));
//    }

    //    public void addCollegeAccess(String userId, String groupId, String role) {
//    }
}
