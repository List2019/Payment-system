package com.epam.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.demo.dto.Users;
import com.epam.demo.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class UserNameAwareInterceptor implements HandlerInterceptor {

    @Autowired
    private UserManager userManager;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        Users currentUser = userManager.getUser();

        //modelAndView.addObject("userName", currentUser.getName());
        modelAndView.addObject("currentUserRole", currentUser.getRole());
    }

}
