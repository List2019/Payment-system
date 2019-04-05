package com.epam.demo.repository;

import com.epam.demo.dto.Credit_Card;

import java.math.BigDecimal;
import java.util.List;

public interface ICredit_CardRepository {

    Credit_Card checkBalance(BigDecimal value,long number_card);

    void removeMoney(BigDecimal value, Credit_Card credit_card);

    Credit_Card getCardByNumberCard(long number_card);

    void addMoney(BigDecimal value, long number_card);

    void blockCreditCardByNumberCard(long number_card);

    void unblockCreditCardByNumberCard(long number_card);

    double getBalanceByNumberCard(long number_card);

}
