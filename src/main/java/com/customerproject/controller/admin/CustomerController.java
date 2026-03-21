package com.customerproject.controller.admin;

import com.customerproject.dto.CustomerDTO;
import com.customerproject.dto.CustomerRequirementDTO;
import com.customerproject.service.ICustomerRequirementService;
import com.customerproject.service.ICustomerService;
import com.customerproject.util.MessageUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller(value = "controllerOfCustomer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerRequirementService customerRequirementService;

    @Autowired
    MessageUtil messageUtil;

    @RequestMapping(value = "/admin/customer-management", method = RequestMethod.GET)
    public ModelAndView showList(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("admin/customer-list");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setListResult(customerService.findAllWithActive());
        if (req.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", customerDTO);
        return mav;
    }

    @RequestMapping(value = "/admin/customer-management/edit", method = RequestMethod.GET)
    public ModelAndView editList(@RequestParam(value = "id", required = false) Long id, HttpServletRequest req){
        ModelAndView mav = new ModelAndView("admin/customer-edit");
        CustomerDTO customerDTO = new CustomerDTO();
        if (id != null){
            customerDTO = customerService.findById(id);
        }
        if (req.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", customerDTO);
        return mav;
    }

    @RequestMapping(value = "/admin/customer-management/detail", method = RequestMethod.GET)
    public ModelAndView showDetail(@RequestParam(value = "id", required = false) Long id, HttpServletRequest req){
        ModelAndView mav = new ModelAndView("admin/customer-detail");
        CustomerDTO customerDTO = new CustomerDTO();
        List<CustomerRequirementDTO> requirementDTOList = new ArrayList<>();
        if (id != null){
            customerDTO = customerService.findById(id);
            requirementDTOList = customerRequirementService.findAllByCustomerId(id);
        }
        if (req.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", customerDTO);
        mav.addObject("requirements", requirementDTOList);
        return mav;
    }

    @RequestMapping(value = "/admin/customer-management/requirement/edit", method = RequestMethod.GET)
    public ModelAndView addRequirementList(@RequestParam(value = "id", required = false) Long id, HttpServletRequest req){
        ModelAndView mav = new ModelAndView("admin/customer-requirement-edit");
        CustomerRequirementDTO customerRequirementDTO = new CustomerRequirementDTO();

        return mav;
    }

    @RequestMapping(value = "/admin/history-customer-management", method = RequestMethod.GET)
    public ModelAndView showUnactiveList(HttpServletRequest req){
        ModelAndView mav = new ModelAndView("admin/history-customer-list");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setListResult(customerService.findAllWithUnactive());
        if (req.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(req.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", customerDTO);
        return mav;
    }
}
