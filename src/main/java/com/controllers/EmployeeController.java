package com.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.services.Employee;
import com.services.EmployeeNotFoundException;
import com.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/hello")
    public String getMethodName() {
        return "Hello World!";
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Employee> getProduct(@PathVariable String id) throws NumberFormatException, EmployeeNotFoundException {
        // this method throws a "employeenotfoundexception" exception
        return ResponseEntity.ok(employeeService.fetchEmployee(Long.valueOf(id)));
    }
    
}
