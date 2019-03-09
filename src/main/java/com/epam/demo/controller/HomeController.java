package com.epam.demo.controller;

import com.epam.demo.dto.Credit_Card;
import com.epam.demo.dto.Users;
import com.epam.demo.manager.Credit_CardManager;
import com.epam.demo.manager.UserManager;
import com.epam.demo.service.Credit_CardService;
import com.epam.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private Credit_CardManager credit_cardManager;

    @Autowired
    private Credit_CardService credit_cardService;

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserService userService;


    @RequestMapping("/main")
    public ModelAndView mainpage(HttpServletRequest request,
                                 @PathVariable(name = "pageId", required = false) String pageId) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");

        return modelAndView;

    }

    @GetMapping("/refill")
    public ModelAndView refillpage(Users user) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("refill");

        return modelAndView;

    }

    @GetMapping("/transfer")
    public ModelAndView transferpage(Users user) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("transfer");

        return modelAndView;

    }

    @GetMapping("/account_blocking")
    public ModelAndView blockingpage(Users user) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("account_blocking");

        return modelAndView;

    }

    @PostMapping("/refill")
    public ModelAndView refill(double value) {
        ModelAndView modelAndView = new ModelAndView();

        Credit_Card currentCard = credit_cardService.getCardByNumberCard(userManager.getUser().getNumber_card());

        if(currentCard.isBlock()){
            modelAndView.addObject("message","К сожалению ваш счёт заблокирован");
            modelAndView.setViewName("refill");
        }
        else{
            credit_cardService.addMoney(value,userManager.getUser().getNumber_card());
            modelAndView.addObject("message","Пополнение выполнен успешно, ваш баланс: " + currentCard.getBalance() + "");
            modelAndView.setViewName("refill");
        }

        return modelAndView;
    }

    @PostMapping("/account_blocking")
    public ModelAndView blocking(Users user) {
        ModelAndView modelAndView = new ModelAndView();
        credit_cardService.blockCreditCardByNumberCard(userManager.getUser().getNumber_card());
        modelAndView.addObject("message","Ваша карта успешно заблокированна");
        modelAndView.setViewName("account_blocking");

        return modelAndView;

    }

    @PostMapping("/transfer")
    public ModelAndView transfer(double value, long number_card,Users user) {
        ModelAndView modelAndView = new ModelAndView();

        Credit_Card currentCard = credit_cardManager.getCredit_card();

        if(currentCard.isBlock()){
            modelAndView.addObject("message","К сожалению ваш счёт заблокирован");
            modelAndView.setViewName("refill");
        }
        else {
            if (credit_cardService.checkBalance(value, user.getNumber_card()) != null) {
                credit_cardService.removeMoney(value, currentCard);
                credit_cardService.addMoney(value, number_card);
                modelAndView.addObject("message", "Перевод выполнен успешно");
                modelAndView.setViewName("transfer");
            }
            else{
                modelAndView.addObject("message", "На вашем счету недостаточно средств");
            }
        }

        return modelAndView;
    }

}