package com.github.kadehar.dummyrestapi.client;

import com.github.kadehar.dummyrestapi.model.Employee;
import com.github.kadehar.dummyrestapi.model.EmployeeData;
import io.restassured.http.ContentType;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestAssuredClient {
    public List<Employee> getEmployees() {
        // @formatter: off
        return given()
                    .contentType(ContentType.JSON)
                    .log().uri()
                .when()
                    .get("employees")
                .then()
                    .log().body()
                    .statusCode(200)
                    .extract()
                    .body()
                    .jsonPath()
                    .getList("data", Employee.class);
        // @formatter: on
    }

    public EmployeeData getEmployee(Long id) {
        // @formatter: off
        return given()
                    .contentType(ContentType.JSON)
                    .pathParam("id", id)
                    .log().uri()
                .when()
                    .get("employee/{id}")
                .then()
                    .log().body()
                    .statusCode(200)
                    .extract()
                    .as(EmployeeData.class);
        // @formatter: on
    }
}
