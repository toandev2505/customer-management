package com.customerproject.converter;

import com.customerproject.dto.UserDTO;
import com.customerproject.entity.RoleEntity;
import com.customerproject.entity.UserEntity;
import com.customerproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverter {
    @Autowired
    private RoleRepository roleRepository;

    public UserDTO toDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        dto.setFullName(entity.getFullName());
        dto.setStatus(entity.getStatus());
        List<String> roleCodes = entity.getRoles()
                .stream()
                .map(RoleEntity::getCode)
                .toList();
        dto.setRoles(roleCodes);
        return dto;
    }

    public UserEntity toEntity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        entity.setStatus(dto.getStatus());
        entity.setFullName(dto.getFullName());
        List<RoleEntity> roles = roleRepository.findByCodeIn(dto.getRoles());
        entity.setRoles(roles);
        return entity;
    }
}
