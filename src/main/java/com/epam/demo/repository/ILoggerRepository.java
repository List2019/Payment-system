package com.epam.demo.repository;

import com.epam.demo.dto.Logger;

import java.util.List;

public interface ILoggerRepository {

    List<Logger> getAllLogs();
}
