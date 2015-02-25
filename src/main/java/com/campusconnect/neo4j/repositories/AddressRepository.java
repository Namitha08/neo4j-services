package com.campusconnect.neo4j.repositories;

import com.campusconnect.neo4j.types.Address;
import com.campusconnect.neo4j.types.Book;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by sn1 on 2/23/15.
 */
public interface AddressRepository extends GraphRepository<Address> {
    
}
