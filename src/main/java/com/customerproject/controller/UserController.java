package com.customerproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "controllerOfUser")
public class UserController {

    @GetMapping(value = "/login")
    public ModelAndView showLoginPage(){
        return new ModelAndView("login");
    }

    @GetMapping(value = "/access-denied")
    public ModelAndView accessDenied(){
        return new ModelAndView("redirect:/home?message=accessDenied");
    }
}
