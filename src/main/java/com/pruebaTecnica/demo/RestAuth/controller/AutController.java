package com.pruebaTecnica.demo.RestAuth.controller;


import com.pruebaTecnica.demo.RestAuth.model.UserEntity;
import com.pruebaTecnica.demo.RestAuth.service.AuthServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutController {

    @Autowired
    AuthServiceInterface authService;

    @PostMapping("/registro")
    public UserEntity login(@RequestParam("userEmail") String userEmail, @RequestParam("pass") String pass) {
       return authService.saveAutUsusario(userEmail,pass);
    }

}
