package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Token;
import com.example.demo.dto.loginDto;
import com.example.demo.dto.tokenDto;
import com.example.demo.model.UserB;
import com.example.demo.services.EncoderService;
import com.example.demo.services.JwtService;
import com.example.demo.services.UserAuthService;


@RestController
@RequestMapping("/login")
public class C9_challenge {

    @Autowired
    UserAuthService userAuthService;
    @Autowired
    JwtService<Token> jwtService;
    @Autowired
    EncoderService encoderService;
    
    @PostMapping
    public ResponseEntity<tokenDto> login(@RequestBody loginDto data) {

        if(data.password() == null || data.login() == null)
            return new ResponseEntity<>(new tokenDto("nao preencheu", "."), HttpStatus.BAD_REQUEST);

        UserB user = userAuthService.login(data.login());
        if(user == null)
            return new ResponseEntity<>(new tokenDto("Invalid login", "."), HttpStatus.BAD_REQUEST);
        if(!encoderService.validate(data.password(), user.getPassword()))
            return new ResponseEntity<>(new tokenDto("senha errada", "."), HttpStatus.BAD_REQUEST);
        
        Token token = new Token();
        token.setId(user.getId());

        var jwt = jwtService.get(token);
        return new ResponseEntity<>(new tokenDto("Login!", jwt), HttpStatus.OK);
    }
    
}
