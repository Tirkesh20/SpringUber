package com.uber.demo.beans;


import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Component
public class Account {

    private long id;

    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String firstName;

    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String lastName;

    @Min(value = 7, message = "Password should be greater than 7")
    private String password;

    @Size(min = 2, max = 30, message = "Username should be between 2 and 30 characters")
    private String userName;

    private String email;

    private String userType;

    public Account(){

    }

    public Account(long id,String firstName,String lastName,String email,String password,String userName,String userType ){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.email=email;
        this.password=password;
        this.userType=userType;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return userType;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType(){return userType ;}

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                "lastName='" + lastName + '\'' +
                " password='" + password + '\'' +
                "userName='" + userName + '\'' +
                " email='" + email + '\'' +
                " usertype='" + userType+'\''+
                '}';
    }
}

