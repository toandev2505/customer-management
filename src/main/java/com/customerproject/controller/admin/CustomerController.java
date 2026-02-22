package com.customerproject.controller.admin;

import com.customerproject.dto.CustomerDTO;
import com.customerproject.service.impl.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "controllerOfCustomer")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customer-management", method = RequestMethod.GET)
    public ModelAndView homePage(){
        ModelAndView mav = new ModelAndView("admin/customer");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setListResult(customerService.findAll());
        mav.addObject("model", customerDTO);
        return mav;
    }
}
