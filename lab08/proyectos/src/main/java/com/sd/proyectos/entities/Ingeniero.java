package com.sd.proyectos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingeniero {
    @Id
    private Long id;
    private String especialidad;
    private String cargo;
    private Long proyectoId;
}
