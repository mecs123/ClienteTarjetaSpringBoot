package com.pruebaTecnica.demo.RestTarjeta.service;

import com.pruebaTecnica.demo.RestTarjeta.models.Tarjeta;

import java.util.ArrayList;
import java.util.Optional;


public interface TarjetaServiceInterface<E extends Tarjeta, L extends Number> {
    public Tarjeta saveTarjeta(Tarjeta tarjeta);

    ArrayList<Tarjeta> obtenerTarjeta();

    Optional<Tarjeta> obtenerTarjetaFindBy(Long id);

    boolean eliminarTarjeta(Long id);
}
