package com.campusconnect.neo4j.types;

import org.joda.time.DateTime;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.rest.graphdb.entity.RestNode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by sn1 on 1/17/15.
 */

@NodeEntity
public class User {

    @GraphId
    private Long nodeId;

    @Indexed(unique=true)
    private String id;
    
    private String name;
    private String email; 
    
    @Fetch
    private Set<Address> addresses;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    @CreatedDate
    private DateTime createdDate;

    @Override
    public String toString() {
        return "User{" +
                "nodeId=" + nodeId +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", addresses=" + addresses +
                ", phone='" + phone + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User() {
        
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

}
