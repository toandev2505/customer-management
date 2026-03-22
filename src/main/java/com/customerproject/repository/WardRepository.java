package com.customerproject.repository;

import com.customerproject.entity.WardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<WardEntity, Long> {
    List<WardEntity> findAllByProvinceId(Long provinceId);
}
