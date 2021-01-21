package com.github.kadehar.dummyrestapi.filter;

import com.github.kadehar.dummyrestapi.model.Employee;

import java.util.function.Predicate;

public class Filter {
    public Predicate<Employee> salaryGreaterThan(Long value) {
        return employee -> employee.getSalary() > value;
    }

    public Predicate<Employee> nameContains(String sequence) {
        return employee -> employee.getName().contains(sequence);
    }

    public Predicate<Employee> ageGraterThan(Integer value) {
        return employee -> employee.getAge() > value;
    }
}
