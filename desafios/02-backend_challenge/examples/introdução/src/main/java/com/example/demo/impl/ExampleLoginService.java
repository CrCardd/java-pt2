package com.example.demo.impl;

import com.example.demo.services.LoginService;

public class ExampleLoginService implements LoginService {

    String realLogin;
    String realPassword;



    @Override
    public Integer login(String username, String password){
        if(!username.equals(realLogin))
            return -1;
        if(!password.equals(realPassword))
            return -1;
        
        return 1;
    }
    
}
