package com.sd.proyectos.repositories;

import com.sd.proyectos.entities.Ingeniero;
import org.springframework.data.repository.CrudRepository;

public interface IngenieroRepository extends CrudRepository<Ingeniero, Long> {
    public Iterable<Ingeniero> findAllByProyectoId(Long id);
}
