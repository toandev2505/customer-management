package com.customerproject.repository;

import com.customerproject.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    List<RoleEntity> findByCodeIn(List<String> codes);
}
