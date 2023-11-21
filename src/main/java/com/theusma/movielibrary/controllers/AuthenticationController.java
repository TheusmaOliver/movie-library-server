package com.theusma.movielibrary.controllers;

import com.theusma.movielibrary.domain.user.AdminRegisterDto;
import com.theusma.movielibrary.domain.user.LoginResponseDTO;
import com.theusma.movielibrary.domain.user.User;
import com.theusma.movielibrary.domain.user.UserRegisterDto;
import com.theusma.movielibrary.services.AuthorizationService;
import com.theusma.movielibrary.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserRegisterDto data){
        var usernamePassword =  new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
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
