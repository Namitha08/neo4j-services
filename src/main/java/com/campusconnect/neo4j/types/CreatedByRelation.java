package com.campusconnect.neo4j.types;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.neo4j.annotation.RelationshipEntity;

/**
 * Created by sn1 on 1/22/15.
 */
//@RelationshipEntity(type = "CREATED_BY")
public class CreatedByRelation {

    @CreatedDate
    private long createdDate;
}
