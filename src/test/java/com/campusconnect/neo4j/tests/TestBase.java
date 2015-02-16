package com.campusconnect.neo4j.tests;

import com.github.javafaker.Faker;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by sn1 on 1/18/15.
 */
@ContextConfiguration(locations = "classpath*:beans-ws-tests.xml")
public class TestBase extends AbstractTestNGSpringContextTests {
    public static final Faker faker = new Faker();
}

