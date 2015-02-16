package com.campusconnect.neo4j.tests;

import com.campusconnect.neo4j.types.User;
import com.github.javafaker.Faker;

/**
 * Created by sn1 on 1/19/15.
 */
public class DataBrewer {
    public static User getFakeUser(Faker faker){
        return new User(faker.name().name(), faker.internet().emailAddress());
    }
}
