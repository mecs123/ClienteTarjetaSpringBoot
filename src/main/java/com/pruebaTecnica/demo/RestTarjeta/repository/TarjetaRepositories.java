package com.pruebaTecnica.demo.RestTarjeta.repository;


import com.pruebaTecnica.demo.RestTarjeta.models.Tarjeta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarjetaRepositories extends CrudRepository<Tarjeta, Long> {

    List<Tarjeta> findAllByIdClient(Long id);

}
