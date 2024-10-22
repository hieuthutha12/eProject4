package com.example.aquarium.bean.request;

import jakarta.validation.constraints.*;

import java.util.List;

public class RoleRequest {
    @NotBlank(message = "Role name is required")
    @Size(min = 3, max = 50, message = "Role name must be between 3 and 50 characters")
    private String roleName;
    private List<Integer> permissionIds;

    public RoleRequest() {
    }

    public RoleRequest(String roleName, List<Integer> permissionIds) {
        this.roleName = roleName;
        this.permissionIds = permissionIds;
    }

    public String getRoleName() {
        return roleName;
    }

    public List<Integer> getPermissionIds() {
        return permissionIds;
    }

    public void setRoleName(@NotBlank(message = "Role name is required") @Size(min = 3, max = 50, message = "Role name must be between 3 and 50 characters") String roleName) {
        this.roleName = roleName;
    }

    public void setPermissionIds(List<Integer> permissionIds) {
        this.permissionIds = permissionIds;
    }
}

