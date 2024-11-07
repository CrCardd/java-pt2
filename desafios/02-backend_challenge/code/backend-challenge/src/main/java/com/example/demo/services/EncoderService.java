package com.example.demo.services;

public interface EncoderService {
    public String encode(String password);
    public Boolean validate(String primary_password, String second_password);
}
