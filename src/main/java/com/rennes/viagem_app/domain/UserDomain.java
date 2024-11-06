package com.rennes.viagem_app.domain;


import lombok.Data;

@Data
public class UserDomain  {
    private long id;
    private String name;
    private String email;
    private String password;
    private boolean active;
}
