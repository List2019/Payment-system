package com.epam.demo.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class CreditCard {
    @NotNull
    private int idUsers;
    @NotNull
    @Size(min=3, max=3,message = "Номер карты должен иметь всего 3 символа")
    private long numberCard;
    @NotNull
    @PositiveOrZero(message = "Баланс должен быть положительным или равным 0")
    private BigDecimal balance;
    private boolean block;

    public CreditCard() {
    }

    public CreditCard(int idUsers, long numberCard, BigDecimal balance, boolean block) {
        this.idUsers = idUsers;
        this.numberCard = numberCard;
        this.balance = balance;
        this.block = block;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(long numberCard) {
        this.numberCard = numberCard;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "idUsers=" + idUsers +
                ", numberCard=" + numberCard +
                ", balance=" + balance +
                ", block=" + block +
                '}';
    }
}
