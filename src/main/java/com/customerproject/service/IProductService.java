package com.customerproject.service;

import com.customerproject.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAll();

    ProductDTO save(ProductDTO productDTO);

    ProductDTO findById(Long id);
}
