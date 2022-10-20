package com.caito.gestionusuarios.controller;

import com.caito.gestionusuarios.dtos.DataPersonDTO;
import com.caito.gestionusuarios.dtos.PersonResponseDTO;
import com.caito.gestionusuarios.service.impl.PersonServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gestion-usuarios/personas")
@CrossOrigin
@Tag(name = "Api para el manejo de personas")
public class PersonController {

    @Autowired
    PersonServiceImpl personService;

    @GetMapping("/{personId}")
    @Operation(summary = "Metodo que muestra una persona por id si existe")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "404", description = "no encontrado")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<?> findPersonById(@PathVariable Long personId){

        PersonResponseDTO responseDTO = personService.getPerson(personId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping()
    @Operation(summary = "Metodo que muestra una lista de personas")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "204", description = "sin contenido")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<List<PersonResponseDTO>> findAll(){

        List<PersonResponseDTO> responseDTOS = personService.getAll();
        if (responseDTOS.isEmpty()){
            return new ResponseEntity<List<PersonResponseDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<PersonResponseDTO>>(responseDTOS, HttpStatus.OK);
    }

    @PostMapping("/{personId}")
    @Operation(summary = "Metodo para modificar datos de una persona")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "404", description = "no encontrado")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<?> updatePerson(@PathVariable Long personId, @RequestBody DataPersonDTO dataPersonDTO){

        return null;
    }

    @GetMapping("/apellido/{surname}")
    @Operation(summary = "Metodo para buscar personas por apellido")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "204", description = "sin contenido")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<List<PersonResponseDTO>> getBySurname(@PathVariable String surname){

        List<PersonResponseDTO> responseDTOList = personService.getBySurname(surname);

        if (responseDTOList.isEmpty())
            return new ResponseEntity<List<PersonResponseDTO>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<PersonResponseDTO>>(responseDTOList, HttpStatus.OK);
    }
}
