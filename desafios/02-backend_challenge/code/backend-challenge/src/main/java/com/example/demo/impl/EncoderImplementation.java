package com.example.demo.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.services.EncoderService;

public class EncoderImplementation implements EncoderService {
    @Override
    public String encode(String password)
    {
        var encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
