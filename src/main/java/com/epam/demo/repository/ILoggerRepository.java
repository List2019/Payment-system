package com.epam.demo.repository;

import com.epam.demo.dto.Logger;

import java.time.LocalDateTime;
import java.util.List;

public interface ILoggerRepository {

    List<Logger> getAllLogs();

    void addNewRecord(int id_users, LocalDateTime time,double balance);
}
