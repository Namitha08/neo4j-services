package com.campusconnect.neo4j.akka.goodreads;

import akka.actor.ActorRef;
import com.campusconnect.neo4j.akka.goodreads.task.AddGoodreadsBookToUserTask;
import com.campusconnect.neo4j.akka.goodreads.task.GetBooksTask;
import com.campusconnect.neo4j.types.Book;


/**
 * Created by sn1 on 3/10/15.
 */
public class GoodreadsAsynchHandler {

    public ActorRef getSaveBooksToDbRouter() {
        return saveBooksToDbRouter;
    }

    public ActorRef getGetAndSaveBooksRouter() {
        return getAndSaveBooksRouter;
    }

    public ActorRef getSuccessListener() {
        return successListener;
    }

    private ActorRef saveBooksToDbRouter;
    private ActorRef getAndSaveBooksRouter;
    private ActorRef successListener;
    
    private ActorRef addGoodreadsBookToUserRouter;

    public ActorRef getAddGoodreadsBookToUserRouter() {
        return addGoodreadsBookToUserRouter;
    }

    public void setAddGoodreadsBookToUserRouter(ActorRef addGoodreadsBookToUserRouter) {
    
        this.addGoodreadsBookToUserRouter = addGoodreadsBookToUserRouter;
    }

    public void setGetAndSaveBooksRouter(ActorRef getAndSaveBooksRouter) {
        this.getAndSaveBooksRouter = getAndSaveBooksRouter;
    }

    public void setSaveBooksToDbRouter(ActorRef saveBooksToDbRouter) {
        this.saveBooksToDbRouter = saveBooksToDbRouter;
    }

    public void setSuccessListener(ActorRef successListener) {
        this.successListener = successListener;
    }

    public void saveBook(Book book) {
        saveBooksToDbRouter.tell(book, successListener);
    }

    public void getAndSaveBooks(String userId, String goodreadsUserId, String accessToken, String accessTokenSecret) {
        getAndSaveBooksRouter.tell(new GetBooksTask(userId, goodreadsUserId, 1, accessToken, accessTokenSecret), successListener);
    }
    
    public void addGoodreadsBookToUser(String userId, Book book, String shelfName){
        addGoodreadsBookToUserRouter.tell(new AddGoodreadsBookToUserTask(book, userId, shelfName), successListener);
    }
    
    
    
    
}
