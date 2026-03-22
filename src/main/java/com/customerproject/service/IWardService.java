package com.customerproject.service;

import com.customerproject.dto.WardDTO;

import java.util.List;

public interface IWardService {
    List<WardDTO> findAll();

    List<WardDTO> findByProvinceId(Long provinceId);
}
