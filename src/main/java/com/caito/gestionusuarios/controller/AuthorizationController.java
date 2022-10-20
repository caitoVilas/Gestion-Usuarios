package com.caito.gestionusuarios.controller;

import com.caito.gestionusuarios.dtos.LoginDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/gestion-usuarios/auth")
@CrossOrigin
@Tag(name = "Api para autenticacion")
public class AuthorizationController {

    @PostMapping("/login")
    @Operation(summary = "Metodo para autenticar un usuario al sistema")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "403", description = "no autorizado")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        return null;
    }

    @PostMapping("/logout/{token}")
    @Operation(summary = "Metodo finalizar sesion de un usuario al sistema")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "403", description = "no autorizado")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<?> logout(@PathVariable String token){
        return null;
    }
}
