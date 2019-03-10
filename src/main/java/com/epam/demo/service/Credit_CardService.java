package com.epam.demo.service;

import com.epam.demo.repository.Credit_CardRepository;
import com.epam.demo.dto.Credit_Card;
import com.epam.demo.repository.ICredit_CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Credit_CardService implements ICredit_CardService {

    @Autowired
    private Credit_CardRepository credit_cardRepository;

    public List<Credit_Card> getCardByNumberCard(long number_card) {
        return credit_cardRepository.getCardByNumberCard(number_card);
    }

    public void addMoney(double value, long number_card) {
        credit_cardRepository.addMoney(value, number_card);
    }

    public void blockCreditCardByNumberCard(long number_card) {
        credit_cardRepository.blockCreditCardByNumberCard(number_card);
    }

    public List<Credit_Card> checkBalance(double value, long number_card) {
        return credit_cardRepository.checkBalance(value, number_card);
    }

    public void removeMoney(double value, Credit_Card currentCard) {
        credit_cardRepository.removeMoney(value, currentCard);
    }

    public void unblockCreditCardByNumberCard(long number_card) {
        credit_cardRepository.unblockCreditCardByNumberCard(number_card);    }

}
