package com.customerproject.service.impl;

import com.customerproject.converter.CustomerConverter;
import com.customerproject.dto.CustomerDTO;
import com.customerproject.entity.CustomerEntity;
import com.customerproject.repository.CustomerRepository;
import com.customerproject.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public List<CustomerDTO> findAll() {
        List<CustomerDTO> list = new ArrayList<>();
        List<CustomerEntity> entities = customerRepository.findAll();
        for (CustomerEntity item : entities) {
            CustomerDTO customerDTO = customerConverter.toDTO(item);
            list.add(customerDTO);
        }
        return list;
    }

    @Override
    public CustomerDTO findById(Long id){
        Optional<CustomerEntity> optionalCustomerEntity = Optional.of(customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found")));
        CustomerEntity customerEntity = optionalCustomerEntity.get();
        return customerConverter.toDTO(customerEntity);
    }

    @Override
    @Transactional
    public CustomerDTO save(CustomerDTO customerDTO){
        CustomerEntity customerEntity;
        if (customerDTO.getId() != null){
            CustomerEntity oldCustomerEntity = customerRepository
                    .findById(customerDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));

            customerEntity = customerConverter.toEntity(customerDTO, oldCustomerEntity);
        } else{
            customerEntity = customerConverter.toEntity(customerDTO);
            customerEntity.setStatus(1);
        }
        customerEntity = customerRepository.save(customerEntity);
        return customerConverter.toDTO(customerEntity);
    }

    @Override
    @Transactional
    public void delete(List<Long> ids) {
        customerRepository.softDeleteByIds(ids);
    }
}
