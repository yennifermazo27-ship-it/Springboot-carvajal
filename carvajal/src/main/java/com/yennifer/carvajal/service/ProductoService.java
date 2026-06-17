package com.yennifer.carvajal.service;

import com.yennifer.carvajal.dto.CategoriaDTO;
import com.yennifer.carvajal.dto.ProductoDTO;
import com.yennifer.carvajal.entity.Producto;
import com.yennifer.carvajal.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductoService {

   
    private final ProductoRepository productoRepository;

  public List<ProductoDTO> listarTodos() {
    return productoRepository.findAll().stream()
            .map(p -> new ProductoDTO(
                    p.getId(),
                    p.getNombre(),
                    p.getPrecio(),
                    p.getCantidad_en_stock(),
                    new CategoriaDTO(
                            p.getCategoria().getId(),
                            p.getCategoria().getNombre())))
            .collect(Collectors.toList());
}
    

    public Producto buscarPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizar(Integer id, Producto productoActualizado) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setCantidad_en_stock(productoActualizado.getCantidad_en_stock());
            producto.setCategoria(productoActualizado.getCategoria());
            return productoRepository.save(producto);
        }
        return null;
    }

    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }
}