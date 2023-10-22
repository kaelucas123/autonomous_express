package com.manager.autonomous_express.model.enums;

public enum CompanyUserRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    CompanyUserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
