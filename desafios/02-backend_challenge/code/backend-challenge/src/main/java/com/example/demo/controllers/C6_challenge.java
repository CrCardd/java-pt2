package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.model.UserB;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/create")
public class C6_challenge {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDto data){
        if(!service.validateMail(data.email()))
            return new ResponseEntity<>("Invalid Email", HttpStatus.BAD_REQUEST);
        if(!service.validateName(data.username()))
            return new ResponseEntity<>("Invalid Username", HttpStatus.BAD_REQUEST);
        if(!service.validatePassword(data.password()))
            return new ResponseEntity<>("Invalid password. It must have a-z, A-Z, 0-9 and be maior than 8", HttpStatus.BAD_REQUEST);

        UserB new_user = new UserB(data.username(), data.email(), data.password());
        if(service.create(new_user))
            return new ResponseEntity<>("User created successfully", HttpStatus.OK);
        return new ResponseEntity<>("User created failed", HttpStatus.BAD_REQUEST);
    }
}
