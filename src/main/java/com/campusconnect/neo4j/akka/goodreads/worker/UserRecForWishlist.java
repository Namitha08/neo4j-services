package com.campusconnect.neo4j.akka.goodreads.worker;

import akka.actor.UntypedActor;
import com.campusconnect.neo4j.akka.goodreads.api.GetBooks;
import com.campusconnect.neo4j.akka.goodreads.mappers.BookMapper;
import com.campusconnect.neo4j.akka.goodreads.task.UserRecForWishListTask;
import com.campusconnect.neo4j.akka.goodreads.types.GetBooksResponse;
import com.campusconnect.neo4j.akka.goodreads.types.Review;
import com.campusconnect.neo4j.akka.goodreads.types.Reviews;
import com.campusconnect.neo4j.da.iface.BookDao;
import com.campusconnect.neo4j.da.iface.UserDao;
import com.campusconnect.neo4j.types.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sn1 on 3/24/15.
 */
public class UserRecForWishlist extends UntypedActor {
    public static Logger logger = LoggerFactory.getLogger(UserRecForWishlist.class);
    @Autowired
    GetBooks getBooks;
    
    @Autowired
    BookDao bookDao;
    
    @Autowired
    UserDao userDao;
    
    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof UserRecForWishListTask) {
            UserRecForWishListTask userRecForWishListTask = (UserRecForWishListTask) message;
            GetBooksResponse getBooksResponse = getBooks.getBooksForUser(userRecForWishListTask.getFriend().getId(), userRecForWishListTask.getPage());
            if(getBooksResponse != null) {
                
                final Reviews reviews = getBooksResponse.getReviews();
                List<Book> books = new ArrayList<>();
                if(reviews!= null && reviews.getReview() != null){

                    if(Integer.parseInt(reviews.getEnd()) != Integer.parseInt(reviews.getTotal())){
                        getSelf().tell(new UserRecForWishListTask(userRecForWishListTask.getAccessToken(),userRecForWishListTask.getAccessSecret(), 
                                userRecForWishListTask.getUserId(), userRecForWishListTask.getGoodreadsId(), userRecForWishListTask.getFriend(), userRecForWishListTask.getWishListBooks(),
                                userRecForWishListTask.getPage() + 1, userRecForWishListTask.getUserRecommendations()), getSender());
                    }
                    
                    for (Review review : reviews.getReview()) {
                        com.campusconnect.neo4j.types.Book book = BookMapper.getBookFromGoodreadsBook(review.getBook());
                        books.add(book);
                    }
                }

                List<WishListBook> wishListBooks = userRecForWishListTask.getWishListBooks();
                if(wishListBooks != null)
                for (Book wishListBook : wishListBooks) {
                    for(Book friendBook : books) {
                        if(wishListBook.getGoodreadsId().equals(friendBook.getGoodreadsId())) {
                            if(recExists(wishListBook.getGoodreadsId(), userRecForWishListTask.getFriend().getId(), userRecForWishListTask.getUserRecommendations())){
                                logger.info("User Recommendation already exists:");
                            }
                            else {
                                User user = userDao.getUser(userRecForWishListTask.getUserId());
                               bookDao.createGoodreadsFriendBookRec(new GoodreadsFriendBookRecRelation(user, wishListBook, "rec", userRecForWishListTask.getFriend().getId(), userRecForWishListTask.getFriend().getName(), userRecForWishListTask.getFriend().getImageUrl()));
                            }
                         }
                    }
                }
            }
        }
    }

    private boolean recExists(Integer goodreadsBookId, String friendId, List<UserRecommendation> userRecommendations) {
        for (UserRecommendation userRecommendation : userRecommendations) {
            if(userRecommendation.getBook().getGoodreadsId().equals(goodreadsBookId) && userRecommendation.getFriendGoodreadsId().equals(friendId)){
                return true;
            }
        }
        return false;
    }
}
