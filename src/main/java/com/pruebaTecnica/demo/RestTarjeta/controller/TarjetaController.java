package com.pruebaTecnica.demo.RestTarjeta.controller;

import com.pruebaTecnica.demo.RestCliente.service.ClienteServiceInterface;
import com.pruebaTecnica.demo.RestTarjeta.models.Tarjeta;
import com.pruebaTecnica.demo.RestTarjeta.service.TarjetaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaController {

    @Autowired
    TarjetaServiceInterface<Tarjeta, Long> tarjetaServiceInterface;
    @Autowired
    ClienteServiceInterface clienteServiceInterface;


    @PostMapping()
    public Tarjeta saveTarjeta(@RequestBody Tarjeta tarjeta) throws Exception {
        try {

            return tarjetaServiceInterface.saveTarjeta(tarjeta);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping
    public ArrayList<Tarjeta> ObtenerTarjeta() throws Exception {
        try {

            return tarjetaServiceInterface.obtenerTarjeta();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping()
    public Tarjeta TarjetaCreditoupdatePersona(@RequestBody Tarjeta tarjeta) throws Exception {
        try {
            return tarjetaServiceInterface.saveTarjeta(tarjeta);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<Tarjeta> obtenerPersonaBy(@PathVariable("id") Long id) throws Exception {
        try {
            return tarjetaServiceInterface.obtenerTarjetaFindBy(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @DeleteMapping(path = "/{id}")
    public String deletePersonaBy(@PathVariable("id") Long id) throws Exception {
        try {
            boolean ok  = this.tarjetaServiceInterface.eliminarTarjeta(id);
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
