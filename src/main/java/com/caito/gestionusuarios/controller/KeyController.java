package com.caito.gestionusuarios.controller;

import com.caito.gestionusuarios.dtos.ChangeKeyDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/gestion-usuarios/claves")
@CrossOrigin
@Tag(name = "Api para el manejo de Claves")
public class KeyController {

    @PostMapping()
    @Operation(summary = "Metodo para cambiar contraseña de usuario")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "404", description = "no encontrado")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<?> updatePerson(@RequestBody ChangeKeyDTO changeKeyDTO){

        return null;
    }
}
