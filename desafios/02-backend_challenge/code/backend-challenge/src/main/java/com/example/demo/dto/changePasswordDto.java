package com.example.demo.dto;

public record changePasswordDto(
    String username,
    String password,
    String newPassword,
    String repeatPassword
){}
