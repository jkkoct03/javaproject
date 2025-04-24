package com.services;

public class EmployeeNotFoundException extends Exception{

    private String msg;

    public EmployeeNotFoundException(String exception){
        this.msg = exception;
    }


    @Override
    public String toString() {
        return "UserNotFoundException" + msg;
    }
}
