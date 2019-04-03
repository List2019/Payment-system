package com.epam.demo.repository;

        import com.epam.demo.dto.Credit_Card;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.jdbc.core.RowMapper;
        import org.springframework.stereotype.Repository;

        import java.math.BigDecimal;
        import java.util.List;

@Repository

public class Credit_CardRepository implements ICredit_CardRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Credit_Card> ROW_MAPPER = (resultSet, rowNumbers) -> new Credit_Card(
            resultSet.getInt("id_users"),
            resultSet.getLong("number_card"),
            resultSet.getBigDecimal("balance"),
            resultSet.getBoolean("block"));

    public Credit_Card checkBalance(BigDecimal value,long number_card){
        String sql = "SELECT * FROM epam.credit_card where number_card = ? and balance >= ?;";
        return jdbcTemplate.queryForObject(sql, new Object[]{number_card,value.intValue()}, ROW_MAPPER);
    }

    public void removeMoney(BigDecimal value, Credit_Card credit_card){
        BigDecimal result = credit_card.getBalance().subtract(value);
        String sql = "UPDATE epam.credit_card SET balance = ? WHERE (number_card = ?);";
        jdbcTemplate.update(sql,result.intValue(),credit_card.getNumber_card());
    }

    public List<Credit_Card> getCardByNumberCard(long number_card){
        String sql = "SELECT * FROM epam.credit_card where number_card = ? ;";
        return jdbcTemplate.query(sql, new Object[]{number_card}, ROW_MAPPER);
    }

    public void addMoney(BigDecimal value, long number_card){
        BigDecimal result = getCardByNumberCard(number_card).get(0).getBalance().add(value);
        String sql = "UPDATE epam.credit_card SET balance = ? WHERE (number_card = ?);";
        jdbcTemplate.update(sql,result.intValue(),number_card);
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
        return jdbcTemplate.queryForObject(sql,Double.class,number_card);
    }



}
