package com.rennes.viagem_app.service;

import com.rennes.viagem_app.domain.UserDomain;
import com.rennes.viagem_app.dto.LoginDTO;
import com.rennes.viagem_app.dto.UserDTO;
import com.rennes.viagem_app.entity.UserEntity;
import com.rennes.viagem_app.mapper.UserMapper;
import com.rennes.viagem_app.repository.IUserRepository;
import com.rennes.viagem_app.security.EncryptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public void createUser(UserDTO userDTO) {
        UserDomain userDomain = userMapper.dtoToDomain(userDTO);

        String encryptedPassword = encryptionHandler.encrypt(userDomain.getPassword());
        userDomain.setPassword(encryptedPassword);

        userRepository.save(userDomain);
    }

    public Optional<UserDTO> findUser(Long id) {
        Optional<UserDomain> user = userRepository.findById(id);
        return user.map(userMapper::domainToDTO);
    }

    public String login(LoginDTO loginDTO) {
        UserDomain userDomain = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found with email: " + loginDTO.getEmail()));

        boolean isValidPass = encryptionHandler.compare(loginDTO.getPassword(), userDomain.getPassword());
        return "teste";
    }


}
