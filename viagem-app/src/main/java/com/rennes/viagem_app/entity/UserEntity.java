package com.rennes.viagem_app.entity;

import com.rennes.viagem_app.domain.IActiveStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name= "tb_users")
@Data
public class UserEntity implements IActiveStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;
    private String email;
    private String password;
    private boolean active;

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean isActive(){
        return active;
    }
}
