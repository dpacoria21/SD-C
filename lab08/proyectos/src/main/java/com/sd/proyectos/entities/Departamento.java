package com.sd.proyectos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Departamento {
    @Id
    private Long id;
    private String nombre;
    private String telefono;
    private String fax;

}
