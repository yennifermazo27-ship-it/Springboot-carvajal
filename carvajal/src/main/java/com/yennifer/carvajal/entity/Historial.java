package com.yennifer.carvajal.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "historial")
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer producto_id;
    private String accion;
    private LocalDateTime fecha_accion;
}