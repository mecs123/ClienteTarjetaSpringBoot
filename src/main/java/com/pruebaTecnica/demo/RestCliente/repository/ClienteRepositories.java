package com.pruebaTecnica.demo.RestCliente.repository;


import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepositories extends CrudRepository<Cliente, Long> {


}
