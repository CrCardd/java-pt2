package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Token;
import com.example.demo.dto.productDto;
import com.example.demo.services.JwtService;

@RestController
@RequestMapping("/product")
public class C10_challenge {

    @Autowired
    JwtService<Token> jwtService;


    @PostMapping
    public ResponseEntity<String> taNaMao(@RequestBody productDto data, @RequestAttribute("token") Token token){

        System.out.println("ID do usuário autenticado: " + token.getId());
        return new ResponseEntity<>("AQUI", HttpStatus.OK);
    }
}
