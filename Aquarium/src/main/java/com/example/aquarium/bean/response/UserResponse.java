package com.example.aquarium.bean.response;

import java.util.List;

public class UserResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private String accountStatus;
    private RoleResponse role;
    private List<PermissionResponse> permissions;

    public UserResponse() {
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
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


    public void setRole(RoleResponse role) {
        this.role = role;
    }


    public void setPermissions(List<PermissionResponse> permissions) {
        this.permissions = permissions;
    }
}

