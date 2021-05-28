package com.pruebaTecnica.demo.RestAuth.service;

import com.pruebaTecnica.demo.RestAuth.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthServiceInterface extends UserDetailsService {
    UserEntity saveAutUsusario(String userEmail, String pass);

}
