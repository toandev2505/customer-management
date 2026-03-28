package com.customerproject.service.impl;

import com.customerproject.converter.ProductConverter;
import com.customerproject.dto.ProductDTO;
import com.customerproject.entity.ProductEntity;
import com.customerproject.entity.WardEntity;
import com.customerproject.repository.ProductRepository;
import com.customerproject.service.IProductService;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @PersistenceContext
    private EntityManager entityManager;

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
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với ID: " + id));
        return productConverter.toDTO(productEntity);
    }

    @Override
    public List<ProductDTO> search(ProductDTO modelSearch) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> cq = cb.createQuery(ProductEntity.class);
        Root<ProductEntity> root = cq.from(ProductEntity.class);
        List<Predicate> predicates = new ArrayList<>();

        if (modelSearch.getType() != null) {
            predicates.add(cb.equal(root.get("type"), modelSearch.getType()));
        }

        if (modelSearch.getWardId() != null && !modelSearch.getWardId().isEmpty()) {
            Join<ProductEntity, WardEntity> wardJoin = root.join("ward");
            predicates.add(wardJoin.get("id").in(modelSearch.getWardId()));
        }

//        if (modelSearch.getMinPrice() != null) {
//            predicates.add(cb.ge(root.get("price"), modelSearch.getMinPrice()));
//        }
//        if (modelSearch.getMaxPrice() != null) {
//            predicates.add(cb.le(root.get("price"), modelSearch.getMaxPrice()));
//        }

        if (StringUtils.isNotBlank(modelSearch.getTitle())) {
            predicates.add(cb.like(root.get("title"), "%" + modelSearch.getTitle() + "%"));
        }

        if (modelSearch.getProvinceId() != null) {
            Join<ProductEntity, WardEntity> wardJoin = root.join("ward");
            predicates.add(cb.equal(wardJoin.get("province").get("id"), modelSearch.getProvinceId()));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        cq.orderBy(cb.desc(root.get("id")));

        List<ProductEntity> entities = entityManager.createQuery(cq).getResultList();

        return entities.stream()
                .map(productConverter::toDTO)
                .collect(Collectors.toList());
    }
}
