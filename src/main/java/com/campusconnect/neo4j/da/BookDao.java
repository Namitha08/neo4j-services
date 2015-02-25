package com.campusconnect.neo4j.da;

import com.campusconnect.neo4j.repositories.BookRepository;
import com.campusconnect.neo4j.repositories.OwnsRelationshipRepository;
import com.campusconnect.neo4j.types.Book;
import com.campusconnect.neo4j.types.OwnsRelationship;
import com.campusconnect.neo4j.types.RelationTypes;
import com.campusconnect.neo4j.types.User;
import org.joda.time.DateTime;
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
        relationship.setLastModifiedDate(new DateTime(System.currentTimeMillis()));
        neo4jTemplate.save(relationship);
    }
}
