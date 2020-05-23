package com.epam.demo.service;

import com.epam.demo.entity.CreditCard;
import com.epam.demo.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface ICreditCardService {

    int getIdByNumberCard(int numberCard);

    void deleteCardByNumber(int numberCard);

    List<CreditCard> getAllCreditCard();

    void addCreditCard (User user, CreditCard creditCard);

    CreditCard getCardByNumberCard(int numberCard);

    void deposit(BigDecimal value, int numberCard);

    void blockCreditCardByNumberCard(int numberCard);

    void unblockCreditCardByNumberCard(int numberCard);

    boolean isBalancePositive(BigDecimal value, int numberCard);

    void withdraw(BigDecimal value, int numberCard);

    double getBalanceByNumberCard(int numberCard);

    void simpleTransfer(BigDecimal value, CreditCard to, CreditCard from);


}
