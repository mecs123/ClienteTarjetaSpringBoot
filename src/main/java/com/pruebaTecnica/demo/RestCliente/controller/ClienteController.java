package com.pruebaTecnica.demo.RestCliente.controller;

import com.pruebaTecnica.demo.RestCliente.ClienteDTO;
import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import com.pruebaTecnica.demo.RestCliente.service.ClienteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {
    public ClienteController(ClienteServiceInterface clienteServiceInterface) {
        this.clienteServiceInterface = clienteServiceInterface;
    }

    @Autowired
    ClienteServiceInterface clienteServiceInterface;

    @PostMapping(path = "/cliente")
    public ResponseEntity<Cliente> create(@RequestBody ClienteDTO clienteDTO){
        return new ResponseEntity<Cliente>(clienteServiceInterface.createCliente(clienteDTO),HttpStatus.CREATED);
    }


    @GetMapping(path = "/cliente/{id}")
    public ResponseEntity<ClienteDTO> getallClienteById(@PathVariable("id") Long id) {
        return new ResponseEntity<ClienteDTO>(clienteServiceInterface.getClienteID(id).get(),HttpStatus.OK);
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
