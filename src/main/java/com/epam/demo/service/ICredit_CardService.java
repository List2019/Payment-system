package com.epam.demo.service;

import com.epam.demo.dto.Credit_Card;

public interface ICredit_CardService {

    Credit_Card getCardByNumberCard(long number_card);

    void addMoney(double value, long number_card);

    void blockCreditCardByNumberCard(long number_card);

    void unblockCreditCardByNumberCard(long number_card);

    Credit_Card checkBalance(double value, long number_card);

    void removeMoney(double value, Credit_Card currentCard);


}
