package com.yennifer.carvajal.controller;

import com.yennifer.carvajal.dto.GlobalHttpResponse;
import com.yennifer.carvajal.entity.Categoria;
import com.yennifer.carvajal.service.CategoriaService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

    
    private  final CategoriaService categoriaService;

    @GetMapping
    public GlobalHttpResponse<List<Categoria>> listarTodos() {
        List<Categoria> categorias = categoriaService.listarTodos();
        return new GlobalHttpResponse<>(true, "Categorías obtenidas correctamente", categorias);
    }
}