package com.caito.gestionusuarios.exceptions;

import com.caito.gestionusuarios.dtos.ErrorResponse;
import com.caito.gestionusuarios.exceptions.customs.BadRequestException;
import com.caito.gestionusuarios.exceptions.customs.EmptyInputException;
import com.caito.gestionusuarios.exceptions.customs.Forbideen;
import com.caito.gestionusuarios.exceptions.customs.NotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class RestResponseHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ErrorResponse> notFoundException(Exception e, HttpServletRequest request){

        ErrorResponse response = new ErrorResponse(404, LocalDateTime.now(), e.getMessage(),
                request.getRequestURI());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            BadRequestException.class,
            DuplicateKeyException.class,
            MethodArgumentTypeMismatchException.class,
            EmptyInputException.class
    })
    protected ResponseEntity<ErrorResponse> badRequestEsception(Exception e, HttpServletRequest request){

        ErrorResponse response = new ErrorResponse(400, LocalDateTime.now(), e.getMessage(),
                request.getRequestURI());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Forbideen.class)
    protected ResponseEntity<ErrorResponse> forbidden(Exception e, HttpServletRequest request){

        ErrorResponse response = new ErrorResponse(403, LocalDateTime.now(), e.getMessage(),
                request.getRequestURI());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    protected ResponseEntity<ErrorResponse> httpClientException(Exception e, HttpServletRequest request){

        ErrorResponse response = new ErrorResponse(409, LocalDateTime.now(), e.getMessage(),
                request.getRequestURI());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.CONFLICT);
    }
}
