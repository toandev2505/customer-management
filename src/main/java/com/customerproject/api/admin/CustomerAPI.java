package com.customerproject.api.admin;

import com.customerproject.dto.CustomerDTO;
import com.customerproject.dto.CustomerRequirementDTO;
import com.customerproject.service.ICustomerRequirementService;
import com.customerproject.service.ICustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "apiOfCustomer")
@CrossOrigin
public class CustomerAPI {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerRequirementService customerRequirementService;

    //<--start test
    @GetMapping(value = "/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }

    @GetMapping(value = "/api/admin/customer")
    public List<CustomerDTO> getCustomer(){ return customerService.findAllWithActive(); }
    //end test-->

    //api customer
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

    //api history customer
    @DeleteMapping(value = "/api/admin/history-customer")
    public void deleteUnactiveCustomers(@RequestBody List<Long> ids){
        customerService.deleteInactiveObject(ids);
    }

    @PostMapping(value = "/api/admin/history-customer")
    public void recoverCustomers(@RequestBody List<Long> ids){
        customerService.recover(ids);
    }

    //api customer requirement
    @PostMapping("/api/customer/requirement")
    public ResponseEntity<CustomerRequirementDTO> saveRequirement(@RequestBody CustomerRequirementDTO dto) {
        CustomerRequirementDTO result = customerRequirementService.save(dto);
        return ResponseEntity.ok(result);
    }
}
