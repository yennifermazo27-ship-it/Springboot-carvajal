package com.yennifer.carvajal.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private Double precio;
    private Integer cantidad_en_stock;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}