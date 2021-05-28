package com.pruebaTecnica.demo.RestTarjeta.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TarjetaDtoListar {

    private long idTarjeta;
    private String nomFranqui;
    private String nameBanco;
    private String numCuenta;
    private Date fechaExp;
    private int cvTc;
    private long idClient;
}