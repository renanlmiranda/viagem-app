package com.rennes.viagem_app.repository;
import com.rennes.viagem_app.domain.IActiveStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface IBaseRepository<T, ID> {
    void logicalDeleteById(ID id);
    //void save(T);
}
