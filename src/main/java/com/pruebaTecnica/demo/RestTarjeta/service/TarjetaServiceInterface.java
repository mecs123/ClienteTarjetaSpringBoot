package com.pruebaTecnica.demo.RestTarjeta.service;


import com.pruebaTecnica.demo.RestTarjeta.models.Tarjeta;
import com.pruebaTecnica.demo.RestTarjeta.models.TarjetaDtoListar;
import com.pruebaTecnica.demo.RestTarjeta.models.TarjetaDtoRequest;
import com.pruebaTecnica.demo.RestTarjeta.models.TarjetaDtoUpdate;

import java.util.Optional;

public interface TarjetaServiceInterface {
    Tarjeta crearTarjeta(TarjetaDtoRequest tarjeta);
    Optional<TarjetaDtoListar> getAllTarjetaId(Long id);
    Tarjeta updateTarjeta(TarjetaDtoUpdate tarjetaDtoRequest);
    void deleteTarjeta(Long id);
}
