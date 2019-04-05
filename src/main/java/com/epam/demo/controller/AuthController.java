package com.epam.demo.controller;

import com.epam.demo.dto.Users;
import com.epam.demo.manager.Credit_CardManager;
import com.epam.demo.manager.UserManager;
import com.epam.demo.service.Credit_CardService;
import com.epam.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class    AuthController {

    @Autowired
    private Credit_CardManager creditCardManager;

    @Autowired
    private Credit_CardService creditCardService;

    @Autowired
    private UserManager userManager;

    @Autowired
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

    @PostMapping("/login")
    public ModelAndView login(Users users) {
        ModelAndView modelAndView = new ModelAndView();

        Users currentUser = userService.checkLoginAndPassword(users.getLogin(),users.getPassword());

        if(currentUser != null){
            userManager.setUser(currentUser);
            creditCardManager.setCredit_card(creditCardService.getCardByNumberCard(currentUser.getNumber_card()));
            modelAndView.setViewName("redirect:/main");
        }

        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registration(@Validated Users user,BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        if(bindingResult.hasErrors()){
            modelAndView.addObject("errors",bindingResult.getAllErrors());
            modelAndView.setViewName("registration");
        }
        else {
            userService.addUsers(user);
            userManager.setUser(user);
            modelAndView.setViewName("redirect:/main");
        }

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
}
