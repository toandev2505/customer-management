package com.customerproject.service.impl;

import com.customerproject.converter.ProductConverter;
import com.customerproject.dto.ProductDTO;
import com.customerproject.entity.ProductEntity;
import com.customerproject.repository.ProductRepository;
import com.customerproject.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> list = new ArrayList<>();
        List<ProductEntity> entities = productRepository.findAll();
        for (ProductEntity item : entities){
            ProductDTO dto = productConverter.toDTO(item);
            list.add(dto);
        }
        return list;
    }

    @Transactional
    @Override
    public ProductDTO save(ProductDTO productDTO) {
        ProductEntity productEntity;
        if (productDTO.getId() != null){
            ProductEntity oldProductEntity = productRepository
                    .findById(productDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            productEntity = productConverter.toEntity(productDTO, oldProductEntity);
        } else {
            productEntity = productConverter.toEntity(productDTO);
        }
        productEntity = productRepository.save(productEntity);
        return productConverter.toDTO(productEntity);
    }

    @Override
    public ProductDTO findById(Long id){
        Optional<ProductEntity> optionalProductEntity = Optional.of(productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found")));
        ProductEntity productEntity = optionalProductEntity.get();
        return productConverter.toDTO(productEntity);
    }
}
