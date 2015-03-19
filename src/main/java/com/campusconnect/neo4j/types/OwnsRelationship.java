package com.campusconnect.neo4j.types;


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
    private long createdDate;
    private String status;   //read, owns, available
    private long lastModifiedDate;
    private String goodreadsStatus;
    
    private String borrowerId;
    
    private String dueDate;
    private int contractPeriodInDays;

    public String getBorrowerId() {
        return borrowerId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getContractPeriodInDays() {
        return contractPeriodInDays;
    }

    public void setBorrowerId(String borrowerId) {

        this.borrowerId = borrowerId;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setContractPeriodInDays(int contractPeriodInDays) {
        this.contractPeriodInDays = contractPeriodInDays;
    }

    public OwnsRelationship(User user, Book book, long createdDate, String status, long lastModifiedDate) {
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

    public OwnsRelationship(User user, Book book, long createdDate, String status, long lastModifiedDate, String goodreadsStatus) {
        this.user = user;
        this.book = book;
        this.createdDate = createdDate;
        this.status = status;
        this.lastModifiedDate = lastModifiedDate;
        this.goodreadsStatus = goodreadsStatus;
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

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
