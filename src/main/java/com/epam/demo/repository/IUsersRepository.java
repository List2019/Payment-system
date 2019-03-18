package com.epam.demo.repository;

import com.epam.demo.dto.Users;
import java.util.List;

public interface IUsersRepository {

    void addUsers(Users user);

    Users checkLoginAndPassword(String login, String password);

    List<Users> checkUsersByLogin(String login);

    List<Users> getAllUsers();

    List<Users> getUsersWhereBillBlocked();
}
