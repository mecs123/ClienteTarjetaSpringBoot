package com.pruebaTecnica.demo.RestCliente;

import com.pruebaTecnica.demo.RestTarjeta.models.Tarjeta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO {

    private long idClient;
    private String nomClient;
    private int telCliente;
    private String dirClient;
    private String registDate;
    private List<Tarjeta> tarjetaList;


}
