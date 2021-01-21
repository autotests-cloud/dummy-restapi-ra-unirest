package com.github.kadehar.dummyrestapi.test;

import com.github.kadehar.dummyrestapi.client.SpecClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;

public class GroovyTests {
    private static SpecClient client;

    @BeforeAll
    public static void setUp() {
        client = new SpecClient();
    }

    @Test
    public void getEmployeesWithIdGraterThan10() {
        Response response = client.getEmployeesResponse();
        assertThat(response.path("data.id.findAll{it.toInteger() > 10}.collect{it.toInteger()}"),
                everyItem(greaterThan(10)));
    }
}
