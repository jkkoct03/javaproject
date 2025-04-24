package com.services;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public Employee fetchEmployee(long id) throws EmployeeNotFoundException {
        throw new EmployeeNotFoundException("employee with id " + id + " not found");
    }
}