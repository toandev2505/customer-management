package com.customerproject.service;

import com.customerproject.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    CustomerDTO save(CustomerDTO customerDTO);
    void delete(List<Long> ids);
}
