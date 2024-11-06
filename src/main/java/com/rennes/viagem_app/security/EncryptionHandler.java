package com.rennes.viagem_app.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptionHandler {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String encrypt(String rawData){
        return encoder.encode(rawData);
    }

    public boolean compare(String rawData, String encodedData){
        return encoder.matches(rawData, encodedData);
    }
}
