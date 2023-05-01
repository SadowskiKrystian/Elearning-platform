package com.example.elearningplatform.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;


    @OneToOne(fetch = FetchType.LAZY)
    private Profile profile;
    private String role;
    
    public Login() {
    }

    public Login(String email, String password, Profile profile, String role) {
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                ", role='" + role + '\'' +
                '}';
    }
}
