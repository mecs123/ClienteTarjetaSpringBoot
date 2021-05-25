package com.pruebaTecnica.demo.RestCliente.models;

import com.pruebaTecnica.demo.RestTarjeta.models.Tarjeta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @Column(name="idClient",unique = true,nullable = false)
    private long idClient;
    private String nomCliente;
    private int telefono;
    private String direccion;
    @Column(name = "feche_resgistro")
    private String registDate;
    @ElementCollection
    @OneToMany(targetEntity=Tarjeta.class, mappedBy="idClient", fetch=FetchType.EAGER)
    private List<Tarjeta> tarjetaList;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
}
