package com.github.kadehar.dummyrestapi.spec;

import com.github.kadehar.dummyrestapi.config.APIConfig;
import com.github.kadehar.dummyrestapi.config.Configuration;
import io.restassured.specification.RequestSpecification;

import static com.github.kadehar.dummyrestapi.template.ReportTemplate.filters;
import static io.restassured.RestAssured.given;

public class Spec {
    private final static APIConfig CONFIG = Configuration.configureAPI();

    public static RequestSpecification request() {
        return given()
                .baseUri(CONFIG.baseUrl())
                .basePath(CONFIG.basePath())
                .filter(filters().customTemplates())
                .log().uri();
    }
}
