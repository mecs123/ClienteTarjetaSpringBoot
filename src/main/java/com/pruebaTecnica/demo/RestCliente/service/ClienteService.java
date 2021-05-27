package com.pruebaTecnica.demo.RestCliente.service;
import com.pruebaTecnica.demo.RestCliente.ClienteDTO;
import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import com.pruebaTecnica.demo.RestCliente.repository.ClienteRepositories;
import com.pruebaTecnica.demo.RestTarjeta.repository.TarjetaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClienteService implements ClienteServiceInterface{

    @Autowired
    ClienteRepositories clienteRepository;
    @Autowired
    TarjetaRepositories tarjetaRepositories;

    public ClienteService(ClienteRepositories clienteRepository, TarjetaRepositories tarjetaRepositories) {
        this.clienteRepository = clienteRepository;
        this.tarjetaRepositories = tarjetaRepositories;
    }

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
    public Optional<ClienteDTO> getClienteID(Long id) {
        ClienteDTO clienteDTO = new ClienteDTO();
        Cliente cliente =  clienteRepository.findById(id).orElseThrow(RuntimeException::new);
        clienteDTO.setTelCliente(cliente.getTelCliente());
        clienteDTO.setDirClient(cliente.getDirClient());
        clienteDTO.setNomClient(cliente.getNomClient());
        clienteDTO.setTarjetaList(tarjetaRepositories.findAllByIdClient(id));
        return Optional.of(clienteDTO);
    }

    @Override
    public Cliente updateliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(clienteDTO.getIdClient()).orElseThrow(RuntimeException::new);
        cliente.setIdClient(clienteDTO.getIdClient());
        cliente.setNomClient(clienteDTO.getNomClient());
        cliente.setTelCliente(clienteDTO.getTelCliente());
        cliente.setDirClient(clienteDTO.getDirClient());
        return clienteRepository.save(cliente);
    }

    @Override
    public void  deleteCliente(Long id) {
        clienteRepository.findById(id).orElseThrow(RuntimeException::new);
        clienteRepository.deleteById(id);
    }
}