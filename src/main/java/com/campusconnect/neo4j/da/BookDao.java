package com.campusconnect.neo4j.da;

import com.campusconnect.neo4j.types.Book;
import org.springframework.data.neo4j.support.Neo4jTemplate;

/**
 * Created by sn1 on 2/16/15.
 */
public class BookDao {

    private Neo4jTemplate neo4jTemplate;

    public BookDao(Neo4jTemplate neo4jTemplate) {
        this.neo4jTemplate = neo4jTemplate;
    }
    
    
    public Book createBook(Book book)
    {
        return null;
        
    }
    
}
