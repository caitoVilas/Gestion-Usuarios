package com.caito.gestionusuarios.controller;

import com.caito.gestionusuarios.dtos.DataPersonDTO;
import com.caito.gestionusuarios.dtos.NewUserDTO;
import com.caito.gestionusuarios.dtos.UserResponseDTO;
import com.caito.gestionusuarios.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/gestion-usuarios/usuarios")
@CrossOrigin
@Tag(name = "Api para el manejo de usuarios")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping
    @Operation(summary = "Metodo que crea un usuario asociado a una persona en el sistema")
    @ApiResponse(responseCode = "201", description = "usuario creado")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<?> createUser(@RequestBody NewUserDTO newUserDTO){

        userService.createUser(newUserDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Metodo que muestra una usuario por id si existe")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "404", description = "no encontrado")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<UserResponseDTO> findUserById(@PathVariable Long userId){


        return new ResponseEntity<UserResponseDTO>(userService.getUser(userId), HttpStatus.OK);
    }

    @GetMapping()
    @Operation(summary = "Metodo que muestra una lista de usuarios")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "204", description = "sin contenido")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<List<UserResponseDTO>> findAll(){

        List<UserResponseDTO> responseDTOS = userService.getAll();
        if (responseDTOS.isEmpty())
            return new ResponseEntity<List<UserResponseDTO>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<UserResponseDTO>>(responseDTOS, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    @Operation(summary = "Metodo para dar de baja un usuario del sistema")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "404", description = "no encontrado")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<?> updatePerson(@PathVariable Long userId){

        return null;
    }
}
