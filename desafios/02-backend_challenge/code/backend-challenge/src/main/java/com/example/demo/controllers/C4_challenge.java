package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CpfValidate;
import com.example.demo.services.CpfService;

@RestController
@RequestMapping("/curitiba")
public class C4_challenge {

    @Autowired
    CpfService service;


    @GetMapping
    public CpfValidate coxabranca(String cpf, String cep){
        Boolean validate = service.validate(cpf);
        String message = "Cpf validado!";
        if(!validate)
            message = "O cpf informado não é válido!";
        
        return new CpfValidate(validate, message);
    }
}
