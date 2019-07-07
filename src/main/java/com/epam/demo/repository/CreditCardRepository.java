package com.epam.demo.repository;

import com.epam.demo.dto.CreditCard;
import com.epam.demo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class CreditCardRepository implements ICreditCardRepository {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<CreditCard> ROW_MAPPER = (resultSet, rowNumbers) -> new CreditCard(
            resultSet.getInt("id_users"),
            resultSet.getLong("number_card"),
            resultSet.getBigDecimal("balance"),
            resultSet.getBoolean("block"));

    public CreditCard checkBalance(BigDecimal value, long number_card) {
        String sql = "SELECT * FROM epam.credit_card where number_card = ? and balance >= ?;";
        return jdbcTemplate.queryForObject(sql, new Object[]{number_card, value.intValue()}, ROW_MAPPER);
    }

    public void withdraw(BigDecimal value, CreditCard credit_card) {
        BigDecimal result = credit_card.getBalance().subtract(value);
        String sql = "UPDATE epam.credit_card SET balance = ? WHERE (number_card = ?);";
        jdbcTemplate.update(sql, result.intValue(), credit_card.getNumberCard());
    }

    public CreditCard getCardByNumberCard(long number_card) {
        String sql = "SELECT * FROM epam.credit_card where number_card = ? ;";
        return jdbcTemplate.queryForObject(sql, new Object[]{number_card}, ROW_MAPPER);
    }

    public void deposit(BigDecimal value, CreditCard current_card) {
        BigDecimal result = current_card.getBalance().add(value);
        String sql = "UPDATE epam.credit_card SET balance = ? WHERE (number_card = ?);";
        jdbcTemplate.update(sql, result.intValue(), current_card.getNumberCard());
    }

    public void blockCreditCardByNumberCard(long number_card) {
        String sql = "UPDATE epam.credit_card SET block = 1 WHERE (number_card = ?);";
        jdbcTemplate.update(sql, number_card);
    }

    public void unblockCreditCardByNumberCard(long number_card) {
        String sql = "UPDATE epam.credit_card SET block = 0 WHERE (number_card = ?);";
        jdbcTemplate.update(sql, number_card);
    }

    public double getBalanceByNumberCard(long number_card) {
        String sql = "SELECT balance FROM epam.credit_card where number_card = ? ;";
        return jdbcTemplate.queryForObject(sql, Double.class, number_card);
    }

    public void addCreditCard(User user, CreditCard credit_card) {
        String sql = "INSERT INTO epam.credit_card (number_card, id_users, balance) VALUES (?,?,?);";

        jdbcTemplate.update(sql,
                credit_card.getNumberCard(),
                user.getIdUser(),
                credit_card.getBalance());
    }

    public List<CreditCard> getAllCard() {
        String sql = "SELECT * FROM epam.credit_card;";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }

    public void deleteCardByNumber(long number_card) {
        String sql = "DELETE FROM epam.credit_card WHERE number_card = ?;";
        jdbcTemplate.update(sql, number_card);
    }

    public int getIdByNumberCard(long number_card){
        String sql = "SELECT id_users FROM epam.credit_card WHERE number_card = ?;";
        return jdbcTemplate.queryForObject(sql, Integer.class, number_card);
    }

    @Autowired
    public CreditCardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
