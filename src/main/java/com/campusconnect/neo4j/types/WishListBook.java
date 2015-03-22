package com.campusconnect.neo4j.types;

import java.io.Serializable;

/**
 * Created by sn1 on 3/22/15.
 */
public class WishListBook extends Book implements Serializable {

    public WishListBook(Book book, WishListRelationship whishListRelationship) {
        super();    
    }

    public WishListBook() {
    }
}
