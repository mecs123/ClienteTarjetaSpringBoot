package com.pruebaTecnica.demo.RestTarjeta.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TarjetaDto {

    private int idTarjeta;
    private long idClient;
    private String tipoTc;
    private String nameBanco;
    private int numTc;
    private Date fechaExp;
    private int cvTc;





}
