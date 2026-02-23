package com.customerproject.repository;

import com.customerproject.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE CustomerEntity c SET c.status = 0 WHERE c.id IN :ids")
    void softDeleteByIds(@Param("ids") List<Long> ids);
}
