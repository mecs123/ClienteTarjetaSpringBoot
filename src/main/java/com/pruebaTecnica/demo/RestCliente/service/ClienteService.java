package com.pruebaTecnica.demo.RestCliente.service;


import com.pruebaTecnica.demo.RestAuth.model.User;
import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import com.pruebaTecnica.demo.RestCliente.repository.ClienteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class ClienteService implements ClienteServiceInterface<Cliente, Number> {
    @Value("${urlTemplate}")
    String urlRestTarjeta;

    @Autowired
    ClienteRepositories clienteRepositories;

    @Override
    public Cliente savePersona(Cliente cliente) {
        return clienteRepositories.save(cliente);
    }

    @Override
    public ArrayList<Cliente> obtenerPersona() {
        return (ArrayList<Cliente>) clienteRepositories.findAll();
    }

    @Override
    public Optional<Cliente> obtenerClientId(long id)  {
        return  clienteRepositories.findById(id);

    }

    @Override
    public boolean eliminarPersona(Long id) {
        try {
            clienteRepositories.deleteById(id);
            return  true;
        } catch (Exception err) {
            return false;
        }
    }

}
