package com.pruebaTecnica.demo.RestTarjeta.models;

import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TarjetaDto {

    private int idTarjeta;
    private String nomFranqui;
    private String nameBanco;
    private long numCuenta;
    private long fechaExp;
    private int cvTc;
    private long idClient;
    private Cliente clientes;





}
