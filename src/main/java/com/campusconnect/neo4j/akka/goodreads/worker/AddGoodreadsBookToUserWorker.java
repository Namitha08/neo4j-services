package com.campusconnect.neo4j.akka.goodreads.worker;

import akka.actor.UntypedActor;
import com.campusconnect.neo4j.akka.goodreads.task.AddGoodreadsBookToUserTask;
import com.campusconnect.neo4j.da.iface.BookDao;
import com.campusconnect.neo4j.da.iface.UserDao;
import com.campusconnect.neo4j.types.Book;
import com.campusconnect.neo4j.types.GoodreadsStatus;
import com.campusconnect.neo4j.types.OwnsRelationship;
import com.campusconnect.neo4j.types.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sn1 on 3/13/15.
 */
public class AddGoodreadsBookToUserWorker extends UntypedActor {
    @Autowired
    private BookDao bookDao;
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof AddGoodreadsBookToUserTask) {
            AddGoodreadsBookToUserTask addGoodreadsBookToUserTask = (AddGoodreadsBookToUserTask) message;
            Book book = bookDao.getBookByGoodreadsId(addGoodreadsBookToUserTask.getBook().getGoodreadsId().toString());
            User user = userDao.getUser(addGoodreadsBookToUserTask.getUserId());

            final long now = System.currentTimeMillis();
            if(addGoodreadsBookToUserTask.getShelfName().equals(GoodreadsStatus.READ.toString())) {
                bookDao.addBookToUser(new OwnsRelationship(user, book, now, null, now, GoodreadsStatus.READ.toString()));
            } else if(addGoodreadsBookToUserTask.getShelfName().equals(GoodreadsStatus.TO_READ.toString())){
                //TODO: handel in wishlist relationship
            } else if (addGoodreadsBookToUserTask.getShelfName().equals(GoodreadsStatus.CURRENTLY_READING.toString())){
                bookDao.addBookToUser(new OwnsRelationship(user, book, now, null, now, GoodreadsStatus.CURRENTLY_READING.toString()));
            }
        }
    }
}
