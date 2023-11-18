package com.theusma.movielibrary.controllers;

import com.theusma.movielibrary.domain.user.AdminRegisterDto;
import com.theusma.movielibrary.domain.user.UserRegisterDto;
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
    public ResponseEntity<Object> userRegister(@RequestBody @Valid UserRegisterDto data ){
        var newUser = authorizationService.userRegister(data);
        if(Objects.equals(newUser, "User already exists")) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/register")
    public ResponseEntity<Object> adminRegister(@RequestBody @Valid AdminRegisterDto data ){
        var newUser = authorizationService.adminRegister(data);
        if(Objects.equals(newUser, "User already exists")) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().build();
    }
}
