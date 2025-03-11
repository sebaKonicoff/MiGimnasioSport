package com.migimnasio.sport.exception;

public class ValidationException extends RuntimeException{
    //manejar errores de datos faltantes
    public ValidationException(String message){
        super(message);
    }
}
