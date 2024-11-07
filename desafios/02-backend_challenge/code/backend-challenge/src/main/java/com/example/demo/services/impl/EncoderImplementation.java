package com.example.demo.services.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.services.EncoderService;

public class EncoderImplementation implements EncoderService {
    @Override
    public String encode(String password)
    {
        var encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    @Override
    public Boolean validate(String primary_password, String second_password) {
        return new BCryptPasswordEncoder().matches(primary_password, second_password);
    }
}