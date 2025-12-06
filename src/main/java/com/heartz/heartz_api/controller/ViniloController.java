package com.heartz.heartz_api.controller;

import com.heartz.heartz_api.model.Vinilo;
import com.heartz.heartz_api.service.ViniloService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinilos")
@CrossOrigin("*")
@Tag(name = "Vinilo Controller", description = "Endpoints para la gestión de vinilos")
public class ViniloController {

    @Autowired
    private ViniloService service;

    @GetMapping
    @Operation(summary = "Obtener todos los vinilos", description = "Devuelve una lista de todos los vinilos disponibles")
    public List<Vinilo> getAllVinilos() {
        return service.getAllVinilos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener vinilo por ID", description = "Devuelve un vinilo específico basado en su ID")
    public Vinilo getViniloById(@PathVariable Integer id) {
        return service.getViniloById(id);
    }

    @PostMapping
    @Operation(summary = "Insertar nuevo vinilo", description = "Agrega un nuevo vinilo a la base de datos")
    public Vinilo insertVinilo(@RequestBody Vinilo v) {
        return service.insertVinilo(v);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar vinilo", description = "Actualiza la información de un vinilo existente")
    public Vinilo updateVinilo(@PathVariable Integer id, @RequestBody Vinilo v) {
        v.setIdVin(id);
        return service.updateVinilo(v);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar vinilo", description = "Elimina un vinilo específico basado en su ID")
    public void deleteVinilo(@PathVariable Integer id) {
        service.deleteVinilo(id);
    }

    @DeleteMapping("/all")
    @Operation(summary = "Eliminar todos los vinilos", description = "Elimina todos los vinilos de la base de datos")
    public void deleteAllVinilos() {
        service.deleteAllVinilos();
    }
}
