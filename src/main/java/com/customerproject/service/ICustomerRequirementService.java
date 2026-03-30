package com.customerproject.service;

import com.customerproject.dto.CustomerRequirementDTO;

import java.util.List;

public interface ICustomerRequirementService {
    List<CustomerRequirementDTO> findAllByCustomerId(Long customerId);
    CustomerRequirementDTO save(CustomerRequirementDTO dto);
}
