package com.rennes.viagem_app.controller;

import com.rennes.viagem_app.domain.UserDomain;
import com.rennes.viagem_app.dto.UserDTO;
import com.rennes.viagem_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@CrossOrigin
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserDomain> createUser(@RequestBody UserDTO userDTO) {
        try {
            UserDomain createdUser = userService.createUser(userDTO);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }
}