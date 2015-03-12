package com.campusconnect.neo4j.da.iface;

import com.campusconnect.neo4j.types.BorrowedBook;
import com.campusconnect.neo4j.types.OwnedBook;
import com.campusconnect.neo4j.types.User;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by sn1 on 3/6/15.
 */
public interface UserDao {
    User createUser(User user);

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
}
