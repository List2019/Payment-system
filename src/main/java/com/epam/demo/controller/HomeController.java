package com.epam.demo.controller;

import com.epam.demo.dto.Credit_Card;
import com.epam.demo.manager.Credit_CardManager;
import com.epam.demo.manager.UserManager;
import com.epam.demo.service.Credit_CardService;
import com.epam.demo.service.LoggerService;
import com.epam.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;


@Controller
public class HomeController {

    @Autowired
    private Credit_CardManager creditCardManager;

    @Autowired
    private Credit_CardService creditCardService;

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserService userService;

    @Autowired
    private LoggerService loggerService;


    @RequestMapping("/main")
    public ModelAndView mainpage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");

        return modelAndView;

    }

    @GetMapping("/refill")
    public ModelAndView refillpage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("refill");

        return modelAndView;

    }

    @GetMapping("/account_blocking")
    public ModelAndView blockingpage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("account_blocking");

        return modelAndView;

    }

    @PostMapping("/refill")
    public ModelAndView refill(BigDecimal value) {
        ModelAndView modelAndView = new ModelAndView();

        Credit_Card currentCard = creditCardService.getCardByNumberCard(userManager.getUser().getNumber_card());

        if(currentCard.isBlock()){
            modelAndView.addObject("message","К сожалению ваш счёт заблокирован");
        }
        else{
            creditCardService.addMoney(value,userManager.getUser().getNumber_card());
            modelAndView.addObject("message","Пополнение выполнен успешно," +
                    " ваш баланс: " + currentCard.getBalance() + "");
            loggerService.refill(currentCard.getNumber_card(),value);
        }

        modelAndView.setViewName("refill");
        return modelAndView;
    }

    @PostMapping("/account_blocking")
    public ModelAndView blocking() {
        ModelAndView modelAndView = new ModelAndView();

        Credit_Card currentCard = creditCardService.getCardByNumberCard(userManager.getUser().getNumber_card());

        if(currentCard.isBlock()){
            modelAndView.addObject("message","Ваша карта уже заблокированна");
        }
        else{
            creditCardService.blockCreditCardByNumberCard(userManager.getUser().getNumber_card());
            modelAndView.addObject("message","Ваша карта успешно заблокированна");
            loggerService.blocking(userManager.getUser().getNumber_card());
        }
        modelAndView.setViewName("account_blocking");

        return modelAndView;

    }

    @RequestMapping(value = {"/transfer"}, method = RequestMethod.GET)
        public ModelAndView transferpage() {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("transfer");
        return modelAndView;
    }

    @RequestMapping(value = {"/transfer"}, method = RequestMethod.POST)
        public ModelAndView transfer(BigDecimal value, long number_card) {
            ModelAndView modelAndView = new ModelAndView();

            Credit_Card currentCard = creditCardManager.getCredit_card();

            if(currentCard.isBlock()){
                modelAndView.addObject("message","К сожалению ваш счёт заблокирован");
                modelAndView.setViewName("transfer");
            }
            else {

                try{
                    creditCardService.simpleTransfer(value, number_card, currentCard);
                    modelAndView.addObject("message", "Перевод выполнен успешно");
                    loggerService.transfer(currentCard.getNumber_card(),number_card,value);
                }
                catch(EmptyResultDataAccessException ex){
                    modelAndView.addObject("message", "На вашем счету недостаточно средств");
                }

            }
            modelAndView.setViewName("transfer");
            return modelAndView;
        }

}