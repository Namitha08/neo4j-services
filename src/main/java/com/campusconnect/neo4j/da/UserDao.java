package com.campusconnect.neo4j.da;

import com.campusconnect.neo4j.repositories.UserRepository;
import com.campusconnect.neo4j.types.*;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by sn1 on 1/19/15.
 */
public class UserDao {

    private Neo4jTemplate neo4jTemplate;

    @Autowired
    UserRepository userRepository;

    public UserDao(Neo4jTemplate neo4jTemplate) {
        this.neo4jTemplate = neo4jTemplate;
    }

    public User createUser(User user){
        user.setId(UUID.randomUUID().toString());
        return neo4jTemplate.save(user);
    }

    public User getUser(String userId) {
        return userRepository.findBySchemaPropertyValue("id", userId);
    }

    public void createFollowingRelation(User user1, User user2){
    
        neo4jTemplate.createRelationshipBetween(user1, user2, FollowingRelation.class, UserRelationType.FOLLOWING.toString(), false);
    }

    public User updateUser(User user){
        return neo4jTemplate.save(user);
    }

    public List<User> getFollowers(User user){
        return userRepository.getFollowers(user.getId());
    }

    public List<User> getFollowing(User user){
        return userRepository.getFollowing(user.getId());
    }

}
