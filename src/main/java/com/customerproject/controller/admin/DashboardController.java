package com.customerproject.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "controllerOfDashboard")
public class DashboardController {
    @RequestMapping(value = "/admin/dashboard", method = RequestMethod.GET)
    public ModelAndView showList(){
        ModelAndView mav = new ModelAndView("admin/dashboard");
        return mav;
    }
}
