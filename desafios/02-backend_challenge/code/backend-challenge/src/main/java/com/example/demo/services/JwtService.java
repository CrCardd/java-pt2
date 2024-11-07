package com.example.demo.services;

public interface JwtService<T> {
    public String get(T token);
    public T validate(String jwt);
}
