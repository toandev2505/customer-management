package com.customerproject.controller;

import com.customerproject.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "controllerOfUser")
public class UserController {

    @GetMapping(value = "/login")
    public ModelAndView showLoginPage(){
        return new ModelAndView("login");
    }
}
