package com.example.aquarium.bean.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {
    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    private String address;
    private String phone;


    public UserDTO() {
    }

    public @NotBlank(message = "First name is required") String getFirstName() {
        return firstName;
    }


    public @NotBlank(message = "Last name is required") String getLastName() {
        return lastName;
    }


    public @NotBlank(message = "Email is required") @Email(message = "Invalid email format") String getEmail() {
        return email;
    }


    public @NotBlank(message = "Password is required") String getPassword() {
        return password;
    }


    public String getAddress() {
        return address;
    }


    public String getPhone() {
        return phone;
    }





}

