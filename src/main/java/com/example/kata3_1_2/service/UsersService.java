package com.example.kata3_1_2.service;

import com.example.kata3_1_2.model.User;

import java.util.List;

public interface UsersService {

    List<User> getAll();

    void add(User user);

    void deleteById(Long id);

    User getById(Long id);

    void change(User user);
}
