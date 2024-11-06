package com.rennes.viagem_app.repository;

import com.rennes.viagem_app.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends IBaseRepository<UserEntity, Long> {

}