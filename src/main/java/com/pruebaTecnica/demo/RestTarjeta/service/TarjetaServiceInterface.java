package com.pruebaTecnica.demo.RestTarjeta.service;


import com.pruebaTecnica.demo.RestTarjeta.models.Tarjeta;
import com.pruebaTecnica.demo.RestTarjeta.models.TarjetaDtoRequest;
import com.pruebaTecnica.demo.RestTarjeta.models.TarjetaDtoUpdate;

import java.util.Optional;

public interface TarjetaServiceInterface {
    Tarjeta crearTarjeta(TarjetaDtoRequest tarjeta);
    Optional<TarjetaDtoUpdate> getAllTarjetaId(Long id);
    Tarjeta updateTarjeta(TarjetaDtoUpdate tarjetaDtoRequest, Long idTarjeta);
    void deleteTarjeta(Long id);
}
