package com.rennes.viagem_app.dto;

import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String password;
    private boolean active;
}
