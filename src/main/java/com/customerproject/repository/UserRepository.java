package com.customerproject.repository;

import com.customerproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByUserName(String userName);
    UserEntity findOneByUserNameAndStatus(String userName, int status);
}