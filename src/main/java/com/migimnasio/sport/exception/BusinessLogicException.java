package com.migimnasio.sport.exception;

public class BusinessLogicException extends RuntimeException{
    /*
    errores de lógica de negocio
    ej: alumno ya tiene asignado otro plan de carrera activo
     */
    public BusinessLogicException(String message){
        super(message);
    }
}
