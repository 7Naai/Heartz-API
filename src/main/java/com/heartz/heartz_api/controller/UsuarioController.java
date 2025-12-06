package com.heartz.heartz_api.controller;

import com.heartz.heartz_api.model.Usuario;
import com.heartz.heartz_api.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
@Tag(name = "Usuario Controller", description = "Endpoints para la gestión de usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista de todos los usuarios registrados")
    public List<Usuario> getAllUsuarios() {
        return service.getAllUsuarios();
    }

    @GetMapping("/{rut}")
    @Operation(summary = "Obtener usuario por RUT", description = "Devuelve un usuario específico basado en su RUT")
    public Usuario getUsuarioByRut(@PathVariable String rut) {
        return service.getUsuarioByRut(rut);
    }

    @GetMapping("/correo/{correo}")
    @Operation(summary = "Obtener usuario por correo", description = "Devuelve un usuario específico basado en su correo electrónico")
    public Usuario getUsuarioByCorreo(@PathVariable String correo) {
        return service.getUsuarioByCorreo(correo);
    }

    @PostMapping
    @Operation(summary = "Insertar nuevo usuario", description = "Agrega un nuevo usuario a la base de datos")
    public Usuario insertUsuario(@RequestBody Usuario usuario) {
        return service.insertUsuario(usuario);
    }

    @DeleteMapping("/all")
    @Operation(summary = "Eliminar todos los usuarios", description = "Elimina todos los usuarios de la base de datos")
    public void deleteAllUsuarios() {
        service.deleteAllUsuarios();
    }
}
