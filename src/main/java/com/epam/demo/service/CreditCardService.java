package com.epam.demo.service;

import com.epam.demo.entity.CreditCard;
import com.epam.demo.entity.User;
import com.epam.demo.repository.CreditCardRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static com.mongodb.client.model.Aggregates.sort;

@Service
public class CreditCardService implements ICreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void deposit(BigDecimal value, int numberCard) {
        CreditCard currentCard = creditCardRepository.findByNumberCard(numberCard);
        BigDecimal result = currentCard.getBalance().add(value);
        updateBalance(result, numberCard);
    }

    public void withdraw(BigDecimal value, int numberCard) {
        CreditCard currentCard = creditCardRepository.findByNumberCard(numberCard);
        BigDecimal result = currentCard.getBalance().subtract(value);
        updateBalance(result, numberCard);
    }

    public CreditCard getCardByNumberCard(int numberCard) {
        return creditCardRepository.findByNumberCard(numberCard);
    }

    public double getBalanceByNumberCard(int numberCard) {
        return creditCardRepository.findByNumberCard(numberCard).getBalance().intValue();
    }

    public int getIdByNumberCard(int numberCard) {
        CreditCard tempCreditCard = creditCardRepository.findByNumberCard(numberCard);
        return Math.toIntExact(tempCreditCard.getIdUsers().intValue());
    }

    public void deleteCardByNumber(int numberCard) {
        CreditCard creditCardToDelete = creditCardRepository.findByNumberCard(numberCard);
        creditCardRepository.delete(creditCardToDelete);
    }

    public List<CreditCard> getAllCreditCard() {
        /*
        Эта свистопляска тут для того, чтобы выполнить пункт в агрегацией. 
        Нормально её впихнуть не получилось, так как у коллекции тип Document
        */
        MongoCollection<Document> credit_card = mongoTemplate.getCollection("credit_card");

        AggregateIterable<Document> result = credit_card.aggregate(Collections.singletonList(
                sort(Sorts.descending("balance"))
        ));

        for (Document document : result) {
            System.out.println(document.toJson());
        }

        return creditCardRepository.findAll();
    }

    public void addCreditCard(User user, CreditCard creditCard) {
        creditCard.setIdUsers(user.getIdUsers());
        creditCardRepository.save(creditCard);
    }

    public void blockCreditCardByNumberCard(int numberCard) {
        updateBlock(true, numberCard);
    }

    public void unblockCreditCardByNumberCard(int numberCard) {
        updateBlock(false, numberCard);
    }

    public void simpleTransfer(BigDecimal value, CreditCard to, CreditCard from) {
        withdraw(value, from.getNumberCard());
        deposit(value, to.getNumberCard());
    }

    public boolean isBalancePositive(BigDecimal value, int numberCard) {
        CreditCard tempCreditCard = creditCardRepository.findByNumberCard(numberCard);
        return tempCreditCard.getBalance().compareTo(value) >= 0;
    }

    private void updateBalance(BigDecimal result, int numberCard) {
        BasicDBObject setData = new BasicDBObject();
        setData.append("balance", result.intValue());

        BasicDBObject update = new BasicDBObject();
        update.append("$set", setData);

        BasicDBObject searchQuery = new BasicDBObject().append("number_card", numberCard);

        mongoTemplate.getCollection("credit_card").updateOne(searchQuery, update);
    }

    private void updateBlock(boolean newValue, int numberCard) {
        BasicDBObject setData = new BasicDBObject();
        setData.append("block", newValue);

        BasicDBObject update = new BasicDBObject();
        update.append("$set", setData);

        BasicDBObject searchQuery = new BasicDBObject().append("number_card", numberCard);

        mongoTemplate.getCollection("credit_card").updateOne(searchQuery, update);
    }

}
