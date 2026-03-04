package com.customerproject.api.admin;

import com.customerproject.dto.CustomerDTO;
import com.customerproject.service.impl.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerAPI {
    private final CustomerService customerService;
    public CustomerAPI(CustomerService customerService){
        this.customerService = customerService;
    }

    //<--start test
    @GetMapping(value = "/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }

    @GetMapping(value = "/api/admin/customer")
    public List<CustomerDTO> getCustomer(){ return customerService.findAll(); }
    //end test-->

    @PostMapping(value = "/api/admin/customer")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO dto){
        return customerService.save(dto);
    }

    @PutMapping(value = "/api/admin/customer/{id}")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO dto, @PathVariable("id") long id){
        dto.setId(id);
        return customerService.save(dto);
    }

    @DeleteMapping(value = "/api/admin/customer")
    public void deleteCustomers(@RequestBody List<Long> ids){
        customerService.delete(ids);
    }
}
