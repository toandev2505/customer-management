package com.customerproject.service.impl;

import com.customerproject.converter.ProductConverter;
import com.customerproject.dto.ProductDTO;
import com.customerproject.entity.ProductEntity;
import com.customerproject.entity.StatusOfProduct;
import com.customerproject.repository.ProductRepository;
import com.customerproject.repository.WardRepository;
import com.customerproject.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public ProductDTO addImage(ProductDTO productDTO) {
        ProductEntity productEntity = productConverter.toEntity(productDTO);
        productEntity.setStatus(StatusOfProduct.AVAILABLE);
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
