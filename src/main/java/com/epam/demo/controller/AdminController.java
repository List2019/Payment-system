package com.epam.demo.controller;

import com.epam.demo.dto.Logger;
import com.epam.demo.dto.Number_card;
import com.epam.demo.dto.Users;
import com.epam.demo.manager.Credit_CardManager;
import com.epam.demo.manager.UserManager;
import com.epam.demo.service.Credit_CardService;
import com.epam.demo.service.LoggerService;
import com.epam.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

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

    @GetMapping("/admin")
    public ModelAndView adminpage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("admin");

        return modelAndView;

    }

    @RequestMapping(value = {"/unblocking"}, method = RequestMethod.GET)
    public ModelAndView unblockpage() {

        ModelAndView modelAndView = new ModelAndView();
        List<Users> users =  userService.getUsersWhereBillBlocked();
        modelAndView.addObject("Number_card", new Number_card());
        modelAndView.addObject("users", users);
        modelAndView.setViewName("unblocking");

        return modelAndView;
    }

    @RequestMapping(value = {"/unblocking"},method = RequestMethod.POST)
    public ModelAndView unblockingpage(@ModelAttribute("Number_card") Number_card number_card, BindingResult result, ModelMap model){
        ModelAndView modelAndView = new ModelAndView();

        try{
            creditCardService.unblockCreditCardByNumberCard(number_card.getNumber_card());
            modelAndView.setViewName("redirect:unblocking");
        }
        catch (Exception ex){
            modelAndView.addObject("message","чё то пошло не так");
            modelAndView.setViewName("unblocking");
        }
        return modelAndView;
    }

    @RequestMapping("admin/allusers")
    public ModelAndView alluserspage(HttpServletRequest request,
                                 @PathVariable(name = "pageId", required = false) String pageId) {
        ModelAndView modelAndView = new ModelAndView();

        List<Users> users =  userService.getAllUsers();

        modelAndView.addObject("users", users);

        modelAndView.setViewName("allusers");

        return modelAndView;

    }

    @RequestMapping("admin/log")
    public ModelAndView logpage(HttpServletRequest request,
                                     @PathVariable(name = "pageId", required = false) String pageId) {
        ModelAndView modelAndView = new ModelAndView();

        List<Logger> logs = loggerService.getAllLog();

        modelAndView.addObject("logs", logs);

        modelAndView.setViewName("log");

        return modelAndView;

    }
}
