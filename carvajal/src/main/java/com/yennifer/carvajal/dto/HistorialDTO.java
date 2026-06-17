package com.yennifer.carvajal.dto;

import lombok.Data;

@Data
public class HistorialDTO {
    private Integer id;
    private Integer producto_id;
    private String accion;
    private String fecha_accion;
}