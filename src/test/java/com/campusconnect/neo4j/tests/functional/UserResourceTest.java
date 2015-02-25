package com.campusconnect.neo4j.tests.functional;

import com.campusconnect.neo4j.tests.TestBase;
import com.campusconnect.neo4j.tests.functional.base.DataBrewer;
import com.campusconnect.neo4j.types.AddressType;
import com.campusconnect.neo4j.types.Book;
import com.campusconnect.neo4j.types.User;
import com.sun.jersey.api.client.ClientResponse;
import org.testng.annotations.Test;

/**
 * Created by sn1 on 2/24/15.
 */
public class UserResourceTest extends TestBase {

    User createdUser;
    
    @Test
    public void createUser() {
        ClientResponse clientResponse = resource.path("users").type("application/json").entity(DataBrewer.getUserWithTwoAddresses()).post(ClientResponse.class);
        createdUser = clientResponse.getEntity(User.class);
    }
    
    @Test(dependsOnMethods = "createUser")
    public void getUser(){
        ClientResponse clientResponse = resource.path("users").path(createdUser.getId()).accept("application/json").get(ClientResponse.class);
        User resultUser = clientResponse.getEntity(User.class);
        System.err.println(resultUser);
    }
    
    @Test(dependsOnMethods = "createUser")
    public void updateUser(){
        createdUser.setName("Updated name");
        createdUser.getAddresses().clear();
        
        createdUser.getAddresses().add(DataBrewer.getFakeAddress(AddressType.OTHER.toString()));
        ClientResponse updateClientResponse = resource.path("users").path(createdUser.getId()).type("application/json").entity(createdUser).put(ClientResponse.class);
        ClientResponse getClientResponse = resource.path("users").path(createdUser.getId()).accept("application/json").get(ClientResponse.class);

        User updatedUser = getClientResponse.getEntity(User.class);
        assert updatedUser.getName().equals("Updated name");
    }
    
    @Test(dependsOnMethods = "createUser")
    public void addBookToUser() {
        ClientResponse createBookClientResponse = resource.path("books").type("application/json").entity(DataBrewer.getFakeBook()).post(ClientResponse.class);
        Book createdBook = createBookClientResponse.getEntity(Book.class);

        ClientResponse addBookCR = resource.path("users").path(createdUser.getId()).path("books").path(createdBook.getId()).queryParam("status", "notAvailable").type("application/json").post(ClientResponse.class);

        ClientResponse updateBookCR = resource.path("users").path(createdUser.getId()).path("books").path(createdBook.getId()).queryParam("status", "available").type("application/json").put(ClientResponse.class);


    }
    
    

}
