package com.example.elearningplatform.service;

import com.example.elearningplatform.dto.Login;
import com.example.elearningplatform.dto.Profile;
import com.example.elearningplatform.repository.LoginRepository;
import com.example.elearningplatform.repository.ProfileRepository;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class LoginService {
    private LoginRepository loginRepository;
    private ProfileRepository profileRepository;

    public LoginService(LoginRepository loginRepository, ProfileRepository profileRepository) {
        this.loginRepository = loginRepository;
        this.profileRepository = profileRepository;
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

    public Login create(String email, String password, String firstName, String secondName, String city, Integer mobileNumber) {
        Profile profile = new Profile(firstName, secondName, city, mobileNumber);
        profileRepository.save(profile);
        Login login = new Login(email, password, profile, "USER");
        loginRepository.save(login);
        return login;
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
}
