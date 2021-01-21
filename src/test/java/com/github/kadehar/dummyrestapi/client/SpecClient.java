package com.github.kadehar.dummyrestapi.client;

import com.github.kadehar.dummyrestapi.spec.Spec;
import io.restassured.response.Response;

public class SpecClient {
    public Response getEmployeesResponse() {
        return Spec.request().when().get("employees").then().log().body().extract().response();
    }
}
