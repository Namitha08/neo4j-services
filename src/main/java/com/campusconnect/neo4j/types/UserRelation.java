package com.campusconnect.neo4j.types;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.neo4j.annotation.*;

/**
 * Created by sn1 on 1/19/15.
 */

public abstract class UserRelation {
    @GraphId
    private Long id;
    @StartNode
    private User user1;
    @EndNode
    private User user2;

    @CreatedDate
    private DateTime createdDate;

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }


    public UserRelation(User user1, User user2, DateTime createdDate) {
        this.user1 = user1;
        this.user2 = user2;
        this.createdDate = createdDate;
    }

    public UserRelation() {
    }
}
