package com.customerproject.controller.admin;

import com.customerproject.dto.CustomerDTO;
import com.customerproject.service.impl.CustomerService;
import com.customerproject.util.MessageUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller(value = "controllerOfCustomer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    MessageUtil messageUtil;

    @RequestMapping(value = "/admin/customer-management", method = RequestMethod.GET)
    public ModelAndView showList(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("admin/customer-list");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setListResult(customerService.findAll());
        if (req.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", customerDTO);
        return mav;
    }
}
