package com.pruebaTecnica.demo.RestTarjeta.models;

import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tarjetas")
public class Tarjeta {
    @Id
    @Column(name="Id_tarjeta",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTarjeta;
    private String nomFranqui;
    private String nameBanco;
    private long numCuenta;
    private long fechaExp;
    private int cvTc;
    private long idClient;
    @ManyToOne
    @JoinColumn(name = "fk_idClienteTarjeta")
    private Cliente fk_idTarjetaCliente;





}
