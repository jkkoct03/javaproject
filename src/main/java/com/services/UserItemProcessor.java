package com.services;

import org.springframework.batch.item.ItemProcessor;

public class UserItemProcessor implements ItemProcessor<User, User> {
    @SuppressWarnings("null")
    @Override
    public User process(User user) {
        user.setName(user.getName().toUpperCase());
        return user;
    }
}
