package com.rennes.viagem_app.repository.impl;

import com.rennes.viagem_app.domain.UserDomain;
import com.rennes.viagem_app.entity.UserEntity;
import com.rennes.viagem_app.mapper.UserMapper;
import com.rennes.viagem_app.repository.IBaseRepository;
import com.rennes.viagem_app.repository.IUserRepository;
import com.rennes.viagem_app.repository.jpa.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JpaUserRepository jpaRepository;

    @Autowired
    private IBaseRepository<UserEntity, Long> baseRepository;

    @Override
    public Optional<UserDomain> findByEmail(String email) {
        Optional<UserEntity> userEntityOptional = jpaRepository.findByEmail(email);
        return userEntityOptional.map(userMapper::entityToDomain);
    }

    @Override
    public Optional<UserDomain> findById(Long id) {
        Optional<UserEntity> userEntityOptional = jpaRepository.findById(id);
        return userEntityOptional.map(userMapper::entityToDomain);
    }

    @Override
    public void save(UserDomain userDomain) {
        UserEntity user =  userMapper.domainToEntity(userDomain);
        UserEntity savedEntity = jpaRepository.save(user);
    }

    @Override
    public void logicalDeleteById(Long id) {
        Optional<UserEntity> userEntityOptional = jpaRepository.findById(id);
        userEntityOptional.ifPresent(userEntity -> {
            userEntity.setActive(false);
            jpaRepository.save(userEntity);
        });

    }
}