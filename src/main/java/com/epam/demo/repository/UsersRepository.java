package com.epam.demo.repository;

import com.epam.demo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepository implements IUsersRepository {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> ROW_MAPPER = (resultSet, rowNumbers) -> new User(
            resultSet.getInt("id_users"),
            resultSet.getString("name"),
            resultSet.getString("last_name"),
            resultSet.getLong("number_card"),
            resultSet.getString("password"),
            resultSet.getString("login"),
            resultSet.getString("role"),
            resultSet.getString("email"));

    public void addUsers(User user) {

        String sql = "INSERT INTO epam.users (name, last_name, number_card, password, login, email)" +
                " VALUES (?,?,?,?,?,?);";

        jdbcTemplate.update(sql,
                user.getName(),
                user.getLastName(),
                user.getNumberCard(),
                user.getPassword(),
                user.getLogin(),
                user.getEmail());
    }

    public User checkLoginAndPassword(String login, String password) {
        String sql = "SELECT * FROM epam.users where login = ? and password = ? ;";
        return jdbcTemplate.queryForObject(sql, new Object[]{login, password}, ROW_MAPPER);
    }

    public List<User> checkUsersByLogin(String login) {
        String sql = "SELECT * FROM epam.users where login = ? ;";
        return jdbcTemplate.query(sql, new Object[]{login}, ROW_MAPPER);
    }

    public List<User> getAllUsers() {
        String sql = "SELECT users.*, credit_card.balance, credit_card.block  " +
                "FROM epam.users join credit_card on users.id_users = credit_card.id_users;";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }

    public List<User> getUsersWhereBillBlocked() {
        String sql = " SELECT users.* FROM epam.users, credit_card " +
                "WHERE users.id_users = credit_card.id_users AND credit_card.block = 1;";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }

    public User getUserByNumberCard(Long numberCard){
        String sql = "SELECT * FROM epam.users where number_card = ?;";
        return jdbcTemplate.queryForObject(sql, new Object[]{numberCard}, ROW_MAPPER);
    }

    @Autowired
    public UsersRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
