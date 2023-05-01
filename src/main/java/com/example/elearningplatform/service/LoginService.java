package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.Login;
import com.example.elearningplatform.repository.LoginRepository;

import java.util.List;

public class LoginService {
    private LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    public List<Login> findAll(){
        return loginRepository.findAll();
    }

    public Login validateLogin(Login login){
        List<Login> users = findAll();
        for (Login user : users) {
            if (user.getEmail().equals(login.getEmail()) && user.getPassword().equals(login.getPassword())){
                return user;
            }
        }
        return null;
    }

    public void create(Login login){
        loginRepository.save(login);
    }
}
