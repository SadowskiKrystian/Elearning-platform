package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.Login;
import com.example.elearningplatform.dto.Profile;
import com.example.elearningplatform.filter.LoginFilter;
import com.example.elearningplatform.repository.LoginRepository;
import com.example.elearningplatform.repository.ProfileRepository;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
@Service
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

    public Login create(Login login) {
        List<Login> users = findAll();
        for (Login user : users) {
            if (user.getEmail().equals(login.getEmail())){
                return null;
            }
        }
        Login saved = loginRepository.save(login);
        return saved;
    }

    public Login validateLogin(String email, String password) {
        List<Login> users = findAll();
        for (Login user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    public Login getLogin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            List<Login> list = loginRepository.findByEmail(new LoginFilter(authentication.getName()).getEmail());
            if (list.size() > 0) {
                return list.get(0);
            }else {
                return null;
            }
    }
    public String test(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
