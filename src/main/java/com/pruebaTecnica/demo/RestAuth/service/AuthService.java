package com.pruebaTecnica.demo.RestAuth.service;


import com.pruebaTecnica.demo.RestAuth.GenerateToken;
import com.pruebaTecnica.demo.RestAuth.model.UserEntity;
import com.pruebaTecnica.demo.RestAuth.repositories.AuthUserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements AuthServiceInterface {


    @Autowired
    AuthUserRepositories authUserRepositories;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserEntity saveAutUsusario(String userEmail, String pass) {
        GenerateToken generateToken = new GenerateToken();
        String token = generateToken.getJWTToken(userEmail);
        UserEntity userEntity = new UserEntity();
        userEntity.setUserEmail(userEmail);
        userEntity.setToken(token);
        userEntity.setPass(bCryptPasswordEncoder.encode(userEmail));
        //authUserRepositories.save(userEntity);
        return userEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
