package com.customerproject.converter;

import com.customerproject.dto.ProductDTO;
import com.customerproject.entity.ProductEntity;
import com.customerproject.entity.WardEntity;
import com.customerproject.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class ProductConverter {
    @Autowired
    private WardRepository wardRepository;

    public ProductDTO toDTO(ProductEntity entity){
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setType(entity.getType());
        dto.setAddress(entity.getAddress());
        if (entity.getWard() != null) {
            List<Long> wardIds = new ArrayList<>();
            wardIds.add(entity.getWard().getId());
            dto.setWardId(wardIds);

            dto.setWardName(entity.getWard().getName());

            if (entity.getWard().getProvince() != null) {
                dto.setProvinceId(entity.getWard().getProvince().getId());
                dto.setProvinceName(entity.getWard().getProvince().getName());
            }
        }
        dto.setPrice(entity.getPrice());
        dto.setArea(entity.getArea());
        dto.setBedrooms(entity.getBedrooms());
        dto.setDirection(entity.getDirection());
        dto.setStatus(entity.getStatus());
        dto.setImageName(entity.getImageName());
        dto.setBase64Image(entity.getImageName());
        if (entity.getImageData() != null && entity.getImageData().length > 0) {
            String base64 = Base64.getEncoder().encodeToString(entity.getImageData());

            String fullBase64 = "data:" + entity.getImageType() + ";base64," + base64;
            dto.setBase64Image(fullBase64);
        }
        if (entity.getWard() != null) {
            dto.setWardName(entity.getWard().getName());

            if (entity.getWard().getProvince() != null) {
                dto.setProvinceId(entity.getWard().getProvince().getId());
                dto.setProvinceName(entity.getWard().getProvince().getName());
            }
        }
        return dto;
    }

    public ProductEntity toEntity(ProductDTO dto){
        return toEntity(dto, new ProductEntity());
    }

    public ProductEntity toEntity(ProductDTO dto, ProductEntity entity){
        entity.setTitle(dto.getTitle());
        entity.setType(dto.getType());
        entity.setAddress(dto.getAddress());
        if (dto.getWardId() != null && !dto.getWardId().isEmpty()) {
            Long idToSave = dto.getWardId().get(0);
            WardEntity ward = wardRepository.findById(idToSave)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Quận"));
            entity.setWard(ward);
        }
        entity.setPrice(dto.getPrice());
        entity.setArea(dto.getArea());
        entity.setBedrooms(dto.getBedrooms());
        entity.setDirection(dto.getDirection());
        entity.setStatus(dto.getStatus());

        MultipartFile file = dto.getImageFile();
        if (file != null && !file.isEmpty()) {
            try {
                entity.setImageData(file.getBytes());

                entity.setImageName(file.getOriginalFilename());

                entity.setImageType(file.getContentType());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return entity;
    }
}
