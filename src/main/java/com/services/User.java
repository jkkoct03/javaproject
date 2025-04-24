package com.services;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String email;

    // getters and setters
    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', email='%s'}", id, name, email);
    }
}
