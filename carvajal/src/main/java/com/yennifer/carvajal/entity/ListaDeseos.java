package com.yennifer.carvajal.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "lista_deseos")
public class ListaDeseos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer producto_id;
    private LocalDateTime fecha_agregado;
}