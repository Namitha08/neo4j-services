package com.campusconnect.neo4j.tests.functional;

import com.campusconnect.neo4j.tests.TestBase;
import com.campusconnect.neo4j.tests.functional.base.DataBrewer;
import com.campusconnect.neo4j.types.*;
import com.sun.jersey.api.client.ClientResponse;
import org.testng.annotations.Test;

/**
 * Created by sn1 on 2/24/15.
 */
public class UserResourceTest extends TestBase {

    private User createdUser;
    private User createdUser2;
    
    private Book createdBook;
    private Book createdBook2;
    
    private Book availableBook;
    private Book lentBook;
    
    
    @Test
    public void testCompleteUserFlow() {
        ClientResponse clientResponse = resource.path("users").type("application/json").entity(DataBrewer.getFakeUserWithAddress()).post(ClientResponse.class);
        assert clientResponse.getStatus() == 201;
        createdUser = clientResponse.getEntity(User.class);
        
        ClientResponse clientResponse2 = resource.path("users").type("application/json").entity(DataBrewer.getFakeUserWithAddress()).post(ClientResponse.class);
        assert clientResponse.getStatus() == 201;
        createdUser2 = clientResponse2.getEntity(User.class);
        
        createdUser.setName("Updated name");
        createdUser.getAddresses().clear();
        createdUser.getAddresses().add(DataBrewer.getFakeAddress(AddressType.OTHER.toString()));
        //update
//        ClientResponse updateClientResponse = resource.path("users").path(createdUser.getId()).type("application/json").entity(createdUser).put(ClientResponse.class);
//        assert updateClientResponse.getStatus() == 200;
        //get
        ClientResponse getClientResponse = resource.path("users").path(createdUser.getId()).accept("application/json").get(ClientResponse.class);
        assert getClientResponse.getStatus() == 200;
        User updatedUser = getClientResponse.getEntity(User.class);
//        assert updatedUser.getName().equals("Updated name");

        Fields fields = new Fields();
        Field field = new Field("goodreadsId", "abc");
        Field field1 = new Field("goodreadsAccessToken", "xyz");
        fields.getFields().add(field);
        fields.getFields().add(field1);
        ClientResponse updateFieldsClientResponse = resource.path("users").path(createdUser.getId()).path("fields").type("application/json").entity(fields).put(ClientResponse.class);
        assert updateFieldsClientResponse.getStatus() == 200;
    }
    
    @Test(dependsOnMethods = "testCompleteUserFlow")
    public void bookE2EFlows(){
        ClientResponse createBookClientResponse = resource.path("books").type("application/json").entity(DataBrewer.getFakeBook()).post(ClientResponse.class);
        assert createBookClientResponse.getStatus() == 201;
        ClientResponse createBookClientResponse2 = resource.path("books").type("application/json").entity(DataBrewer.getFakeBook()).post(ClientResponse.class);
        assert createBookClientResponse2.getStatus() == 201;
        
        createdBook = createBookClientResponse.getEntity(Book.class);
        createdBook2 = createBookClientResponse2.getEntity(Book.class);
        
        ClientResponse getBookResponse = resource.path("books").path(createdBook.getId()).accept("application/json").get(ClientResponse.class);
        assert getBookResponse.getStatus() == 200;
        Book getBook = getBookResponse.getEntity(Book.class);
        
        assert getBook != null;
    }
   
    
    @Test(dependsOnMethods = "bookE2EFlows")
    public void listingBookE2EFlow() {
                
        
        ClientResponse addBookCR = resource.path("users").path(createdUser.getId()).path("books").path(createdBook.getId()).queryParam("status", "available").type("application/json").post(ClientResponse.class);
        assert addBookCR.getStatus() == 200;
        ClientResponse addBookCR2 = resource.path("users").path(createdUser.getId()).path("books").path(createdBook2.getId()).queryParam("status", "available").type("application/json").post(ClientResponse.class);
        assert addBookCR2.getStatus() == 200;
        
        ClientResponse updateBookStatusCR = resource.path("users").path(createdUser.getId()).path("books").path(createdBook.getId()).queryParam("status", "lent").type("application/json").put(ClientResponse.class);
        assert updateBookStatusCR.getStatus() == 200;
        
        ClientResponse ownedBooks = resource.path("users").path(createdUser.getId()).path("books").queryParam("filter", "owned").accept("application/json").get(ClientResponse.class);
        assert ownedBooks.getStatus() == 200;
        OwnedBooksPage ownedBooksPage = ownedBooks.getEntity(OwnedBooksPage.class);
        assert ownedBooksPage.getSize() == 2;
        
        ClientResponse availableBooks = resource.path("users").path(createdUser.getId()).path("books").queryParam("filter", "available").accept("application/json").get(ClientResponse.class);
        assert availableBooks.getStatus() == 200;
        OwnedBooksPage availableBooksPage = availableBooks.getEntity(OwnedBooksPage.class);
        assert availableBooksPage.getSize() == 1;
        availableBook = availableBooksPage.getOwnedBooks().get(0);
       

        ClientResponse lentBooks = resource.path("users").path(createdUser.getId()).path("books").queryParam("filter", "lent").accept("application/json").get(ClientResponse.class);
        assert lentBooks.getStatus() == 200;
        OwnedBooksPage lentBooksPage = lentBooks.getEntity(OwnedBooksPage.class);
        assert lentBooksPage.getSize() == 1;
        lentBook = lentBooksPage.getOwnedBooks().get(0);
    }
    
    @Test(dependsOnMethods = "listingBookE2EFlow")
    public void testBorrowingTest() {
        ClientResponse borrowReqResponse = resource.path("books").path(availableBook.getId()).path("borrow").type("application/json")
                                    .entity(DataBrewer.getBorrowRequest(createdUser.getId(), createdUser2.getId())).post(ClientResponse.class);
        assert borrowReqResponse.getStatus() == 200;
        
        ClientResponse agreedStatusCR = resource.path("books").path(availableBook.getId()).path("users")
                .path(createdUser.getId()).queryParam("borrowerId", createdUser2.getId()).queryParam("status", "agreed")
                .type("application/json")
                .put(ClientResponse.class);
        assert agreedStatusCR.getStatus() == 200;

        ClientResponse updateStatusCR = resource.path("books").path(availableBook.getId()).path("users")
                .path(createdUser.getId()).queryParam("borrowerId", createdUser2.getId()).queryParam("status", "success")
                .type("application/json")
                .put(ClientResponse.class);
        assert updateStatusCR.getStatus() == 200;
    }
    
    @Test(dependsOnMethods = "testBorrowingTest")
    public void testGetBorrowedBooks() {
        ClientResponse borrowedBooksCR = resource.path("users").path(createdUser2.getId()).path("books").queryParam("filter", "borrowed").accept("application/json").get(ClientResponse.class);
        assert borrowedBooksCR.getStatus() == 200;
        BorrowedBooksPage borrowedBooksPage = borrowedBooksCR.getEntity(BorrowedBooksPage.class);
    }
}