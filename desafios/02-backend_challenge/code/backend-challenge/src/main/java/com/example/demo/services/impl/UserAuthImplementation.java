package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.UserB;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserAuthService;

public class UserAuthImplementation implements UserAuthService {

    @Autowired
    UserRepository repository;


    @Override
    public UserB login(String login) {
        List<UserB> list = repository.loginMailOrName(login);
        if(list.isEmpty())
            return null;
        return list.get(0);
    }
}
