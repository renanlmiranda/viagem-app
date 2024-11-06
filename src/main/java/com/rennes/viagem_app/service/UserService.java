package com.rennes.viagem_app.service;

import com.rennes.viagem_app.domain.UserDomain;
import com.rennes.viagem_app.dto.UserDTO;
import com.rennes.viagem_app.entity.UserEntity;
import com.rennes.viagem_app.mapper.UserMapper;
import com.rennes.viagem_app.repository.IUserRepository;
import com.rennes.viagem_app.security.EncryptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final IUserRepository userRepository;
    private final UserMapper userMapper;
    private final EncryptionHandler encryptionHandler;

    @Autowired
    public UserService(IUserRepository userRepository, UserMapper userMapper, EncryptionHandler encryptionHandler){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.encryptionHandler = encryptionHandler;
    }

    public UserDTO createUser(UserDTO userDTO) {
        UserDomain userDomain = userMapper.dtoToDomain(userDTO);

        String encryptedPassword = encryptionHandler.encrypt(userDomain.getPassword());
        UserEntity userEntity = userMapper.domainToEntity(userDomain);
        userEntity.setPassword(encryptedPassword);

        UserEntity savedEntity = userRepository.save(userEntity);
        return userMapper.entityToDTO(savedEntity);
    }

    public UserDTO findUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);

        if (userEntity == null) {
            return null;
        };

        return userMapper.entityToDTO(userEntity);
    }


}
