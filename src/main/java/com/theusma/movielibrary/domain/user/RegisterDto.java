package com.theusma.movielibrary.domain.user;

import java.util.UUID;

public record RegisterDto(String username, String password, UserRole role) {
}
