package com.campusconnect.neo4j.types;


import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Created by sn1 on 2/26/15.
 */
@RelationshipEntity(type = "BORROWED")
public class BorrowRelation {
    @GraphId
    private Long id;

    @StartNode
    private User startNode;

    @EndNode
    private Book book;

    private String status;
    private long dueDate;
    private long createdDate;
    private String ownerUserId;
    private String additionalComments;
    private long borrowDate;
    private int contractPeriodInDays;
    private long lastModifiedDate;

    public BorrowRelation(User startNode, Book book) {
        this.startNode = startNode;
        this.book = book;
    }

    public BorrowRelation(User startNode, Book book, String status, long dueDate, long createdDate, String ownerUserId, String additionalComments, long borrowDate, int contractPeriodInDays) {
        this.startNode = startNode;
        this.book = book;
        this.status = status;
        this.dueDate = dueDate;
        this.createdDate = createdDate;
        this.ownerUserId = ownerUserId;
        this.additionalComments = additionalComments;
        this.borrowDate = borrowDate;
        this.contractPeriodInDays = contractPeriodInDays;
    }

    public BorrowRelation() {

    }

    public long getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(long borrowDate) {
        this.borrowDate = borrowDate;
    }

    public int getContractPeriodInDays() {
        return contractPeriodInDays;
    }

    public void setContractPeriodInDays(int contractPeriodInDays) {
        this.contractPeriodInDays = contractPeriodInDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getStartNode() {
        return startNode;
    }

    public void setStartNode(User startNode) {
        this.startNode = startNode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getDueDate() {
        return dueDate;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    public void setLastModifiedDate(long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public long getLastModifiedDate() {
        return lastModifiedDate;
    }
}
