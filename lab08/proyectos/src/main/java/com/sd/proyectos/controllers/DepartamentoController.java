package com.sd.proyectos.controllers;

import com.sd.proyectos.entities.Departamento;
import com.sd.proyectos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("departamento")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public Iterable<Departamento> getDepartamentos() {
        return departamentoService.getDepartamentos();
    }

    @GetMapping("/{id}")
    public Optional<Departamento> getDepartamento(@PathVariable("id") Long id) {
        return departamentoService.getDepartamento(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento addDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.addDepartamento(departamento);
    }

    @PutMapping("/{id}")
    public Departamento updateDepartamento(
            @PathVariable("id") Long id,
            @RequestBody Departamento departamento) {
        departamento.setId(id); // Aseguramos que el ID sea el correcto
        return departamentoService.updateDepartamento(departamento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartamento(@PathVariable("id") Long id) {
        departamentoService.deleteDepartamento(id);
    }
}
