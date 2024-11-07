package com.rennes.viagem_app.mapper;


import com.rennes.viagem_app.domain.UserDomain;
import com.rennes.viagem_app.dto.UserDTO;

import com.rennes.viagem_app.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity domainToEntity(UserDomain userDomain) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDomain.getName());
        userEntity.setEmail(userDomain.getEmail());
        userEntity.setPassword(userDomain.getPassword());
        userEntity.setActive(userDomain.isActive());
        return userEntity;
    }

    public UserDomain entityToDomain(UserEntity userEntity) {
        UserDomain userDomain = new UserDomain();
        userDomain.setId(userEntity.getId());
        userDomain.setName(userEntity.getName());
        userDomain.setEmail(userEntity.getEmail());



        userDomain.setActive(userEntity.isActive());
        return userDomain;
    }

    public UserDTO entityToDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setName(userEntity.getName());
        userDTO.setEmail(userEntity.getEmail());

        return userDTO;
    }

    public UserDomain  dtoToDomain(UserDTO userDTO) {
        UserDomain userDomain = new UserDomain();
        userDomain.setId(userDTO.getId());
        userDomain.setName(userDTO.getName());
        userDomain.setEmail(userDTO.getEmail());
        userDomain.setPassword(userDTO.getPassword());

        return userDomain;
    }

    public UserDTO domainToDTO(UserDomain userDomain) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userDomain.getId());
        userDTO.setEmail(userDomain.getEmail());
        userDTO.setName(userDomain.getName());

        return userDTO;
    }
}
