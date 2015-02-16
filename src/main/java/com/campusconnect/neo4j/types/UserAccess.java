package com.campusconnect.neo4j.types;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.neo4j.annotation.RelationshipEntity;

/**
 * Created by sn1 on 1/22/15.
 */
//@RelationshipEntity(type = "USER_ACCESS")
public class UserAccess {

    public UserAccess(String role, String createdBy) {
        this.role = role;
        this.createdBy = createdBy;
    }

    @CreatedDate
    private DateTime createdDateTime;

    private String role;

    private String createdBy;

    public UserAccess() {
    }

    public DateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(DateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
