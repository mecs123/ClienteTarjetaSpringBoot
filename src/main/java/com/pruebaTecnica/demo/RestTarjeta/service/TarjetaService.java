package com.pruebaTecnica.demo.RestTarjeta.service;


import com.pruebaTecnica.demo.RestTarjeta.models.Tarjeta;
import com.pruebaTecnica.demo.RestTarjeta.repository.TarjetaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TarjetaService implements TarjetaServiceInterface<Tarjeta, Long> {
    @Autowired
    TarjetaRepositories tarjetaRepositories;


    @Override
    public Tarjeta saveTarjeta(Tarjeta tarjeta) {
      return  tarjetaRepositories.save(tarjeta);
    }

    @Override
    public ArrayList<Tarjeta> obtenerTarjeta() {
        return (ArrayList<Tarjeta>) tarjetaRepositories.findAll();
    }

    @Override
    public Optional<Tarjeta> obtenerTarjetaFindBy(Long id) {
        return tarjetaRepositories.findById(id);
    }

    @Override
    public boolean eliminarTarjeta(Long id) {
        try {
            tarjetaRepositories.deleteById(id);
            return  true;
        } catch (Exception err) {
            return false;
        }
    }
}
