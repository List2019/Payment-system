package com.epam.demo.service;

import com.epam.demo.dto.User;

import java.util.List;

public interface IUserService {

    User checkLoginAndPassword(String login, String password);

    void addUsers(User user);

    List<User> getUsersWhereBillBlocked();

    List<User> getAllUsers();

    User getUserByNumberCard(Long numberCard);
}
