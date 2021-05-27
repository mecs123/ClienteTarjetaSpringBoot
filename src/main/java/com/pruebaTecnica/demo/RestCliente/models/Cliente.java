package com.pruebaTecnica.demo.RestCliente.models;

import com.pruebaTecnica.demo.RestTarjeta.models.Tarjeta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "clientes", uniqueConstraints={@UniqueConstraint(columnNames={"idDocClient"})})
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   idCliente;
    @Column(unique = true)
    private long   idDocClient;
    private String nomClient;
    private int    telCliente;
    private String dirClient;
    private String registDate;
    private String email;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<Tarjeta> tarjetaList;

}
