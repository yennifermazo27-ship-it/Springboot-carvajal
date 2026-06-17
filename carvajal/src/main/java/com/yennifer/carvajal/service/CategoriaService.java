package com.yennifer.carvajal.service;

import com.yennifer.carvajal.entity.Categoria;
import com.yennifer.carvajal.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaService {

    
    private final CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}