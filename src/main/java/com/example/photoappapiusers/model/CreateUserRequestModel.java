package com.example.photoappapiusers.model;

// we can add some validation annotation for the fields

import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
public class CreateUserRequestModel {
    @NotNull(message = "first Name cannot be null")
    @Size(min = 2,message = "first name must not be less than 2 characters")
    private String firstName;
    @NotNull(message = "last Name cannot be null")
    @Size(min = 2,message = "last name must not be less than 2 characters")
    private String lastName;
    @NotNull(message = "password cannot be null")
    @Size(min = 2,max =5,message = "password must be min 2 & max 5 characters")
    private String password;
    @NotNull(message = "email cannot be null")
    @Email
    private String email;

    public CreateUserRequestModel() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
