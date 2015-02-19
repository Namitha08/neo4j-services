package com.campusconnect.neo4j.tests;

import com.campusconnect.neo4j.types.Book;
import com.campusconnect.neo4j.types.User;
import com.github.javafaker.Faker;

import java.util.UUID;

/**
 * Created by sn1 on 1/19/15.
 */
public class DataBrewer {
    public static final Faker faker = new Faker();
    public static User getFakeUser(){
        return new User(faker.name().name(), faker.internet().emailAddress());
    }

    public static Book getFakeBook()
    {
        return new Book(faker.name().name(), UUID.randomUUID().toString());
    }
}
