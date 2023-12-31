package com.theusma.movielibrary.services;

import com.theusma.movielibrary.domain.user.AdminRegisterDto;
import com.theusma.movielibrary.domain.user.EmailRequest;
import com.theusma.movielibrary.domain.user.UserRegisterDto;
import com.theusma.movielibrary.domain.user.User;
import com.theusma.movielibrary.infra.producer.UserProducer;
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

    @Autowired
    private UserProducer userProducer;

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

        EmailRequest emailRequest = new EmailRequest(data.email(), "Confirmação de cadastro", data.username() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");

        userProducer.publishMessageEmail(emailRequest);

        return "registered user";

    }

    public String adminRegister(AdminRegisterDto data){

        if(userRepository.findByUsername(data.username()) != null)
            return "User already exists";

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User( data.username(), encryptedPassword, data.email(), data.role());

        userRepository.save(newUser);

        EmailRequest emailRequest = new EmailRequest(data.email(), "Confirmação de cadastro", data.username() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");

        userProducer.publishMessageEmail(emailRequest);

        return "registered user";

    }
}
