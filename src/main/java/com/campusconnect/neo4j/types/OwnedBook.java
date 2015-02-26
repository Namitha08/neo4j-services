package com.campusconnect.neo4j.types;


/**
 * Created by sn1 on 2/25/15.
 */
public class OwnedBook extends Book {

    private long createdDate;
    private String status;
    private long lastModifiedDate;
    private String borrowerId;
    private String dueDate;
    private int contractPeriodInDays;

    public OwnedBook(Book book, OwnsRelationship ownsRelationship) {
        super(book.getId(), book.getName(), book.getIsbn());
        this.createdDate = ownsRelationship.getCreatedDate();
        this.status = ownsRelationship.getStatus();
        this.lastModifiedDate = ownsRelationship.getLastModifiedDate();
        this.borrowerId = ownsRelationship.getBorrowerId();
        this.dueDate = ownsRelationship.getDueDate();
    }

    public OwnedBook() {
    }

    public OwnedBook(long createdDate, String status, long lastModifiedDate) {

        this.createdDate = createdDate;
        this.status = status;
        this.lastModifiedDate = lastModifiedDate;
    }

    public OwnedBook(String name, String isbn, long createdDate, String status, long lastModifiedDate) {
        super(name, isbn);
        this.createdDate = createdDate;
        this.status = status;
        this.lastModifiedDate = lastModifiedDate;
    }

    public OwnedBook(String id, String name, String isbn, long createdDate, String status, long lastModifiedDate) {
        super(id, name, isbn);
        this.createdDate = createdDate;
        this.status = status;
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getContractPeriodInDays() {
        return contractPeriodInDays;
    }

    public void setContractPeriodInDays(int contractPeriodInDays) {
        this.contractPeriodInDays = contractPeriodInDays;
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
