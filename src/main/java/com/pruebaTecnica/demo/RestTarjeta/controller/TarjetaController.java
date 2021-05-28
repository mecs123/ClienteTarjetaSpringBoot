package com.pruebaTecnica.demo.RestTarjeta.controller;
import com.pruebaTecnica.demo.RestTarjeta.models.Tarjeta;
import com.pruebaTecnica.demo.RestTarjeta.models.TarjetaDtoListar;
import com.pruebaTecnica.demo.RestTarjeta.models.TarjetaDtoRequest;
import com.pruebaTecnica.demo.RestTarjeta.models.TarjetaDtoUpdate;
import com.pruebaTecnica.demo.RestTarjeta.service.TarjetaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class TarjetaController {

    @Autowired
    TarjetaServiceInterface tarjetaServiceInterface;

    @PostMapping("tarjeta")
    public ResponseEntity <Tarjeta> crearTarjeta(@RequestBody TarjetaDtoRequest tarjetaDtoRequest){
      return new ResponseEntity<Tarjeta>(tarjetaServiceInterface.crearTarjeta(tarjetaDtoRequest),HttpStatus.CREATED);
    }
    @GetMapping(path = "/tarjeta/{id}")
    public ResponseEntity<TarjetaDtoListar> getallTarjetaById(@PathVariable("id") Long id){
        return new ResponseEntity<TarjetaDtoListar>(tarjetaServiceInterface.getAllTarjetaId(id).get(),HttpStatus.ACCEPTED);
    }
    @PutMapping(path = "/tarjeta")
    public ResponseEntity<Tarjeta> updateTarjetaById(@RequestBody TarjetaDtoUpdate tarjetaDtoRequest){
        return new ResponseEntity<Tarjeta>(tarjetaServiceInterface.updateTarjeta(tarjetaDtoRequest),HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/tarjeta/{id}")
    public ResponseEntity<String> deleteClienteBy(@PathVariable("id") Long id){
        tarjetaServiceInterface.deleteTarjeta(id);
        return  new ResponseEntity<>("Tarjeta Eliminada con Exito",HttpStatus.OK);
    }

}