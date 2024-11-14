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
import com.example.demo.services.EncoderService;
import com.example.demo.services.UserService;


@RequestMapping("/user")
@RestController
public class C8_challenge {
    
    @Autowired
    UserService userService;
    
    @Autowired
    EncoderService encoderService;
    
    @PostMapping
    public ResponseEntity<String> postWithSecurity(@RequestBody UserDto data) {
        if(!userService.validateName(data.username()))
            return new ResponseEntity<>("Invalid username!", HttpStatus.BAD_REQUEST);
        if(!userService.validateMail(data.email()))
            return new ResponseEntity<>("Invalid mail!", HttpStatus.BAD_REQUEST);
        if(!userService.validatePassword(data.password()))
            return new ResponseEntity<>("Invalid password!", HttpStatus.BAD_REQUEST);
        
        UserB new_user = new UserB(
            data.username(), 
            data.email(), 
            encoderService.encode(data.password()));
        
        userService.create(new_user);
        
        return new ResponseEntity<>("User created successfully!", HttpStatus.OK);
    }
    
}
