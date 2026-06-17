package com.yennifer.carvajal.service;

import com.yennifer.carvajal.entity.Historial;
import com.yennifer.carvajal.entity.ListaDeseos;
import com.yennifer.carvajal.repository.HistorialRepository;
import com.yennifer.carvajal.repository.ListaDeseosRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ListaDeseosService {

    
    private final  ListaDeseosRepository listaDeseosRepository;

    
    private final HistorialRepository historialRepository;

    public List<ListaDeseos> listarTodos() {
        return listaDeseosRepository.findAll();
    }

    public ListaDeseos agregar(ListaDeseos item) {
        item.setFecha_agregado(LocalDateTime.now());
        ListaDeseos guardado = listaDeseosRepository.save(item);

        Historial historial = new Historial();
        historial.setProducto_id(item.getProducto_id());
        historial.setAccion("ADDED");
        historial.setFecha_accion(LocalDateTime.now());
        historialRepository.save(historial);

        return guardado;
    }

    public ListaDeseos actualizar(Integer id, ListaDeseos itemActualizado) {
        ListaDeseos item = listaDeseosRepository.findById(id).orElse(null);
        if (item != null) {
            item.setProducto_id(itemActualizado.getProducto_id());
            return listaDeseosRepository.save(item);
        }
        return null;
    }

    public void eliminar(Integer id) {
        ListaDeseos item = listaDeseosRepository.findById(id).orElse(null);
        if (item != null) {
            Historial historial = new Historial();
            historial.setProducto_id(item.getProducto_id());
            historial.setAccion("REMOVED");
            historial.setFecha_accion(LocalDateTime.now());
            historialRepository.save(historial);

            listaDeseosRepository.deleteById(id);
        }
    }

    public List<Historial> listarHistorial() {
        return historialRepository.findAll();
    }
}