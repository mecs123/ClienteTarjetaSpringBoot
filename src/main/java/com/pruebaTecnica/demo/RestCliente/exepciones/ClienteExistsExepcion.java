package com.pruebaTecnica.demo.RestCliente.exepciones;

public class ClienteExistsExepcion extends RuntimeException{

    private static final long serialVersionUID=1l;

    public ClienteExistsExepcion(String message){
        super(message);

    }
}
