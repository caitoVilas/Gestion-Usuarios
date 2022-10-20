package com.caito.gestionusuarios.exceptions.customs;

public class EmptyInputException extends RuntimeException{

    public EmptyInputException(String error){
        super(error);
    }
}
