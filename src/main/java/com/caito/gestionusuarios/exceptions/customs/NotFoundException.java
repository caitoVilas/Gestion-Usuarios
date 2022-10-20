package com.caito.gestionusuarios.exceptions.customs;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String error){
        super(error);
    }
}
