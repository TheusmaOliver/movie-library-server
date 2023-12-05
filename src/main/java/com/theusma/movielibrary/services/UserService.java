package com.theusma.movielibrary.services;

import com.theusma.movielibrary.domain.user.User;
import com.theusma.movielibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getOneUser(UUID id)  {
        return userRepository.findById(id);
    }

    public void deleteUser(UUID id){
        userRepository.deleteById(id);
    }

}
