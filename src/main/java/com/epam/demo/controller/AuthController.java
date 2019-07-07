package com.epam.demo.controller;

import com.epam.demo.dto.User;
import com.epam.demo.manager.CreditCardManager;
import com.epam.demo.manager.UserManager;
import com.epam.demo.service.CreditCardService;
import com.epam.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AuthController {

    private CreditCardManager creditCardManager;
    private CreditCardService creditCardService;
    private UserManager userManager;
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView registrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        request.getSession().invalidate();
        return modelAndView;
    }

    @ResponseBody
    @GetMapping("/checkLoginExist")
    public boolean checkLoginExist(String login) {
        return userService.checkUsersByLogin(login).isEmpty();
    }

    @PostMapping("/login")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();

        User currentUser = userService.checkLoginAndPassword(user.getLogin(), user.getPassword());

        if (currentUser != null) {
            userManager.setUser(currentUser);
            creditCardManager.setCreditCard(creditCardService.getCardByNumberCard(currentUser.getNumberCard()));
            modelAndView.setViewName("redirect:/main");
        }

        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registration(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("errors", bindingResult.getAllErrors());
            modelAndView.setViewName("registration");
        } else {
            userService.addUsers(user);
            userManager.setUser(user);
            modelAndView.setViewName("redirect:/main");
        }

        return modelAndView;
    }

    @Autowired
    public AuthController(CreditCardManager creditCardManager, CreditCardService creditCardService, UserManager userManager, UserService userService) {
        this.creditCardManager = creditCardManager;
        this.creditCardService = creditCardService;
        this.userManager = userManager;
        this.userService = userService;
    }
}
