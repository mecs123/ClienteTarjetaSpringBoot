package com.pruebaTecnica.demo.RestTarjeta.models;

import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tarjeta")
public class Tarjeta {
    @Id
    @Column(name="idTC",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTarjeta;
    private long idClient;
    private String tipoTc;
    private String nameBanco;
    private int numTc;
    private long fechaExp;
    private int cvTc;





}
