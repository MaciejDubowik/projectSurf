package com.example.projectSurf.dtos;

import com.example.projectSurf.model.Student;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Component;


public class StudentRegistrationDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String mail;
    @NotNull
    private int phone;
    @NotNull
    private String password;

    public StudentRegistrationDto(){}
    public StudentRegistrationDto(String firstName, String lastName, String mail, int phone, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.phone = phone;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
