package com.customerproject.repository;

import com.customerproject.entity.CustomerRequirementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRequirementRepository extends JpaRepository<CustomerRequirementEntity, Long> {
    List<CustomerRequirementEntity> findAllByCustomerId(Long customerId);
}
