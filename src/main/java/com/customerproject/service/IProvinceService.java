package com.customerproject.service;

import com.customerproject.dto.ProvinceDTO;

import java.util.List;

public interface IProvinceService {
    List<ProvinceDTO> findAll();
}
