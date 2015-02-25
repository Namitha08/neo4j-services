package com.campusconnect.neo4j.resources;

import com.campusconnect.neo4j.da.BookDao;
import com.campusconnect.neo4j.da.UserDao;
import com.campusconnect.neo4j.types.Address;
import com.campusconnect.neo4j.types.Book;
import com.campusconnect.neo4j.types.OwnsRelationship;
import com.campusconnect.neo4j.types.User;
import org.joda.time.DateTime;

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
        User updatedUser = userDao.updateUser(user);
        return Response.ok().build();
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
        DateTime now = new DateTime(System.currentTimeMillis());
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

    private Map<String, Object> getHeadersForAddingBook(String status) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("createdDate", new DateTime(System.currentTimeMillis()));
        properties.put("status", status);
        properties.put("lastModifiedDate", new DateTime(System.currentTimeMillis()));
        return properties;
    }
    private Map<String, Object> getHeadersForStatusUpdate(String status) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("status", status);
        properties.put("lastModifiedDate", new DateTime(System.currentTimeMillis()));
        return properties;
    }
    
    private Map<String, Object> getRequiredHeadersForAccess(String createdBy, String role) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("createdBy", createdBy);
        properties.put("createdDate", new DateTime(System.currentTimeMillis()));
        properties.put("role", role);
        return properties;
    }

    private Map<String, Object> getRequiredHeadersForAddressLink(String addressType) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("createdDate", new DateTime(System.currentTimeMillis()));
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
