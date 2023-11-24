package com.theusma.movielibrary.domain.user;

public record AdminRegisterDto(String username, String email, String password, UserRole role){
}
