package com.epam.demo.service;

import com.epam.demo.dto.Users;

import java.util.List;

public interface IUserService {

    Users checkLoginAndPassword(String login, String password);

    void addUsers(Users user);

    List<Users> getUsersWhereBillBlocked();

    List<Users> getAllUsers();
}
