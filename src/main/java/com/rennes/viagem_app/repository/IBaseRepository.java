package com.rennes.viagem_app.repository;
import com.rennes.viagem_app.domain.IActiveStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<T, ID> extends JpaRepository<T, ID> {
    default <S extends T> S update(S entity){
        return save(entity);
    }

    default void logicalDeleteById(ID id){
        findById(id).ifPresent(entity -> {
            if(entity instanceof IActiveStatus) {
                ((IActiveStatus) entity).setActive(false);
                save(entity);
            }
        });
    }
}
