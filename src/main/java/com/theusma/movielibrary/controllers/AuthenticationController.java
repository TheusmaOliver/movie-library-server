package com.theusma.movielibrary.controllers;

import com.theusma.movielibrary.domain.user.RegisterDto;
import com.theusma.movielibrary.services.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterDto data ){
        var newUser = authorizationService.register(data);
        if(Objects.equals(newUser, "User already exists")) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().build();
    }
}
