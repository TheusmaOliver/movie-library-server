package com.theusma.movielibrary.services;

import com.theusma.movielibrary.domain.user.RegisterDto;
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

    public String register(RegisterDto data){

        if(userRepository.findByUsername(data.username()) != null)
            return "User already exists";

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User( data.username(), encryptedPassword, data.role());

        userRepository.save(newUser);

        return "registered user";

    }
}
