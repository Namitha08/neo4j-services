package com.campusconnect.neo4j.types;

import org.joda.time.DateTime;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Created by sn1 on 2/25/15.
 */
@RelationshipEntity(type = "OWNS")
public class OwnsRelationship {
    @GraphId
    private Long id;
    
    @StartNode
    private User user;
    
    @EndNode
    private Book book;

    public OwnsRelationship(User user, Book book, DateTime createdDate, String status, DateTime lastModifiedDate) {
        this.user = user;
        this.book = book;
        this.createdDate = createdDate;
        this.status = status;
        this.lastModifiedDate = lastModifiedDate;
    }

    public OwnsRelationship() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    private DateTime createdDate;
    private String status;
    private DateTime lastModifiedDate;

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
