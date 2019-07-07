package com.epam.demo.repository;

import com.epam.demo.dto.User;

import java.util.List;

public interface IUsersRepository {

    void addUsers(User user);

    User checkLoginAndPassword(String login, String password);

    List<User> checkUsersByLogin(String login);

    List<User> getAllUsers();

    List<User> getUsersWhereBillBlocked();

    User getUserByNumberCard(Long numberCard);
}
