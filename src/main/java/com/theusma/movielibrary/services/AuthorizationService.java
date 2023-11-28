package com.theusma.movielibrary.services;

import com.theusma.movielibrary.domain.user.AdminRegisterDto;
import com.theusma.movielibrary.domain.user.UserRegisterDto;
import com.theusma.movielibrary.domain.user.User;
import com.theusma.movielibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public String userRegister(UserRegisterDto data){

        if(userRepository.findByUsername(data.username()) != null)
            return "User already exists";

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User( data.username(), data.email(), encryptedPassword);

        userRepository.save(newUser);

        return "registered user";

    }

    public String adminRegister(AdminRegisterDto data){

        if(userRepository.findByUsername(data.username()) != null)
            return "User already exists";

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User( data.username(), encryptedPassword, data.email(), data.role());

        userRepository.save(newUser);

        return "registered user";

    }
}
