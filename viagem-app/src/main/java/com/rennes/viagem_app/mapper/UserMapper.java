package com.rennes.viagem_app.mapper;


import com.rennes.viagem_app.domain.UserDomain;
import com.rennes.viagem_app.dto.UserDTO;

import com.rennes.viagem_app.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setActive(userDTO.isActive());
        return userEntity;
    }

    public UserDomain toDomain(UserEntity userEntity) {
        UserDomain userDomain = new UserDomain();
        userDomain.setId(userEntity.getId());
        userDomain.setName(userEntity.getName());
        userDomain.setEmail(userEntity.getEmail());
        userDomain.setActive(userEntity.isActive());
        return userDomain;
    }
}
