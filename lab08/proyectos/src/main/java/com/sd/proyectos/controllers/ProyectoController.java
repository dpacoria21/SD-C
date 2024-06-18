package com.sd.proyectos.controllers;

import com.sd.proyectos.entities.Proyecto;
import com.sd.proyectos.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public Iterable<Proyecto> getProyectos() {
        return proyectoService.getProyectos();
    }

    @GetMapping("/{id}")
    public Optional<Proyecto> getProyecto(@PathVariable("id") Long id) {
        return proyectoService.getProyecto(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.addProyecto(proyecto);
    }

    @PutMapping("/{id}")
    public Proyecto actualizarProyecto(
            @PathVariable("id") Long id,
            @RequestBody Proyecto proyecto) {
        proyecto.setId(id);
        return proyectoService.updateProyecto(proyecto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarProyecto(@PathVariable("id") Long id) {
        proyectoService.deleteProyecto(id);
    }

    @GetMapping("/departamento/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Proyecto> getProyectosByDepartamentoId(@PathVariable("id") Long id) {
        return proyectoService.getProyectoByDepartamentoId(id);
    }
}
