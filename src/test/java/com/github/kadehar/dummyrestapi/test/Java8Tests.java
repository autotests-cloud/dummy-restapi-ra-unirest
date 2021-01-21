package com.github.kadehar.dummyrestapi.test;

import com.github.kadehar.dummyrestapi.client.RestAssuredClient;
import com.github.kadehar.dummyrestapi.config.APIConfig;
import com.github.kadehar.dummyrestapi.config.Configuration;
import com.github.kadehar.dummyrestapi.filter.EmployeesFilter;
import com.github.kadehar.dummyrestapi.filter.Filter;
import com.github.kadehar.dummyrestapi.model.Employee;
import com.github.kadehar.dummyrestapi.model.EmployeeData;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Java8Tests {
    private static Filter filter;
    private static RestAssuredClient client;

    @BeforeAll
    public static void setUp() {
        filter = new Filter();
        APIConfig config = Configuration.configureAPI();
        RestAssured.filters(Collections.singletonList(new AllureRestAssured()));
        RestAssured.baseURI = config.baseUrl();
        RestAssured.basePath = config.basePath();
        client = new RestAssuredClient();
    }

    @Test
    public void checkEmployeeAge() {
        EmployeeData employeeData = client.getEmployee(1L);
        assertThat(employeeData.getEmployee().getAge(), is(61));
    }

    @Test
    public void getEmployeesOlderThan30Years() {
        List<Employee> employees = client.getEmployees();

        employees = EmployeesFilter.filterEmployees(employees, filter.ageGraterThan(30));

        employees.forEach(employee -> assertThat(employee.getAge(), greaterThan(30)));
    }

    @Test
    public void getEmployeesWithSalaryMoreThan300K() {
        List<Employee> employees = client.getEmployees();

        employees = EmployeesFilter.filterEmployees(employees, filter.salaryGreaterThan(300000L));

        employees.forEach(employee -> assertThat(employee.getSalary(), greaterThan(300000L)));
    }

    @Test
    public void getEmployeesWithIEInName() {
        List<Employee> employees = client.getEmployees();

        employees = EmployeesFilter.filterEmployees(employees, filter.nameContains("ie"));

        employees.forEach(employee -> assertThat(employee.getName(), containsString("ie")));
    }
}
