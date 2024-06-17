package com.sd.proyectos.repositories;

import com.sd.proyectos.entities.Proyecto;
import org.springframework.data.repository.CrudRepository;

public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {
    public Iterable<Proyecto> findAllByDepartamentoId(Long id);
}
