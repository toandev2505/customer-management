package com.customerproject.converter;

import com.customerproject.dto.ProvinceDTO;
import com.customerproject.entity.ProvinceEntity;
import com.customerproject.entity.WardEntity;
import com.customerproject.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProvinceConverter {
    @Autowired
    private WardRepository wardRepository;

    public ProvinceDTO toDTO(ProvinceEntity entity){
        ProvinceDTO dto = new ProvinceDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        if (entity.getWards() != null) {
            List<Long> wardIds = entity.getWards().stream()
                    .map(WardEntity::getId)
                    .collect(Collectors.toList());
            dto.setWardIds(wardIds);
        }
        return dto;
    }

    public ProvinceEntity toEntity(ProvinceDTO dto){
        ProvinceEntity entity = new ProvinceEntity();
        entity.setName(dto.getName());
        List<WardEntity> wardEntities = wardRepository.findAllByProvinceId(dto.getId());
        entity.setWards(wardEntities);
        return entity;
    }
}
