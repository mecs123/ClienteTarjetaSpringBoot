package com.pruebaTecnica.demo.RestCliente.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pruebaTecnica.demo.RestAuth.GenerateToken;
import com.pruebaTecnica.demo.RestAuth.model.User;
import com.pruebaTecnica.demo.RestCliente.ClienteDTO;
import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import com.pruebaTecnica.demo.RestCliente.service.ClienteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ClienteController {
    public ClienteController(ClienteServiceInterface clienteServiceInterface, GenerateToken generateToken) {
        this.clienteServiceInterface = clienteServiceInterface;
        this.generateToken = generateToken;
    }

    @Autowired
    ClienteServiceInterface clienteServiceInterface;
    @Autowired
    GenerateToken generateToken;

    @PostMapping("/registro")
    public User login(@RequestParam("email") String username,
                      @RequestParam("pass") String pass,
                      @RequestParam("doc") long idUser) {
        GenerateToken generateToken = new GenerateToken();
        String token = generateToken.getJWTToken(username);
        User user = new User();
        user.setUser(username);
        user.setToken(token);
        user.setPass(pass);
        user.setIdUser(idUser);
        return user;

    }
    @PostMapping(path = "/cliente")
    public ResponseEntity<Cliente> create(@RequestBody ClienteDTO clienteDTO){
        return new ResponseEntity<Cliente>(clienteServiceInterface.createCliente(clienteDTO),HttpStatus.CREATED);
    }


    @GetMapping(path = "/cliente/{id}")
    public Optional<Cliente> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.clienteServiceInterface.getClienteID(id);
    }


    @PutMapping(path = "/cliente")
    public ResponseEntity<Cliente> update(@RequestBody ClienteDTO clienteDTO){
        return new ResponseEntity<Cliente>(clienteServiceInterface.updateliente(clienteDTO),HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/cliente/{id}")
    public ResponseEntity<String> deletePersonaBy(@PathVariable("id") Long id){
        clienteServiceInterface.deleteCliente(id);
    return  new ResponseEntity<>("Eliminado con Exito",HttpStatus.OK);
    }

    }
