package com.pruebaTecnica.demo.RestCliente.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pruebaTecnica.demo.RestCliente.models.Cliente;

import java.util.ArrayList;
import java.util.Optional;


public interface ClienteServiceInterface<E extends Cliente, L extends Number> {
    public Cliente savePersona(Cliente cliente);

    ArrayList<Cliente> obtenerPersona();

    Optional<Cliente> obtenerClientId(long id) throws JsonProcessingException;

    boolean eliminarPersona(Long id);

}
