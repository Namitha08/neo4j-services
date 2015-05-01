package com.campusconnect.neo4j.da.iface;

import com.campusconnect.neo4j.types.*;

import java.util.List;

/**
 * Created by sn1 on 3/6/15.
 */
public interface UserDao {
    User createUser(User user, String accessToken);

    User getUser(String userId);

    User getUserByFbId(String fbId);

    void createFollowingRelation(User user1, User user2);

    User updateUser(String userId, User user);

    List<User> getFollowers(User user);

    List<User> getFollowing(User user);

    List<OwnedBook> getOwnedBooks(String userId);

    List<OwnedBook> getAvailableBooks(String userId);

    List<OwnedBook> getLentBooks(String userId);

    List<BorrowedBook> getBorrowedBooks(String userId);

    List<WishListBook> getWishListBooks(String userId);

    void synchWishListRec(String userId);

    List<UserRecommendation> getUserRecommendations(String userId);

}
