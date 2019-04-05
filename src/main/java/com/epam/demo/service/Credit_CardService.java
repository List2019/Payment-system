package com.epam.demo.service;

import com.epam.demo.repository.Credit_CardRepository;
import com.epam.demo.dto.Credit_Card;
import com.epam.demo.repository.ICredit_CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class Credit_CardService implements ICredit_CardService {

    @Autowired
    private Credit_CardRepository credit_cardRepository;

    public Credit_Card getCardByNumberCard(long number_card) {
        return credit_cardRepository.getCardByNumberCard(number_card);
    }

    public void addMoney(BigDecimal value, long number_card) {
        credit_cardRepository.addMoney(value, number_card);
    }

    public void blockCreditCardByNumberCard(long number_card) {
        credit_cardRepository.blockCreditCardByNumberCard(number_card);
    }

    public Credit_Card checkBalance(BigDecimal value, long number_card) {
        return credit_cardRepository.checkBalance(value, number_card);
    }

    public void removeMoney(BigDecimal value, Credit_Card currentCard) {
        credit_cardRepository.removeMoney(value, currentCard);
    }

    public void unblockCreditCardByNumberCard(long number_card) {
        credit_cardRepository.unblockCreditCardByNumberCard(number_card);    }

    public double getBalanceByNumberCard(long number_card){
        return credit_cardRepository.getBalanceByNumberCard(number_card);
    }

    public void simpleTransfer(BigDecimal value,long number_card, Credit_Card currentCard){
        credit_cardRepository.checkBalance(value, currentCard.getNumber_card());
        credit_cardRepository.removeMoney(value, currentCard);
        credit_cardRepository.addMoney(value, number_card);
    }

}
