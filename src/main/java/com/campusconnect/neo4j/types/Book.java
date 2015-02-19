package com.campusconnect.neo4j.types;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Created by sn1 on 2/16/15.
 */
@NodeEntity
public class Book {
    @GraphId
    private Long nodeId;

    @Indexed(unique=true)
    private String id;

    public Book() {
    }

    private String name;
    private String isbn;

    public Book(String name, String isbn) {
        this.name = name;
        this.isbn = isbn;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
