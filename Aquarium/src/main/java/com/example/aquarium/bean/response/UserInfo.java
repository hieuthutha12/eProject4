package com.example.aquarium.bean.response;

import java.util.Date;

public class UserInfo {
    private int id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String address;
    private String phone;
    private String accountStatus;
    private String roleName;
    private int loyaltyPoints;
    private double discountPercentage;
    private Date createdAt;

    public UserInfo() {
    }

    public UserInfo(int id, String firstName, String lastName, String email, String address,
                    String phone, String accountStatus, String roleName, int loyaltyPoints,
                    double discountPercentage, Date createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName; // Set full name
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.accountStatus = accountStatus;
        this.roleName = roleName;
        this.loyaltyPoints = loyaltyPoints;
        this.discountPercentage = discountPercentage;
        this.createdAt = createdAt;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
        updateFullName(); // Update full name when first name changes
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
        updateFullName(); // Update full name when last name changes
    }


    private void updateFullName() {
        this.fullName = this.firstName + " " + this.lastName; // Update full name
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }


    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }


    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }


    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}


