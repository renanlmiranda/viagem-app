package com.rennes.viagem_app.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class UserDTO {
    @Setter
    @Getter
    private long id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String email;

    @Setter
    @Getter
    private String password;

    @Setter
    @Getter
    private boolean active;

}
