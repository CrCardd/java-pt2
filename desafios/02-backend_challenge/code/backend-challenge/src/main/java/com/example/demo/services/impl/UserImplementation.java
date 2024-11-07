package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.UserB;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.EncoderService;
import com.example.demo.services.UserService;

public class UserImplementation implements UserService{

    @Autowired
    UserRepository repository;
    @Autowired
    EncoderService encoderService;

    final private String regex = "^(.+)@(.+).(.+)";

    @Override
    public Boolean create(UserB new_user) {
        if(new_user.getName().isBlank())
            return false;
        if(new_user.getMail().isBlank())
            return false;
        if(new_user.getPassword().isBlank())
            return false;
        
        repository.save(new_user);
        return true;
    }

    @Override
    public Boolean validatePassword(String password) {
        if(password.length() < 8)
            return false;
        if(!password.chars().anyMatch(c -> c >= 'A' && c <= 'Z'))
            return false;
        if(!password.chars().anyMatch(c -> c >= 'a' && c <= 'z'))
            return false;
        if(!password.chars().anyMatch(c -> c >= '0' && c <= '9'))
            return false;
        
        return true;
    }

    @Override
    public Boolean validateMail(String mail){
        
        List<UserB> list = repository.findByMail(mail);
        if(!list.isEmpty())
            return false;
        
        if(!mail.matches(regex))
            return false;
        return true;
    }

    @Override
    public Boolean validateName(String name) {
        List<UserB> list = repository.findByName(name);
        if(!list.isEmpty())
            return false;
        if(name.length() < 4)
            return false;
        
        return true;
    }

    @Override
    public Boolean userNameExists(String name) {
        List<UserB> list = repository.findByName(name);
        return !list.isEmpty();
    }

    @Override
    public Boolean userMailExists(String mail) {
        List<UserB> list = repository.findByMail(mail);
        return !list.isEmpty();
    }
    
    @Override
    public UserB checkNamePassword(String name, String password) {
        List<UserB> list = repository.loginMailOrName(name);
        if(list.isEmpty())
            return null;
        if(encoderService.encode(password).equals(list.get(0).getPassword()))
            return null;
        return list.get(0);
    }


    @Override
    public void updatePassword(UserB user, String new_pasword) {
        user.setPassword(new_pasword);
        repository.save(user);
    }
}
