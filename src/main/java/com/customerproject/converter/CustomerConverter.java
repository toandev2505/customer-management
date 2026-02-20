package com.customerproject.converter;

import com.customerproject.dto.CustomerDTO;
import com.customerproject.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {
    public CustomerDTO toDTO(CustomerEntity entity){
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhone(entity.getPhone());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CustomerEntity toEntity(CustomerDTO dto){
        CustomerEntity entity = new CustomerEntity();
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    public CustomerEntity toEntity(CustomerDTO dto, CustomerEntity entity){
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
