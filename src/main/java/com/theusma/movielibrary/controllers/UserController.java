package com.theusma.movielibrary.controllers;


import com.theusma.movielibrary.domain.user.User;
import com.theusma.movielibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> usersList = userService.getAllUsers();
        return ResponseEntity.ok().body(usersList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") UUID id) {
        Optional<User> user = userService.getOneUser(id);
        return user.<ResponseEntity<Object>>map(userSelected -> ResponseEntity.status(HttpStatus.OK).body(userSelected)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id")UUID id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
