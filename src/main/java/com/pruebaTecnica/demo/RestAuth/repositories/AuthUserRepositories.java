package com.pruebaTecnica.demo.RestAuth.repositories;

import com.pruebaTecnica.demo.RestAuth.model.UserEntity;
import com.pruebaTecnica.demo.RestCliente.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AuthUserRepositories extends CrudRepository<UserEntity, Long> {

    @Transactional(readOnly=true)
    List<Cliente> findByidDocClient(Long idDocClient);

}
