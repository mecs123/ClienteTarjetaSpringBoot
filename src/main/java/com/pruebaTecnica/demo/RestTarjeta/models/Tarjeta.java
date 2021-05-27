package com.pruebaTecnica.demo.RestTarjeta.models;
import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tarjetas")
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long    idTarjeta;
    private String nomFranqui;
    private String nameBanco;
    private String numCuenta;
    private Date fechaExp;
    private int    cvTc;
    private long   idClient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
}