package com.pruebaTecnica.demo.RestTarjeta.models;

import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TarjetaDtoRequest {

    private String nomFranqui;
    private long idClient;




}
