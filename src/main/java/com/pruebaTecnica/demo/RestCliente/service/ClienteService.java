package com.pruebaTecnica.demo.RestCliente.service;


import com.pruebaTecnica.demo.RestCliente.ClienteDTO;
import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import com.pruebaTecnica.demo.RestCliente.repository.ClienteRepositories;
import com.pruebaTecnica.demo.RestTarjeta.models.Tarjeta;
import com.pruebaTecnica.demo.RestTarjeta.models.TarjetaDto;
import com.pruebaTecnica.demo.RestTarjeta.repository.TarjetaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService implements ClienteServiceInterface{

    @Autowired
    ClienteRepositories clienteRepository;
    @Autowired
    TarjetaRepositories tarjetaRepositories;


    @Override
    public Cliente createCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setIdClient(clienteDTO.getIdClient());
        cliente.setNomClient(clienteDTO.getNomClient());
        cliente.setTelCliente(clienteDTO.getTelCliente());
        cliente.setDirClient(clienteDTO.getDirClient());
        cliente.setRegistDate(clienteDTO.getRegistDate());
        List<Tarjeta> optionalTarjeta = clienteDTO.getTarjetaList();
        Tarjeta tarjeta = new Tarjeta();
        for (Tarjeta datos:clienteDTO.getTarjetaList()){
            datos.setIdClient(clienteDTO.getIdClient());
            datos.setNumCuenta(clienteDTO.getIdClient());
            cliente.setTarjetaList(clienteDTO.getTarjetaList());
            optionalTarjeta.add(tarjeta);
            cliente.setTarjetaList(optionalTarjeta);
            Tarjeta tarjetaDto = tarjetaRepositories.save(tarjeta);
            cliente.setFk_idTarjetaCliente(tarjetaDto.getIdTarjeta());
            clienteRepository.save(cliente);
        }
        return cliente;
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
