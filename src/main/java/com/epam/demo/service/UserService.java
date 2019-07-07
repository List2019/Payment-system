package com.epam.demo.service;

import com.epam.demo.dto.User;
import com.epam.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private UsersRepository usersRepository;

    public User checkLoginAndPassword(String login, String password) {
        return usersRepository.checkLoginAndPassword(login, password);
    }

    public void addUsers(User user) {
        usersRepository.addUsers(user);
    }

    public List<User> getUsersWhereBillBlocked() {
        return usersRepository.getUsersWhereBillBlocked();
    }

    public List<User> getAllUsers() {
        return usersRepository.getAllUsers();
    }

    public List<User> checkUsersByLogin(String login) {
        return usersRepository.checkUsersByLogin(login);
    }

    public User getUserByNumberCard(Long numberCard) {
        return usersRepository.getUserByNumberCard(numberCard);
    }

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
}
