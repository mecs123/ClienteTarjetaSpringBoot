package com.pruebaTecnica.demo.RestCliente.service;

import com.pruebaTecnica.demo.RestCliente.ClienteDTO;
import com.pruebaTecnica.demo.Exepciones.ExepcionApiNuvu;
import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import com.pruebaTecnica.demo.RestCliente.repository.ClienteRepositories;
import com.pruebaTecnica.demo.RestTarjeta.repository.TarjetaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.pruebaTecnica.demo.Exepciones.error.ConstantsErrorCliente.*;

@Service
@Transactional
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
        cliente.setIdDocClient(clienteDTO.getIdDocClient());
        cliente.setNomClient(clienteDTO.getNomClient());
        cliente.setTelCliente(clienteDTO.getTelCliente());
        cliente.setDirClient(clienteDTO.getDirClient());
        cliente.setRegistDate(clienteDTO.getRegistDate());
        try {
         return  clienteRepository.save(cliente);
        }catch (Exception exception){
          throw new ExepcionApiNuvu(EXISTCLIENT);
        }
    }

    @Override
    public Optional<ClienteDTO> getClienteID(Long id) {
        ClienteDTO clienteDTO = new ClienteDTO();
        Cliente cliente =  clienteRepository.findById(id).orElseThrow(() -> new ExepcionApiNuvu(NOTFOUNDCLIENT));
        clienteDTO.setIdCodCliente(cliente.getIdCliente());
        clienteDTO.setTelCliente(cliente.getTelCliente());
        clienteDTO.setIdDocClient(cliente.getIdDocClient());
        clienteDTO.setDirClient(cliente.getDirClient());
        clienteDTO.setNomClient(cliente.getNomClient());
        clienteDTO.setRegistDate(cliente.getRegistDate());
        try {
            clienteDTO.setTarjetaList(tarjetaRepositories.findAllByIdClient(id));
            return Optional.of(clienteDTO);
        }catch (Exception exepcion){
            throw  new ExepcionApiNuvu(NOTFOUNDIDTARJETA);
        }
    }

    @Override
    public Cliente updateliente(ClienteDTO clienteDTO) {

        Cliente cliente = clienteRepository.findById(clienteDTO.getIdCodCliente()).orElseThrow(() -> new ExepcionApiNuvu(NOTFOUNDCLIENT));
        cliente.setIdDocClient(clienteDTO.getIdDocClient());
        cliente.setNomClient(clienteDTO.getNomClient());
        cliente.setTelCliente(clienteDTO.getTelCliente());
        cliente.setDirClient(clienteDTO.getDirClient());
        return clienteRepository.save(cliente);
    }

    @Override
    public void  deleteCliente(Long id) {
        clienteRepository.findById(id).orElseThrow(() -> new ExepcionApiNuvu(NOTFOUNDCLIENT));
        clienteRepository.deleteById(id);
    }

}