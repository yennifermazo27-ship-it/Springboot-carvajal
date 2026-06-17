package com.yennifer.carvajal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  
@NoArgsConstructor   
public class ProductoDTO {
    private Integer id;
    private String nombre;
    private Double precio;
    private Integer cantidad_en_stock;
    private CategoriaDTO categoria; 
}