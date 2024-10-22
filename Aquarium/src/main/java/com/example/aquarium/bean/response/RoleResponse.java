package com.example.aquarium.bean.response;

import java.util.List;
import java.util.Set;

public class RoleResponse {
    private Integer id;
    private String roleName;
    private Set<PermissionResponse> permissionResponses;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<PermissionResponse> getPermissionResponses() {
        return permissionResponses;
    }

    public void setPermissionResponses(Set<PermissionResponse> permissionResponses) {
        this.permissionResponses = permissionResponses;
    }
}

