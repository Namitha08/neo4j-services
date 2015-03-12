package com.campusconnect.neo4j.akka.goodreads;

import akka.actor.ActorRef;
import com.campusconnect.neo4j.types.Book;


/**
 * Created by sn1 on 3/10/15.
 */
public class GoodreadsAsynchHandler {
    
    private ActorRef saveBooksToDbRouter;
    private ActorRef successListener;

    public void setSaveBooksToDbRouter(ActorRef saveBooksToDbRouter) {
        this.saveBooksToDbRouter = saveBooksToDbRouter;
    }

    public void setSuccessListener(ActorRef successListener) {
        this.successListener = successListener;
    }

    public void saveBook(Book book) {
        saveBooksToDbRouter.tell(book, successListener);
    }
}
