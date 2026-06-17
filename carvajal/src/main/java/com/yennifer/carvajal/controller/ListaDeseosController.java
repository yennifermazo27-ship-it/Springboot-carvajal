package com.yennifer.carvajal.controller;

import com.yennifer.carvajal.dto.GlobalHttpResponse;
import com.yennifer.carvajal.entity.Historial;
import com.yennifer.carvajal.entity.ListaDeseos;
import com.yennifer.carvajal.service.ListaDeseosService;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/lista-deseos")
@CrossOrigin(origins = "*")
public class ListaDeseosController {

   
    private final ListaDeseosService listaDeseosService;

    @GetMapping
    public GlobalHttpResponse<List<ListaDeseos>> listarTodos() {
        List<ListaDeseos> lista = listaDeseosService.listarTodos();
        return new GlobalHttpResponse<>(true, "Lista de deseos obtenida correctamente", lista);
    }

    @PostMapping
    public GlobalHttpResponse<ListaDeseos> agregar(@RequestBody ListaDeseos item) {
        ListaDeseos guardado = listaDeseosService.agregar(item);
        return new GlobalHttpResponse<>(true, "Producto agregado a la lista de deseos", guardado);
    }

    @DeleteMapping("/{id}")
    public GlobalHttpResponse<String> eliminar(@PathVariable Integer id) {
        listaDeseosService.eliminar(id);
        return new GlobalHttpResponse<>(true, "Producto eliminado de la lista de deseos", null);
    }

    @GetMapping("/historial")
    public GlobalHttpResponse<List<Historial>> listarHistorial() {
        List<Historial> historial = listaDeseosService.listarHistorial();
        return new GlobalHttpResponse<>(true, "Historial obtenido correctamente", historial);
    }
}