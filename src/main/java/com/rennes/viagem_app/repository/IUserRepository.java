package com.rennes.viagem_app.repository;

import com.rennes.viagem_app.domain.UserDomain;
import com.rennes.viagem_app.entity.UserEntity;
import java.util.Optional;

public interface IUserRepository extends IBaseRepository<UserEntity, Long> {
    Optional<UserDomain> findByEmail(String email);
    Optional<UserDomain> findById(Long id);
    void save(UserDomain userDomain);
}