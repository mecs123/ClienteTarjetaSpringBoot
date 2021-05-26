package com.pruebaTecnica.demo.RestCliente.service;


import com.pruebaTecnica.demo.RestCliente.ClienteDTO;
import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import com.pruebaTecnica.demo.RestCliente.repository.ClienteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClienteService implements ClienteServiceInterface{

    @Autowired
    ClienteRepositories clienteRepository;


    @Override
    public Cliente createCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setIdClient(clienteDTO.getIdClient());
        cliente.setNomClient(clienteDTO.getNomClient());
        cliente.setTelCliente(clienteDTO.getTelCliente());
        cliente.setDirClient(clienteDTO.getDirClient());
        cliente.setRegistDate(clienteDTO.getRegistDate());

        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> getClienteID(Long id) {
        return clienteRepository.findById(id);
    }


    @Override
    public Cliente updateliente(ClienteDTO clienteDTO) {
        Optional<Cliente> clienteExiste= clienteRepository.findById(clienteDTO.getIdClient());
        if (clienteExiste.isPresent()){
            Cliente cliente = new Cliente();
            cliente.setIdClient(clienteDTO.getIdClient());
            cliente.setNomClient(clienteDTO.getNomClient());
            cliente.setTelCliente(clienteDTO.getTelCliente());
            cliente.setDirClient(clienteDTO.getDirClient());
            return clienteRepository.save(cliente);
        }
        return null;
    }



    @Override
    public void  deleteCliente(Long id) {
        Optional<Cliente> clienteExiste= clienteRepository.findById(id);
        if (clienteExiste.isPresent()){
            clienteRepository.deleteById(id);
        }
    }

    @Override
    public Cliente getClientID(Long id) {
        return null;
    }


}
