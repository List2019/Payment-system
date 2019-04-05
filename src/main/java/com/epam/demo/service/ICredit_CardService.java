package com.epam.demo.service;

import com.epam.demo.dto.Credit_Card;

import java.math.BigDecimal;
import java.util.List;

public interface ICredit_CardService {

    Credit_Card getCardByNumberCard(long number_card);

    void addMoney(BigDecimal value, long number_card);

    void blockCreditCardByNumberCard(long number_card);

    void unblockCreditCardByNumberCard(long number_card);

    Credit_Card checkBalance(BigDecimal value, long number_card);

    void removeMoney(BigDecimal value, Credit_Card currentCard);

    double getBalanceByNumberCard(long number_card);

    void simpleTransfer(BigDecimal value,long number_card, Credit_Card currentCard);


}
