package com.customerproject.service;

import com.customerproject.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAll();

    ProductDTO addImage(ProductDTO productDTO);

    ProductDTO findById(Long id);
}
