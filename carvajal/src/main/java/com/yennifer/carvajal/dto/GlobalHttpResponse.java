package com.yennifer.carvajal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GlobalHttpResponse<T> {
    private Boolean exito;
    private String mensaje;
    private T datos;

    
    }
