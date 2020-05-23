package com.epam.demo.service;

import com.epam.demo.entity.User;
import com.epam.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    public User checkLoginAndPassword(String login, String password){
        return userRepository.findByLoginAndPassword(login,password);
    }

    public void addUsers(User user){ userRepository.save(user);
    }

    public User findUserByNumberCard(int numberCard){
        return userRepository.findByCardNumber(numberCard);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

   /* public List<User> getUsersWhereBillBlocked(){
        List<User> users = userRepository.findAll();
        return userRepository.getUsersWhereBillBlocked();
    }*/


    public User checkUsersByLogin(String login){
        return userRepository.findByLogin(login);
    }

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
