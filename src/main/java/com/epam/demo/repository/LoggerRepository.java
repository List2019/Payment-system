package com.epam.demo.repository;

import com.epam.demo.dto.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public class LoggerRepository implements ILoggerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Logger> ROW_MAPPER = (resultSet, rowNumbers) -> new Logger(
            resultSet.getInt("id_transaction"),
            resultSet.getInt("id_users"),
            resultSet.getDate("time_transaction").toLocalDate(),
            resultSet.getDouble("new_balance"));

    public List<Logger> getAllLogs(){
        String sql = "SELECT * FROM epam.logger;";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }

    public void addNewRecord(int id_users,LocalDateTime time, double balance){
        String sql = "INSERT INTO epam.logger (id_users, time_transaction, new_balance) " +
                "VALUES (?,?,?);";
        jdbcTemplate.update(sql,id_users,time,balance);
    }



}
