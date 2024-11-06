package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginData;
import com.example.demo.services.LoginService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    LoginService service;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginData data){
        Integer id = service.login(data.login(), data.password());

        if(id == 1)
            return ResponseEntity.ok("bem vindo donzinho");

        // if(data.login().contentEquals("don") && data.password().contentEquals("ferrari"))
        //     return ResponseEntity.ok("bem vindo donzinho");
    
        return ResponseEntity
            .status(404)
            .build();
    }
    
}
