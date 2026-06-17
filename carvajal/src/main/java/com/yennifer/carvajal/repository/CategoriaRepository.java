package com.yennifer.carvajal.repository;

import com.yennifer.carvajal.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}