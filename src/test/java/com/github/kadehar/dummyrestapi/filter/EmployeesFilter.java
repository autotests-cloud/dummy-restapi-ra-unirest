package com.github.kadehar.dummyrestapi.filter;

import com.github.kadehar.dummyrestapi.model.Employee;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeesFilter {
    public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
        return employees.stream()
                .filter(predicate)
                .collect(Collectors.toList()) ;
    }
}
