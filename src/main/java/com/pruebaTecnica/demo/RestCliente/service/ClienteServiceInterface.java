package com.pruebaTecnica.demo.RestCliente.service;

import com.pruebaTecnica.demo.RestCliente.ClienteDTO;
import com.pruebaTecnica.demo.RestCliente.models.Cliente;

import java.util.Optional;


public interface ClienteServiceInterface{
    public Cliente createCliente(ClienteDTO cliente);
    public Optional<Cliente> getClienteID(Long id);
    public Cliente updateliente(ClienteDTO cliente);
    void deleteCliente(Long id);
    Cliente getClientID(Long id);
}
