package com.campusconnect.neo4j.da;

import com.campusconnect.neo4j.repositories.BookRepository;
import com.campusconnect.neo4j.types.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;

import java.util.UUID;

/**
 * Created by sn1 on 2/16/15.
 */
public class BookDao {

    private Neo4jTemplate neo4jTemplate;

    @Autowired
    BookRepository bookRepository;

    public BookDao(Neo4jTemplate neo4jTemplate) {
        this.neo4jTemplate = neo4jTemplate;
    }
    
    
    public Book createBook(Book book)
    {
        book.setId(UUID.randomUUID().toString());
        Book createdBook = neo4jTemplate.save(book);

        //Todo:  log the id
        System.out.println("Saved:" + book);
        return createdBook;
        
    }

    public Book getBook(String bookId) {
        return bookRepository.findBySchemaPropertyValue("id", bookId);
    }
    
}
