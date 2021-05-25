package com.pruebaTecnica.demo.RestCliente.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pruebaTecnica.demo.RestAuth.GenerateToken;
import com.pruebaTecnica.demo.RestAuth.model.User;
import com.pruebaTecnica.demo.RestCliente.ClienteDTO;
import com.pruebaTecnica.demo.RestCliente.exepciones.ClienteExistsExepcion;
import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import com.pruebaTecnica.demo.RestCliente.service.ClienteServiceInterface;
import com.pruebaTecnica.demo.RestTarjeta.models.Tarjeta;
import com.pruebaTecnica.demo.RestTarjeta.service.TarjetaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1")
public class ClienteController {
    public ClienteController(ClienteServiceInterface<Cliente, Number> clienteServiceInterface, GenerateToken generateToken) {
        this.clienteServiceInterface = clienteServiceInterface;
        this.generateToken = generateToken;
    }

    @Autowired
    ClienteServiceInterface<Cliente, Number> clienteServiceInterface;
    @Autowired
    GenerateToken generateToken;
    @Autowired
    TarjetaServiceInterface tarjetaServiceInterface;

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
        Cliente cliente = new Cliente();
        cliente.setIdClient(idUser);
        clienteServiceInterface.savePersona(cliente);
        return user;

    }
    @RequestMapping(value="/cliente", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente guardarClienteTarjeta(@RequestBody Cliente cliente,
                                         @RequestParam(name = "doc") long idUser){
        try {
            Optional<Cliente> clienteObj = clienteServiceInterface.obtenerClientId(idUser);

            if (clienteObj !=null){
                List<Tarjeta> tarjetaList = new ArrayList<>();
                Tarjeta tarjeta = new Tarjeta();
                UUID uuid = UUID.randomUUID();
                int variant = uuid.variant();
                tarjeta.setNumTc(1243);
                tarjeta.setCvTc(355);
                tarjeta.setIdClient(idUser);
                tarjetaList.add(tarjeta);

                tarjetaServiceInterface.saveTarjeta(tarjeta);
                cliente.setTarjetaList(tarjetaList);
                return clienteServiceInterface.savePersona(cliente);
            }else{
                throw new ClienteExistsExepcion("El cliente No existe");
            }
        } catch (Exception e) {
            throw new ClienteExistsExepcion("El cliente ya existe");
        }

    }

    @PostMapping()
    public Cliente savePersona(@RequestBody Cliente cliente) throws Exception {
        try {
            boolean ok  = this.clienteServiceInterface.eliminarPersona(cliente.getIdClient());
            if (ok==false){
                return clienteServiceInterface.savePersona(cliente);
            }else{
                throw new ClienteExistsExepcion("El cliente ya existe");
            }
        }catch (Exception e){
            throw new ClienteExistsExepcion(e.getMessage());
        }
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<ClienteDTO> obtenerPersonaBy(@PathVariable("id") Long id) throws Exception {
        try {
            Cliente cliente = clienteServiceInterface.obtenerClientId(id).orElseThrow(RuntimeException::new);
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setIdDocuent(cliente.getIdClient());
            clienteDTO.setName(cliente.getNomCliente());
            clienteDTO.setTarjeta(cliente.getTarjetaList());
            return new ResponseEntity<ClienteDTO>(clienteDTO, HttpStatus.OK);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping
    public ArrayList<Cliente> ObtenerPersona() throws Exception {
        try {
            return clienteServiceInterface.obtenerPersona();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping()
    public Cliente updatePersona(@RequestBody Cliente cliente) throws Exception {
        try {
            return clienteServiceInterface.savePersona(cliente);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @DeleteMapping(path = "/{id}")
    public String deletePersonaBy(@PathVariable("id") Long id) throws Exception {
        try {
            boolean ok  = this.clienteServiceInterface.eliminarPersona(id);
            if (ok){
                return "Se elimino con exito el usuario " + id;
            }else {
                return "No Se elimino el usuario " + id;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }






}
