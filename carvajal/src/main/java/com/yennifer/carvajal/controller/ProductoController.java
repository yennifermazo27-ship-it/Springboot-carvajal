package com.yennifer.carvajal.controller;

import com.yennifer.carvajal.dto.GlobalHttpResponse;
import com.yennifer.carvajal.dto.ProductoDTO;
import com.yennifer.carvajal.entity.Producto;
import com.yennifer.carvajal.service.ProductoService;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService productoService;

   @GetMapping
public GlobalHttpResponse<List<ProductoDTO>> listarTodos() {
    List<ProductoDTO> productos = productoService.listarTodos(); 
    return new GlobalHttpResponse<>(true, "Productos obtenidos correctamente", productos);
}

    @GetMapping("/{id}")
    public GlobalHttpResponse<Producto> buscarPorId(@PathVariable Integer id) {
        Producto producto = productoService.buscarPorId(id);
        if (producto == null) {
            return new GlobalHttpResponse<>(false, "Producto no encontrado", null);
        }
        return new GlobalHttpResponse<>(true, "Producto obtenido correctamente", producto);
    }
}