package com.customerproject.service;

import com.customerproject.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findAllWithActive();
    List<CustomerDTO> findAllWithUnactive();
    CustomerDTO findById(Long id);

    CustomerDTO save(CustomerDTO customerDTO);
    void delete(List<Long> ids);
    void recover(List<Long> ids);

    void deleteInactiveObject(List<Long> ids);
}
