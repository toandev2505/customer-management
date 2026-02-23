package com.customerproject.api.admin;

import com.customerproject.dto.CustomerDTO;
import com.customerproject.service.impl.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerAPI {
    private final CustomerService customerService;
    public CustomerAPI(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping(value = "/api/customer")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO dto){
        return customerService.save(dto);
    }

    @PutMapping(value = "/api/customer/{id}")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO dto, @PathVariable("id") long id){
        dto.setId(id);
        return customerService.save(dto);
    }

    @DeleteMapping(value = "/api/customer")
    public void deleteCustomers(@RequestBody List<Long> ids){
        customerService.delete(ids);
    }
}
