package com.sd.proyectos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proyecto {
    @Id
    private Long id;
    private String nombre;
    private Date fecInicio;
    private Date fecTermino;
    private Long departamentoId;
}
