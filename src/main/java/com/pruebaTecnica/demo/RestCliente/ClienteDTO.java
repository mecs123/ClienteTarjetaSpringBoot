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

    private long idDocuent;
    private String name;
    private List<Tarjeta> tarjeta;


}
