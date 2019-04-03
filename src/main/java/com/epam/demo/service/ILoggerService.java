package com.epam.demo.service;

import com.epam.demo.dto.Logger;

import java.time.LocalDateTime;
import java.util.List;

public interface ILoggerService {

    List<Logger> getAllLog();

    void addNewRecord(int id_users, LocalDateTime time, double balance);

}
