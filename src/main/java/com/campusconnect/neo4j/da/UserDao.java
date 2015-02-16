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
        User createdUser = neo4jTemplate.save(user);
        //Todo:  log the id
        System.out.println("Saved:" + user);
        return createdUser;
    }

    public User getUser(String userId) {
        return userRepository.findBySchemaPropertyValue("id", userId);
    }

    public void createRelation(String userId1, String userId2, UserRelationType userRelationType){
        neo4jTemplate.createRelationshipBetween(getUser(userId1), getUser(userId2), UserRelation.class, userRelationType.name(), false);
    }

    public void createFollowingRelation(User user1, User user2){
        neo4jTemplate.createRelationshipBetween(user1, user2, FollowingRelation.class, UserRelationType.FOLLOWING.toString(), false);
    }

    public User updateUser(User user){
        User updatedUser = neo4jTemplate.save(user);
        return updatedUser;
    }

    public void addCollege(College college, User user, Map<String, Object> properties){
        Node userNode = neo4jTemplate.getNode(user.getNodeId());
        Node collegeNode = neo4jTemplate.getNode(college.getNodeId());
        Relationship relationship = neo4jTemplate.createRelationshipBetween(userNode, collegeNode, RelationTypes.USER_ACCESS.toString(), properties);

    }

    public List<User> getFollowers(User user){
        return userRepository.getFollowers(user.getId());
    }

    public List<User> getFollowing(User user){
        return userRepository.getFollowing(user.getId());
    }

}
