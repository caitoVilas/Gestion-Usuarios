package com.caito.gestionusuarios.exceptions.customs;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String error){
        super(error);
    }
}
