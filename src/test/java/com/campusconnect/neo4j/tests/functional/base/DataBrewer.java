package com.campusconnect.neo4j.tests.functional.base;

import com.campusconnect.neo4j.types.Address;
import com.campusconnect.neo4j.types.AddressType;
import com.campusconnect.neo4j.types.Book;
import com.campusconnect.neo4j.types.User;
import com.github.javafaker.Faker;

import java.util.*;

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
    
    public static User getFakeUserWithAddress() {
        User user = new User(faker.name().name(), faker.internet().emailAddress());
        Set<Address> addresses = new HashSet<>();
        addresses.add(getFakeAddress(AddressType.HOME.toString()));
        user.setAddresses(addresses);
        return user;
    }
    
    public static User getUserWithTwoAddresses() {
        User user = getFakeUser();
        Set<Address> addresses = new HashSet<>();
        addresses.add(getFakeAddress(AddressType.HOME.toString()));
        addresses.add(getFakeAddress(AddressType.WORK.toString()));
        user.setAddresses(addresses);
        return user;
    }
    
    public static Address getFakeAddress(String addressType) {
        Address address = new Address();
        address.setAddressLine1(faker.address().streetAddressNumber());
        address.setAddressLine2(faker.address().secondaryAddress());
        address.setAddressType(addressType);
        address.setLandmark(faker.address().citySuffix());
        address.setCity(faker.address().citySuffix());
        address.setState(faker.address().stateAbbr());
        address.setCountry(faker.address().country());
        address.setZipCode(faker.address().zipCode());
        return address;
    }
}
