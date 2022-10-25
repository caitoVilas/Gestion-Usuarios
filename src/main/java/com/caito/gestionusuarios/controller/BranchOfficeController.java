package com.caito.gestionusuarios.controller;

import com.caito.gestionusuarios.dtos.BranchOfficeRequestDTO;
import com.caito.gestionusuarios.dtos.BranchOfficeResponseDTO;
import com.caito.gestionusuarios.service.impl.BranchOfficeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gestion-usuarios/sucursales")
@CrossOrigin
@Tag(name = "Api para el manejo de sucursales")
public class BranchOfficeController {

    @Autowired
    BranchOfficeServiceImpl branchOfficeService;

    @PostMapping
    @Operation(summary = "Metodo que crea una sucursal en el sistema")
    @ApiResponse(responseCode = "201", description = "sucursal creado")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<?> createBranchOffice(@RequestBody BranchOfficeRequestDTO requestDTO){

        branchOfficeService.createBranchOffice(requestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    @Operation(summary = "Metodo que muestra una lista de sucursales")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "204", description = "sin contenido")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<List<BranchOfficeResponseDTO>> getAll(){

        List<BranchOfficeResponseDTO> list = branchOfficeService.getAll();
        if (list.isEmpty())
            return new ResponseEntity<List<BranchOfficeResponseDTO>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<BranchOfficeResponseDTO>>(list, HttpStatus.OK);
    }

    @GetMapping("/descripcion/{description}")
    @Operation(summary = "Metodo que muestra una sucursal por descripcion si existe")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "204", description = "sin contenido")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<BranchOfficeResponseDTO> getByDescription(@PathVariable String description){

        return new ResponseEntity<BranchOfficeResponseDTO>(branchOfficeService.getByDescription(description),
                HttpStatus.OK);
    }

    @DeleteMapping("/{branchOfficeId}")
    @Operation(summary = "Metodo para dar de baja una sucursal del sistema")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "404", description = "no encontrado")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<?> delete(@PathVariable Long branchOfficeId){

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
