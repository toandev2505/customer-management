package com.customerproject.service.impl;

import com.customerproject.converter.ProvinceConverter;
import com.customerproject.dto.ProvinceDTO;
import com.customerproject.entity.ProvinceEntity;
import com.customerproject.repository.ProvinceRepository;
import com.customerproject.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private ProvinceConverter provinceConverter;

    @Override
    public List<ProvinceDTO> findAll() {
        List<ProvinceDTO> list = new ArrayList<>();
        List<ProvinceEntity> entities = provinceRepository.findAll();
        for (ProvinceEntity item : entities){
            ProvinceDTO dto = provinceConverter.toDTO(item);
            list.add(dto);
        }
        return list;
    }
}
