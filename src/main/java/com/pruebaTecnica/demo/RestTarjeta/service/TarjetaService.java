package com.pruebaTecnica.demo.RestTarjeta.service;

import com.pruebaTecnica.demo.RestTarjeta.models.Tarjeta;
import com.pruebaTecnica.demo.RestTarjeta.models.TarjetaDtoListar;
import com.pruebaTecnica.demo.RestTarjeta.models.TarjetaDtoRequest;
import com.pruebaTecnica.demo.RestTarjeta.models.TarjetaDtoUpdate;
import com.pruebaTecnica.demo.RestTarjeta.repository.TarjetaRepositories;
import com.pruebaTecnica.demo.Exepciones.ExepcionApiNuvu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static com.pruebaTecnica.demo.Exepciones.ConstantsErrorTarjeta.NOTFOUNDIDTARJETA;
import static com.pruebaTecnica.demo.Exepciones.ConstantsErrorTarjeta.NOTFOUNDTARJET;

@Service
public class TarjetaService implements TarjetaServiceInterface {

    @Autowired
    TarjetaRepositories tarjetaRepositories;
    ZoneId defaultZoneId = ZoneId.systemDefault();
    LocalDate localDate = LocalDate.of(2021, 5, 27);
    Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

    @Override
    public Tarjeta crearTarjeta(TarjetaDtoRequest tarjetaDtoRequest) {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setNomFranqui(tarjetaDtoRequest.getNomFranqui());
        tarjeta.setIdClient(tarjetaDtoRequest.getIdClient());
        UUID numCuenta = UUID.randomUUID();
        tarjeta.setNumCuenta(numCuenta.toString());
        tarjeta.setNameBanco("MyBanco");
        int numeroAleatorio = (int) (Math.random()*4+1);
        tarjeta.setCvTc(numeroAleatorio);
        tarjeta.setFechaExp(date);
        return  tarjetaRepositories.save(tarjeta);
    }

    @Override
    public Optional<TarjetaDtoListar> getAllTarjetaId(Long id) {
        TarjetaDtoListar tarjetaDtoRequest = new TarjetaDtoListar();
        Tarjeta tarjeta =  tarjetaRepositories.findById(id).orElseThrow(()-> new ExepcionApiNuvu(NOTFOUNDTARJET));
        tarjetaDtoRequest.setIdTarjeta(tarjeta.getIdTarjeta());
        tarjetaDtoRequest.setIdClient(tarjeta.getIdClient());
        tarjetaDtoRequest.setNameBanco(tarjeta.getNameBanco());
        tarjetaDtoRequest.setNumCuenta(tarjeta.getNumCuenta());
        tarjetaDtoRequest.setIdClient(tarjeta.getIdTarjeta());
        tarjetaDtoRequest.setIdClient(tarjeta.getIdClient());
        tarjetaDtoRequest.setFechaExp(date);
        tarjetaDtoRequest.setCvTc(tarjeta.getCvTc());
        tarjetaDtoRequest.setNomFranqui(tarjeta.getNomFranqui());
        return Optional.of(tarjetaDtoRequest);
    }

    @Override
    public Tarjeta updateTarjeta(TarjetaDtoUpdate tarjetaDtoRequest) {
        Tarjeta tarjeta = tarjetaRepositories.findById(tarjetaDtoRequest.getIdTarjeta()) .orElseThrow(() -> new ExepcionApiNuvu(NOTFOUNDIDTARJETA + tarjetaDtoRequest.getIdTarjeta()));
        tarjeta.setNomFranqui(tarjetaDtoRequest.getNomFranqui());
        tarjeta.setNameBanco(tarjetaDtoRequest.getNameBanco());
        tarjeta.setNumCuenta(tarjetaDtoRequest.getNumCuenta());
        tarjeta.setFechaExp(date);
        tarjeta.setCvTc(tarjetaDtoRequest.getCvTc());
        return   tarjetaRepositories.save(tarjeta);
    }

    @Override
    public void deleteTarjeta(Long id) {
        tarjetaRepositories.findById(id).orElseThrow(() -> new ExepcionApiNuvu(NOTFOUNDIDTARJETA));
        tarjetaRepositories.deleteById(id);
    }

}