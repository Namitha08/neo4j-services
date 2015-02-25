package com.campusconnect.neo4j.types;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;

/**
 * Created by sn1 on 2/23/15.
 */
public class AddressRelation {
    
    @CreatedDate
    private DateTime createdDate;
}
