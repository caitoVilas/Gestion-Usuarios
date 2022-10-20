package com.caito.gestionusuarios.controller;

import com.caito.gestionusuarios.dtos.NewUserDTO;
import com.caito.gestionusuarios.dtos.PermissionRequestDTO;
import com.caito.gestionusuarios.dtos.PermissionResponseDTO;
import com.caito.gestionusuarios.dtos.UserResponseDTO;
import com.caito.gestionusuarios.service.impl.PermisssionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gestion-usuarios/permisos")
@CrossOrigin
@Tag(name = "Api para el manejo de permisos")
public class PermissionController {

    @Autowired
    PermisssionServiceImpl permisssionService;

    @PostMapping
    @Operation(summary = "Metodo que crea un permiso en el sistema")
    @ApiResponse(responseCode = "201", description = "permiso creado")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<?> createPermission(@RequestBody PermissionRequestDTO permissionRequestDTO){

        permisssionService.createPermission(permissionRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    @Operation(summary = "Metodo que muestra una lista de permisos")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "204", description = "sin contenido")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<List<PermissionResponseDTO>> findAll(){

        List<PermissionResponseDTO> responseDTOS = permisssionService.getAll();
        if (responseDTOS.isEmpty())
            return new ResponseEntity<List<PermissionResponseDTO>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<PermissionResponseDTO>>(responseDTOS, HttpStatus.OK);
    }
}
