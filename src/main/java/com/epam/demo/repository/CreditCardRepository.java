package com.epam.demo.repository;

import com.epam.demo.entity.CreditCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CreditCardRepository extends MongoRepository<CreditCard, BigInteger> {

   /* void setBalance(int value, long numberCard);

    void setBlock(boolean block, long numberCard);

    void deleteCardByNumberCard(long numberCard);*/

    @Query("{number_card: ?0}")
    CreditCard findByNumberCard(int numberCard);

}
