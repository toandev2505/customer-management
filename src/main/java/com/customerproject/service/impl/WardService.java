package com.customerproject.service.impl;

import com.customerproject.converter.WardConverter;
import com.customerproject.dto.WardDTO;
import com.customerproject.entity.WardEntity;
import com.customerproject.repository.WardRepository;
import com.customerproject.service.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WardService implements IWardService {
    @Autowired
    private WardRepository wardRepository;

    @Autowired
    private WardConverter wardConverter;

    @Override
    public List<WardDTO> findAll() {
        List<WardDTO> list = new ArrayList<>();
        List<WardEntity> entities = wardRepository.findAll();
        for (WardEntity item : entities){
            WardDTO dto = wardConverter.toDTO(item);
            list.add(dto);
        }
        return list;
    }
}
