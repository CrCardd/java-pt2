package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Imaginary;

@RestController
@RequestMapping("/imaexp")
public class C2_challenge {
    
    @GetMapping
    public Imaginary imaginary_exponential(Integer A, Integer b) {
        Double Re = A * Math.sin(b);
        Double Im = A * Math.cos(b);

        return new Imaginary(Re, Im);
    }
}
