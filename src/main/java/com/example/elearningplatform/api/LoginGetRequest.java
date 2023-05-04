package com.example.elearningplatform.api;

public class LoginGetRequest {
    private String email;
    private String password;
    private String firstName;
    private String surname;
    private String city;
    private Integer phoneNumber;

    public LoginGetRequest() {
    }

    public LoginGetRequest(String email, String password, String firstName, String surname, String city, Integer phoneNumber) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }
}
