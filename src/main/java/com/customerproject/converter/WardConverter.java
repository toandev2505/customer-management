package com.customerproject.converter;

import com.customerproject.dto.WardDTO;
import com.customerproject.entity.WardEntity;
import org.springframework.stereotype.Component;

@Component
public class WardConverter {
    public WardDTO toDTO(WardEntity entity){
        WardDTO dto = new WardDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public WardEntity toEntity(WardDTO dto){
        WardEntity entity = new WardEntity();
        entity.setName(dto.getName());
        return entity;
    }
}
