package com.example.elearningplatform.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "sur_name")
    private String secondName;
    @Column(name = "city")
    private String city;
    @Column(name = "mobile_number")
    private Integer mobileNumber;
    
    public Profile() {
    }

    public Profile(String firstName, String secondName, String city, Integer mobileNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.city = city;
        this.mobileNumber = mobileNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", address='" + city + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
