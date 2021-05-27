package com.pruebaTecnica.demo.Exepciones;

import com.pruebaTecnica.demo.Exepciones.error.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExepcionHandler {

    @ExceptionHandler(value = {ExepcionApiNuvu.class})
    public ResponseEntity<ErrorMessage> handldeExistsException(ExepcionApiNuvu ex, WebRequest webRequest){
        ErrorMessage errorMessage  = new ErrorMessage(new Date(), ex.getMessage());
        return new  ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(ExepcionApiNuvu ex, WebRequest webRequest){
        ErrorMessage errorMessage  = new ErrorMessage(new Date(), ex.getMessage());
        return new  ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
