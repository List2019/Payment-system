package com.epam.demo.service;

import com.epam.demo.dto.CreditCard;
import com.epam.demo.dto.User;

import java.math.BigDecimal;
import java.util.List;

public interface ICreditCardService {

    int getIdByNumberCard(long numberCard);

    void deleteCardByNumber(Long numberCard);

    List<CreditCard> getAllCard();

    void addCreditCard (User user, CreditCard creditCard);

    CreditCard getCardByNumberCard(long numberCard);

    void deposit(BigDecimal value, long numberCard);

    void blockCreditCardByNumberCard(long numberCard);

    void unblockCreditCardByNumberCard(long numberCard);

    CreditCard checkBalance(BigDecimal value, long numberCard);

    void withdraw(BigDecimal value, CreditCard currentCard);

    double getBalanceByNumberCard(long numberCard);

    void simpleTransfer(BigDecimal value, CreditCard to, CreditCard from);


}
