package com.epam.demo.dto;

import java.time.LocalDate;

public class Logger {

    private int id_transaction;
    private int id_users;
    private LocalDate time_transaction;
    private double new_balance;

    public Logger(int id_transaction, int id_users, LocalDate time_transaction, double new_balance) {
        this.id_transaction = id_transaction;
        this.id_users = id_users;
        this.time_transaction = time_transaction;
        this.new_balance = new_balance;
    }

    public int getId_transaction() {
        return id_transaction;
    }

    public int getId_users() {
        return id_users;
    }

    public LocalDate getTime_transaction() {
        return time_transaction;
    }

    public double getNew_balance() {
        return new_balance;
    }
}
