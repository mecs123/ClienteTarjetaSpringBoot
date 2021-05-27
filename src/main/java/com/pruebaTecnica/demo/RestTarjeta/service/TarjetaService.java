package com.pruebaTecnica.demo.RestTarjeta.service;
import com.pruebaTecnica.demo.RestTarjeta.models.Tarjeta;
import com.pruebaTecnica.demo.RestTarjeta.models.TarjetaDtoRequest;
import com.pruebaTecnica.demo.RestTarjeta.models.TarjetaDtoUpdate;
import com.pruebaTecnica.demo.RestTarjeta.repository.TarjetaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarjetaService implements TarjetaServiceInterface {

    @Autowired
    TarjetaRepositories tarjetaRepositories;

    @Override
    public Tarjeta crearTarjeta(TarjetaDtoRequest tarjetaDtoRequest) {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setNomFranqui(tarjetaDtoRequest.getNomFranqui());
        tarjeta.setIdClient(tarjetaDtoRequest.getIdClient());
        tarjeta.setNumCuenta("1232132");
        tarjeta.setCvTc(123);
        return  tarjetaRepositories.save(tarjeta);
    }

    @Override
    public Optional<TarjetaDtoUpdate> getAllTarjetaId(Long id) {
        TarjetaDtoUpdate tarjetaDtoUpdate = new TarjetaDtoUpdate();
        Tarjeta tarjeta =  tarjetaRepositories.findById(id).orElseThrow(RuntimeException::new);
        tarjetaDtoUpdate.setIdTarjeta(tarjeta.getIdTarjeta());
        tarjetaDtoUpdate.setIdClient(tarjeta.getIdClient());
        tarjetaDtoUpdate.setNomFranqui(tarjeta.getNomFranqui());
        tarjetaDtoUpdate.setFechaExp(tarjeta.getFechaExp());
        tarjetaDtoUpdate.setCvTc(tarjeta.getCvTc());
        return Optional.of(tarjetaDtoUpdate);
    }

    @Override
    public Tarjeta updateTarjeta(TarjetaDtoUpdate tarjetaDtoRequest, Long idTarjeta) {
        Tarjeta tarjeta = tarjetaRepositories.findById(idTarjeta) .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + idTarjeta));
        tarjeta.setIdClient(tarjetaDtoRequest.getIdClient());
        tarjeta.setNumCuenta(tarjetaDtoRequest.getNumCuenta());
        tarjeta.setNomFranqui(tarjetaDtoRequest.getNomFranqui());
        tarjeta.setCvTc(tarjetaDtoRequest.getCvTc());
        return   tarjetaRepositories.save(tarjeta);
    }

    @Override
    public void deleteTarjeta(Long id) {
        tarjetaRepositories.findById(id).orElseThrow(RuntimeException::new);
        tarjetaRepositories.deleteById(id);

    }

}