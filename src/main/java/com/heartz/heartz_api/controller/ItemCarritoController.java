package com.heartz.heartz_api.controller;

import com.heartz.heartz_api.model.ItemCarrito;
import com.heartz.heartz_api.service.ItemCarritoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
@CrossOrigin("*")
@Tag(name = "Item Carrito Controller", description = "Endpoints para la gestión del carrito de compras")
public class ItemCarritoController {

    @Autowired
    private ItemCarritoService service;

    // Obtener todo el carrito
    @GetMapping
    @Operation(summary = "Obtener todos los items del carrito", description = "Devuelve una lista de todos los items en el carrito de compras")
    public List<ItemCarrito> getCarritoItems() {
        return service.getCarritoItems();
    }

    // Agregar item al carrito
    @PostMapping("/add/{viniloId}")
    @Operation(summary = "Agregar item al carrito", description = "Agrega un vinilo al carrito de compras basado en su ID")
    public ItemCarrito addItem(@PathVariable Integer viniloId) throws Exception {
        return service.addItemToCarrito(viniloId);
    }

    // Remover (restar) un item
    @PostMapping("/remove/{itemId}")
    @Operation(summary = "Remover item del carrito", description = "Resta una unidad del item especificado en el carrito de compras")
    public void removeItem(@PathVariable Integer itemId) {
        service.removeItemFromCarrito(itemId);
    }

    // Actualizar cantidad manualmente
    @PutMapping("/update")
    @Operation(summary = "Actualizar item del carrito", description = "Actualiza la cantidad de un item específico en el carrito de compras")
    public ItemCarrito updateItem(@RequestBody ItemCarrito item) {
        return service.updateItemCarrito(item);
    }

    // Borrar item del carrito
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar item del carrito", description = "Elimina un item específico del carrito de compras basado en su ID")
    public void deleteItem(@PathVariable Integer id) {
        service.deleteItemCarrito(id);
    }

    // Limpiar carrito completo
    @DeleteMapping("/clear")
    @Operation(summary = "Limpiar carrito", description = "Elimina todos los items del carrito de compras")
    public void clearCarrito() {
        service.clearCarrito();
    }
}
