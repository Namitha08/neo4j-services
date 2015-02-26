package com.campusconnect.neo4j.da;

import com.campusconnect.neo4j.repositories.UserRepository;
import com.campusconnect.neo4j.types.*;
import org.neo4j.rest.graphdb.entity.RestNode;
import org.neo4j.rest.graphdb.entity.RestRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.data.neo4j.support.Neo4jTemplate;

import java.util.*;

/**
 * Created by sn1 on 1/19/15.
 */
public class UserDao {

    @Autowired
    UserRepository userRepository;
    private Neo4jTemplate neo4jTemplate;

    public UserDao(Neo4jTemplate neo4jTemplate) {
        this.neo4jTemplate = neo4jTemplate;
    }

    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return neo4jTemplate.save(user);
    }

    public User getUser(String userId) {
        return userRepository.findBySchemaPropertyValue("id", userId);
    }

    public void createFollowingRelation(User user1, User user2) {

        neo4jTemplate.createRelationshipBetween(user1, user2, FollowingRelation.class, UserRelationType.FOLLOWING.toString(), false);
    }

    public User updateUser(User user) {
        return neo4jTemplate.save(user);
    }

    public List<User> getFollowers(User user) {
        return userRepository.getFollowers(user.getId());
    }

    public List<User> getFollowing(User user) {
        return userRepository.getFollowing(user.getId());
    }

    public List<OwnedBook> getOwnedBooks(String userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);

        Result<Map<String, Object>> mapResult = neo4jTemplate.query("match (users:User {id: {userId}})-[relation:OWNS]->(books:Book) return books, relation", params);

        return getOwnedBooksFromResultMap(mapResult);
    }

    public List<OwnedBook> getAvailableBooks(String userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);

        Result<Map<String, Object>> mapResult = neo4jTemplate.query("match (users:User {id: {userId}})-[relation:OWNS {status: \"available\"}]->(books:Book) return books, relation", params);

        return getOwnedBooksFromResultMap(mapResult);
    }
    
    public List<OwnedBook> getLentBooks(String userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        Result<Map<String, Object>> mapResult = neo4jTemplate.query("match (users:User {id: {userId}})-[relation:OWNS {status: \"lent\"}]->(books:Book) return books, relation", params);
        return getOwnedBooksFromResultMap(mapResult);
    }

    private List<OwnedBook> getOwnedBooksFromResultMap(Result<Map<String, Object>> mapResult) {
        List<OwnedBook> ownedBooks = new ArrayList<>();
        for (Map<String, Object> objectMap : mapResult) {
            RestNode bookNode = (RestNode) objectMap.get("books");
            RestRelationship rawOwnsRelationship = (RestRelationship) objectMap.get("relation");

            Book book = neo4jTemplate.convert(bookNode, Book.class);
            OwnsRelationship ownsRelationship = neo4jTemplate.convert(rawOwnsRelationship, OwnsRelationship.class);
            ownedBooks.add(new OwnedBook(book, ownsRelationship));
        }
        return ownedBooks;
    }

    public List<BorrowedBook> getBorrowedBooks(String userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        Result<Map<String, Object>> mapResult = neo4jTemplate.query("match (users:User {id: {userId}})-[relation:BORROWED]->(books:Book) return books, relation", params);
        return getBorrowedBooksFromResultMap(mapResult);
    }

    private List<BorrowedBook> getBorrowedBooksFromResultMap(Result<Map<String, Object>> mapResult) {
        List<BorrowedBook> borrowedBooks = new ArrayList<>();
        for (Map<String, Object> objectMap : mapResult) {
            RestNode bookNode = (RestNode) objectMap.get("books");
            RestRelationship rawOwnsRelationship = (RestRelationship) objectMap.get("relation");

            Book book = neo4jTemplate.convert(bookNode, Book.class);
            BorrowRelation borrowRelationship = neo4jTemplate.convert(rawOwnsRelationship, BorrowRelation.class);
            borrowedBooks.add(new BorrowedBook(book, borrowRelationship));
        }
        return borrowedBooks;
    }
    
    
}
