package com.epam.demo.repository;

import com.epam.demo.dto.CreditCard;
import com.epam.demo.dto.User;

import java.math.BigDecimal;
import java.util.List;

public interface ICreditCardRepository {

    int getIdByNumberCard(long number_card);

    void deleteCardByNumber(long number_card);

    List<CreditCard> getAllCard();

    void addCreditCard(User user, CreditCard credit_card);

    CreditCard checkBalance(BigDecimal value, long number_card);

    void withdraw(BigDecimal value, CreditCard credit_card);

    CreditCard getCardByNumberCard(long number_card);

    void deposit(BigDecimal value, CreditCard current_card);

    void blockCreditCardByNumberCard(long number_card);

    void unblockCreditCardByNumberCard(long number_card);

    double getBalanceByNumberCard(long number_card);

}
