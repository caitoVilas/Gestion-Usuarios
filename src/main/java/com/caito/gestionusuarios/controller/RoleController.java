package com.caito.gestionusuarios.controller;

import com.caito.gestionusuarios.dtos.NewUserDTO;
import com.caito.gestionusuarios.dtos.PermissionsListDTO;
import com.caito.gestionusuarios.dtos.RoleRequestDTO;
import com.caito.gestionusuarios.dtos.RoleResponseDTO;
import com.caito.gestionusuarios.service.impl.RoleServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/gestion-usuarios/roles")
@CrossOrigin
@Tag(name = "Api para el manejo de Roles")
public class RoleController {

    @Autowired
    RoleServiceImpl roleService;

    @PostMapping()
    @Operation(summary = "Metodo para creacion de roles en el sistema")
    @ApiResponse(responseCode = "201", description = "rol creado")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<?> createRole(@RequestBody RoleRequestDTO requestDTO){

        RoleResponseDTO responseDTO = roleService.createRole(requestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{rolId}/{rolName}")
    @Operation(summary = "Metodo para modificacion de roles en el sistema")
    @ApiResponse(responseCode = "200", description = "rol actualizado")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<?> updateRole(@PathVariable Long rolId, @PathVariable String roleName){

        roleService.updateRole(rolId, roleName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{roleId}")
    @Operation(summary = "Metodo para eliminar un rol en el sistema")
    @ApiResponse(responseCode = "201", description = "rol creado")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<?> delete(@PathVariable Long roleId){

        return null;
    }

    @GetMapping()
    @Operation(summary = "Metodo para consultar los roles del sistema")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "204", description = "sin contenido")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<List<RoleResponseDTO>> getAll(){

        roleService.getAll();
        List<RoleResponseDTO> responseDTOList = roleService.getAll();
        if (responseDTOList.isEmpty())
            return new ResponseEntity<List<RoleResponseDTO>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<RoleResponseDTO>>(responseDTOList, HttpStatus.OK);
    }

    @PutMapping("/permisos/{roleId}")
    @Operation(summary = "Metodo para cambiar permisos a roles")
    @ApiResponse(responseCode = "200", description = "ok")
    @ApiResponse(responseCode = "400", description = "bad request")
    @ApiResponse(responseCode = "500", description = "error interno")
    public ResponseEntity<?> addPermissions(@PathVariable Long roleId,
                                                          @RequestBody
                                                          List<Long> permissions){

       roleService.addPermissions(roleId, permissions);

        return new ResponseEntity<RoleResponseDTO>(HttpStatus.OK);
    }
}
