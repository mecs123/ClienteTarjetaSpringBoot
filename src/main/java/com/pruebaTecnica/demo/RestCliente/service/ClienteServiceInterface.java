package com.pruebaTecnica.demo.RestCliente.service;
import com.pruebaTecnica.demo.RestCliente.ClienteDTO;
import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import java.util.Optional;

public interface ClienteServiceInterface{
     Cliente createCliente(ClienteDTO cliente);
     Optional<ClienteDTO> getClienteID(Long id);
     Cliente updateliente(ClienteDTO cliente);
     void deleteCliente(Long id);
}
