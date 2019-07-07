package com.epam.demo.service;

import com.epam.demo.dto.CreditCard;
import com.epam.demo.dto.User;
import com.epam.demo.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CreditCardService implements ICreditCardService {

    private CreditCardRepository creditCardRepository;

    public CreditCard getCardByNumberCard(long numberCard) {
        return creditCardRepository.getCardByNumberCard(numberCard);
    }

    public void deposit(BigDecimal value, long numberCard) {
        creditCardRepository.deposit(value, getCardByNumberCard(numberCard));
    }

    public void blockCreditCardByNumberCard(long numberCard) {
        creditCardRepository.blockCreditCardByNumberCard(numberCard);
    }

    public CreditCard checkBalance(BigDecimal value, long numberCard) {
        return creditCardRepository.checkBalance(value, numberCard);
    }

    public void withdraw(BigDecimal value, CreditCard currentCard) {
        creditCardRepository.withdraw(value, currentCard);
    }

    public void unblockCreditCardByNumberCard(long numberCard) {
        creditCardRepository.unblockCreditCardByNumberCard(numberCard);
    }

    public double getBalanceByNumberCard(long numberCard) {
        return creditCardRepository.getBalanceByNumberCard(numberCard);
    }

    public void simpleTransfer(BigDecimal value, CreditCard to, CreditCard from) {
        CreditCard first = from;
        CreditCard second = to;

        if (first.getIdUsers() < second.getIdUsers()) {
            first = to;
            second = from;
        }
        synchronized (first) {
            synchronized (second) {
                creditCardRepository.checkBalance(value, from.getNumberCard());
                creditCardRepository.withdraw(value, from);
                creditCardRepository.deposit(value, to);
            }
        }

    }

    public void addCreditCard(User user, CreditCard creditCard) {
        creditCardRepository.addCreditCard(user, creditCard);
    }

    public List<CreditCard> getAllCard() {
        return creditCardRepository.getAllCard();
    }

    public void deleteCardByNumber(Long numberCard) {
        creditCardRepository.deleteCardByNumber(numberCard);
    }

    public int getIdByNumberCard(long numberCard) {
        return creditCardRepository.getIdByNumberCard(numberCard);
    }

    @Autowired
    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }
}
