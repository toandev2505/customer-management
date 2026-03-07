package com.customerproject.controller.web;

import com.customerproject.util.MessageUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller(value = "controllerOfHomeWeb")
public class HomeController {
    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homePage(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("web/home");
        if (req.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        return mav;
    }
}
