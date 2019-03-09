package com.epam.demo.dto;

public class Credit_Card {

    private int id_users;
    private long number_card;
    private double balance;
    private boolean block;

    public Credit_Card(int id_users, long number_card, double balance, boolean block) {
        this.id_users = id_users;
        this.number_card = number_card;
        this.balance = balance;
        this.block = block;
    }

    public int getId_users() {
        return id_users;
    }

    public void setId_users(int id_users) {
        this.id_users = id_users;
    }

    public long getNumber_card() {
        return number_card;
    }

    public void setNumber_card(long number_card) {
        this.number_card = number_card;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }
}
