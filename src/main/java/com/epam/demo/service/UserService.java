package com.epam.demo.service;

import com.epam.demo.repository.UsersRepository;
import com.epam.demo.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private UsersRepository usersRepository;

    public Users checkLoginAndPassword(String login, String password) {
        return usersRepository.checkLoginAndPassword(login, password);
    }

    public void addUsers(Users user) {
        usersRepository.addUsers(user);
    }

    public List<Users> getUsersWhereBillBlocked() {
        return usersRepository.getUsersWhereBillBlocked();
    }

    public List<Users> getAllUsers() {
        return usersRepository.getAllUsers();
    }

    public  List<Users> checkUsersByLogin(String login) {
        return usersRepository.checkUsersByLogin(login);
    }

}
