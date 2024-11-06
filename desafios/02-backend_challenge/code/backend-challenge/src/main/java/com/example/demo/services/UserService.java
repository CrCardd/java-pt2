package com.example.demo.services;

import com.example.demo.model.UserB;

public interface UserService {
    public Boolean create(UserB new_user);
    public Boolean validatePassword(String password);
    public Boolean validateMail(String mail);
    public Boolean validateName(String name);
    public Boolean userNameExists(String name);
    public Boolean userMailExists(String mail);
    public UserB checkNamePassword(String name, String password);
    public void updatePassword(UserB user, String new_pasword);
}
