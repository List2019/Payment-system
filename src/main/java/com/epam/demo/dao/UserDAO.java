/*
package com.epam.demo.dao;

import com.epam.demo.entity.User;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public User getUser(){
        Session session= null;
        User user = new User();
        user.setId_users(18);
        return entityManager.find(User.class, user);
    }

}
*/
