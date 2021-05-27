package com.pruebaTecnica.demo.RestTarjeta.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TarjetaDtoUpdate {

    private long   idTarjeta;
    private String nomFranqui;
    private String nameBanco;
    private String numCuenta;
    private String fechaExp;
    private int cvTc;
}