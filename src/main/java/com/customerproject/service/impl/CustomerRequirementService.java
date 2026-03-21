package com.customerproject.service.impl;

import com.customerproject.converter.CustomerRequirementConverter;
import com.customerproject.dto.CustomerRequirementDTO;
import com.customerproject.entity.CustomerRequirementEntity;
import com.customerproject.repository.CustomerRequirementRepository;
import com.customerproject.service.ICustomerRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerRequirementService implements ICustomerRequirementService {
    @Autowired
    private CustomerRequirementRepository customerRequirementRepository;

    @Autowired
    private CustomerRequirementConverter customerRequirementConverter;

    @Override
    public List<CustomerRequirementDTO> findAllByCustomerId(Long customerId){
        List<CustomerRequirementEntity> entities = customerRequirementRepository.findAllByCustomerId(customerId);

        return entities.stream()
                .map(customerRequirementConverter::toDTO)
                .collect(Collectors.toList());
    }
}
