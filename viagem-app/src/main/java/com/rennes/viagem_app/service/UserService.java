package com.rennes.viagem_app.service;

import com.rennes.viagem_app.domain.UserDomain;
import com.rennes.viagem_app.dto.UserDTO;
import com.rennes.viagem_app.entity.UserEntity;
import com.rennes.viagem_app.mapper.UserMapper;
import com.rennes.viagem_app.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(IUserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDomain createUser(UserDTO userDTO) {
        UserEntity userEntity = userMapper.toEntity(userDTO);
        UserEntity savedEntity = userRepository.save(userEntity);
        return userMapper.toDomain(savedEntity);
    }


}
