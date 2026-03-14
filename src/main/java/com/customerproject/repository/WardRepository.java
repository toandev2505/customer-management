package com.customerproject.repository;

import com.customerproject.entity.WardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardRepository extends JpaRepository<WardEntity, Long> {
}
