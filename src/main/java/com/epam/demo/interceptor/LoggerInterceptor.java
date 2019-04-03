package com.epam.demo.interceptor;

import com.epam.demo.dto.Credit_Card;
import com.epam.demo.dto.Users;
import com.epam.demo.manager.Credit_CardManager;
import com.epam.demo.manager.UserManager;
import com.epam.demo.service.Credit_CardService;
import com.epam.demo.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class LoggerInterceptor implements HandlerInterceptor {

    @Autowired
    private UserManager userManager;

    @Autowired
    private Credit_CardManager creditCardManager;

    @Autowired
    private LoggerService loggerService;

    @Autowired
    private Credit_CardService creditCardService;

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler, Exception ex) {

        Credit_Card currentCard = creditCardManager.getCredit_card();

        loggerService.addNewRecord(currentCard.getId_users(), LocalDateTime.now(), Double.parseDouble(request.getParameter("value")));

    }
}
