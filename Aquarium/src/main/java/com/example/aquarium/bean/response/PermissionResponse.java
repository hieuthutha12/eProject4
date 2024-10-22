package com.example.aquarium.bean.response;

public class PermissionResponse {
    private Integer id;
    private String permissionName;

    public PermissionResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public PermissionResponse(Integer id, String permissionName) {
        this.id = id;
        this.permissionName = permissionName;
    }
}
