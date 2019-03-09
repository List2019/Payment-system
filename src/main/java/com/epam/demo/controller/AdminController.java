package com.epam.demo.controller;

import com.epam.demo.dto.Logger;
import com.epam.demo.dto.Users;
import com.epam.demo.manager.Credit_CardManager;
import com.epam.demo.manager.UserManager;
import com.epam.demo.service.Credit_CardService;
import com.epam.demo.service.LoggerService;
import com.epam.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private Credit_CardManager credit_cardManager;

    @Autowired
    private Credit_CardService credit_cardService;

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

    @GetMapping("/unblocking")
    public ModelAndView unblockpage() {
        ModelAndView modelAndView = new ModelAndView();

        List<Users> users =  userService.getUsersWhereBillBlocked();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("unblocking");

        return modelAndView;

    }

    @PostMapping("/unblocking")
    public ModelAndView unblockingpage(Long number_card) {
        ModelAndView modelAndView = new ModelAndView();

        credit_cardService.unblockCreditCardByNumberCard(number_card);
            modelAndView.setViewName("redirect:unblocking");

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
