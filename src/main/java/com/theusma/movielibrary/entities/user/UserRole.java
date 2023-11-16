package com.theusma.movielibrary.entities.user;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN_ROLE("admin_role"),
    USER_ROLE("user_role");

    private String role;

    UserRole(String role){
        this.role = role;
    }

}
