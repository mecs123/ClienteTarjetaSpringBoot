package com.pruebaTecnica.demo.RestCliente.exepciones;

import com.pruebaTecnica.demo.RestCliente.exepciones.error.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExepcionHandler {

    @ExceptionHandler(value = {ClienteExistsExepcion.class})
    public ResponseEntity<ErrorMessage> handldeExistsException(ClienteExistsExepcion ex, WebRequest webRequest){
        ErrorMessage errorMessage  = new ErrorMessage(new Date(), "El usario ya existe.");
        return new  ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(ClienteExistsExepcion ex, WebRequest webRequest){
        ErrorMessage errorMessage  = new ErrorMessage(new Date(), ex.getMessage());
        return new  ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
