package com.campusconnect.neo4j.da;

import com.campusconnect.neo4j.repositories.BookRepository;
import com.campusconnect.neo4j.repositories.OwnsRelationshipRepository;
import com.campusconnect.neo4j.types.*;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.UUID;

/**
 * Created by sn1 on 2/16/15.
 */
public class BookDao {

    private Neo4jTemplate neo4jTemplate;

    @Autowired
    BookRepository bookRepository;
    
    @Autowired
    OwnsRelationshipRepository ownsRelationshipRepository;

    public BookDao(Neo4jTemplate neo4jTemplate) {
        this.neo4jTemplate = neo4jTemplate;
    }
    

    public Book createBook(Book book)
    {
        book.setId(UUID.randomUUID().toString());
        return neo4jTemplate.save(book);
    }

    public Book getBook(String bookId) {
        return bookRepository.findBySchemaPropertyValue("id", bookId);
    }
    
    public void addBookToUser(OwnsRelationship ownsRelationship) {
        neo4jTemplate.save(ownsRelationship);
    }
    
    @Transactional
    public void updateOwnedBookStatus(User user, Book book, String status) {
        OwnsRelationship relationship = neo4jTemplate.getRelationshipBetween(user, book, OwnsRelationship.class, RelationTypes.OWNS.toString());
        if(relationship == null) //todo: throw an exception
            return;
        relationship.setStatus(status);
        relationship.setLastModifiedDate(System.currentTimeMillis());
        neo4jTemplate.save(relationship);
    }

    public void addBookToBorrower(User borrower, Book book, BorrowRequest borrowRequest) {
        BorrowRelation borrowRelation = new BorrowRelation(borrower, book);
        borrowRelation.setStatus("pending");
        borrowRelation.setBorrowDate(borrowRequest.getBorrowDate());
        borrowRelation.setContractPeriodInDays(borrowRequest.getContractPeriodInDays());
        borrowRelation.setAdditionalComments(borrowRequest.getAdditionalMessage());
        borrowRelation.setOwnerUserId(borrowRequest.getOwnerUserId());
        neo4jTemplate.save(borrowRelation);
    }

    public void updateBookStatusOnAgreement(User user, Book book, User borrower) {
        updateOwnedBookStatus(user, book, "locked");
        updateBorrowedBookStatus(borrower, book, "agreed");
    }
    
    public void updateBookStatusOnSuccess(User user, Book book, User borrower) {
        updateOwnedBookStatus(user, book, "lent");
        updateBorrowedBookStatus(borrower, book, "borrowed");
    }

    @Transactional
    public void updateBorrowedBookStatus(User user, Book book, String status) {
        BorrowRelation relationship = neo4jTemplate.getRelationshipBetween(user, book, BorrowRelation.class, RelationTypes.BORROWED.toString());
        if(relationship == null) //todo: throw an exception
            return;
        relationship.setStatus(status);
        relationship.setLastModifiedDate(System.currentTimeMillis());
        neo4jTemplate.save(relationship);
    }
    
}
