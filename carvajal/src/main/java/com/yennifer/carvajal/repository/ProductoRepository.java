package com.yennifer.carvajal.repository;

import com.yennifer.carvajal.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}