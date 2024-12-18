package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.changePasswordDto;
import com.example.demo.model.UserB;
import com.example.demo.services.UserService;


@RestController
@RequestMapping("/changepassword")
public class C7_challenge {

    @Autowired
    UserService service;

    @PatchMapping
    public ResponseEntity<String> updatePassword(@RequestBody changePasswordDto data){

        if(!data.newPassword().equals(data.repeatPassword()))
            return new ResponseEntity<>("Passwords doesn't match", HttpStatus.BAD_REQUEST);

        if(!service.userNameExists(data.username()))
            return new ResponseEntity<>("This User doesn't exists", HttpStatus.BAD_REQUEST);
        
        UserB user = service.checkNamePassword(data.username(), data.password());
        if(user == null)
            return new ResponseEntity<>("Incorrect password", HttpStatus.BAD_REQUEST);

        service.updatePassword(user, data.newPassword());
        return new ResponseEntity<>("Password updated successfully!", HttpStatus.OK);
    }
    
}
