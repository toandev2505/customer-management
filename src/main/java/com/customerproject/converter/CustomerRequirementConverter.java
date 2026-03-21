package com.customerproject.converter;

import com.customerproject.dto.CustomerRequirementDTO;
import com.customerproject.entity.CustomerEntity;
import com.customerproject.entity.CustomerRequirementEntity;
import com.customerproject.entity.WardEntity;
import com.customerproject.repository.CustomerRepository;
import com.customerproject.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerRequirementConverter {
    @Autowired
    private WardRepository wardRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerRequirementDTO toDTO(CustomerRequirementEntity entity) {
        CustomerRequirementDTO dto = new CustomerRequirementDTO();
        dto.setId(entity.getId());

        if (entity.getCustomer() != null) {
            dto.setId(entity.getCustomer().getId());
        }

        dto.setMinPrice(entity.getMinPrice());
        dto.setMaxPrice(entity.getMaxPrice());
        dto.setPreferredArea(entity.getPreferredArea());
        dto.setPropertyType(entity.getPropertyType());
        dto.setNote(entity.getNote());

        if (entity.getPreferredWards() != null) {
            List<Long> wardIds = entity.getPreferredWards().stream()
                    .map(WardEntity::getId)
                    .collect(Collectors.toList());
            dto.setPreferredWardIds(wardIds);

            List<String> wardNames = entity.getPreferredWards().stream()
                    .map(WardEntity::getName)
                    .collect(Collectors.toList());
            dto.setWardNames(wardNames);
        }

        return dto;
    }

    public CustomerRequirementEntity toEntity(CustomerRequirementDTO dto) {
        CustomerRequirementEntity entity = new CustomerRequirementEntity();

        entity.setMinPrice(dto.getMinPrice());
        entity.setMaxPrice(dto.getMaxPrice());
        entity.setPreferredArea(dto.getPreferredArea());
        entity.setPropertyType(dto.getPropertyType());
        entity.setNote(dto.getNote());

        if (dto.getCustomerId() != null) {
            CustomerEntity customer = customerRepository.findById(dto.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
            entity.setCustomer(customer);
        }

        if (dto.getPreferredWardIds() != null && !dto.getPreferredWardIds().isEmpty()) {
            List<WardEntity> wards = wardRepository.findAllById(dto.getPreferredWardIds());
            entity.setPreferredWards(wards);
        }

        return entity;
    }
}
