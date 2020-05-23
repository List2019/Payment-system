package com.epam.demo.repository;

import com.epam.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    //TO-DO тут надо подумать
    /*@Query("{login: ?0, password:?0}")
    List<User> getUsersWhereBillBlocked();*/

    User findByLoginAndPassword(String login, String password);

    @Query("{number_card: ?0}")
    User findByCardNumber(int numberCard);

    User findByLogin(String login);

}
