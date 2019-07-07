package com.epam.demo.controller;

import com.epam.demo.dto.CreditCard;
import com.epam.demo.dto.User;
import com.epam.demo.manager.CreditCardManager;
import com.epam.demo.manager.UserManager;
import com.epam.demo.service.CreditCardService;
import com.epam.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import javax.validation.Valid;
import java.math.BigDecimal;

@Controller
public class HomeController {

    private CreditCardManager creditCardManager;
    private CreditCardService creditCardService;
    private UserManager userManager;
    private UserService userService;

    private static final Logger log = Logger.getLogger(HomeController.class);

    @RequestMapping("/main")
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @GetMapping("/createCard")
    public ModelAndView creditCardPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createCard");
        return modelAndView;
    }

    @GetMapping("/refill")
    public ModelAndView refillPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("refill");
        return modelAndView;
    }

    @GetMapping("/accountBlocking")
    public ModelAndView blockingPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("accountBlocking");
        return modelAndView;
    }

    @GetMapping("/transfer")
    public ModelAndView transferPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("transfer");
        return modelAndView;
    }


    @PostMapping("/createCard")
    public ModelAndView createCard( CreditCard creditCard, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("errors", bindingResult.getAllErrors());
        } else {
            if (creditCardService.getCardByNumberCard(creditCard.getNumberCard()) == null) {
                User currentUser = userManager.getUser();
                creditCardService.addCreditCard(currentUser, creditCard);
                modelAndView.addObject("message", "Карта успешно зарегистрирована");
            } else {
                modelAndView.addObject("message", "Карта с таким номером уже сущевствует");
            }
        }

        modelAndView.setViewName("createCard");
        return modelAndView;
    }

    @PostMapping("/refill")
    public ModelAndView refill(BigDecimal value) {
        ModelAndView modelAndView = new ModelAndView();

        CreditCard currentCard = creditCardService.getCardByNumberCard(userManager.getUser().getNumberCard());

        if (currentCard.isBlock()) {
            modelAndView.addObject("message", "К сожалению ваш счёт заблокирован");
        } else {
            creditCardService.deposit(value, userManager.getUser().getNumberCard());
            modelAndView.addObject("message", "Пополнение выполнен успешно," +
                    " ваш баланс: " + creditCardService.getBalanceByNumberCard(currentCard.getNumberCard()) + "");
            log.info("Пополнение " + currentCard.getNumberCard() + " на " + value.intValue());

        }

        modelAndView.setViewName("refill");
        return modelAndView;
    }

    @PostMapping("/accountBlocking")
    public ModelAndView blocking() {
        ModelAndView modelAndView = new ModelAndView();

        CreditCard currentCard = creditCardService.getCardByNumberCard(userManager.getUser().getNumberCard());

        if (currentCard.isBlock()) {
            modelAndView.addObject("message", "Ваша карта уже заблокированна");
        } else {
            creditCardService.blockCreditCardByNumberCard(userManager.getUser().getNumberCard());
            modelAndView.addObject("message", "Ваша карта успешно заблокированна");
            log.info("Пользователь " + currentCard.getNumberCard() + " заблокировал счёт");
        }
        modelAndView.setViewName("accountBlocking");

        return modelAndView;

    }

    @PostMapping("/transfer")
    public ModelAndView transfer(BigDecimal value, long numberCard) {
        ModelAndView modelAndView = new ModelAndView();

        CreditCard from = creditCardManager.getCreditCard();
        CreditCard to = creditCardService.getCardByNumberCard(numberCard);

        if (from.isBlock()) {
            modelAndView.addObject("message", "К сожалению ваш счёт заблокирован");
            modelAndView.setViewName("transfer");
        } else {

            try {
                creditCardService.simpleTransfer(value, to, from);
                modelAndView.addObject("message", "Перевод выполнен успешно");
                log.info("Перевод от " + from.getNumberCard() + " к " + to.getNumberCard() + " на сумму " + value.intValue());


            } catch (EmptyResultDataAccessException ex) {
                modelAndView.addObject("message", "На вашем счету недостаточно средств");
            }

        }
        modelAndView.setViewName("transfer");
        return modelAndView;
    }

    @Autowired
    public HomeController(CreditCardManager creditCardManager, CreditCardService creditCardService, UserManager userManager, UserService userService) {
        this.creditCardManager = creditCardManager;
        this.creditCardService = creditCardService;
        this.userManager = userManager;
        this.userService = userService;
    }
}