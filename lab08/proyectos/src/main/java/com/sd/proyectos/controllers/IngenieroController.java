package com.sd.proyectos.controllers;

import com.sd.proyectos.entities.Ingeniero;
import com.sd.proyectos.entities.Proyecto;
import com.sd.proyectos.services.IngenieroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ingeniero")
public class IngenieroController {
    @Autowired
    private IngenieroService ingenieroService;

    @GetMapping
    public ResponseEntity<Iterable<Ingeniero>> getIngenieros() {
        Iterable<Ingeniero> ingenieros = ingenieroService.getIngenieros();
        return ResponseEntity.ok(ingenieros);
    }

    @PostMapping
    public ResponseEntity<Ingeniero> addIngeniero(@RequestBody Ingeniero ingeniero) {
        Ingeniero nuevoIngeniero = ingenieroService.addIngeniero(ingeniero);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoIngeniero);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingeniero> getIngeniero(@PathVariable("id") Long id) {
        Optional<Ingeniero> ingeniero = ingenieroService.getIngeniero(id);
        return ingeniero.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingeniero> updateIngeniero(
            @PathVariable("id") Long id,
            @RequestBody Ingeniero ingeniero) {
        ingeniero.setId(id);
        Ingeniero updatedIngeniero = ingenieroService.updateIngeniero(ingeniero);
        return ResponseEntity.ok(updatedIngeniero);
    }

    // Endpoint para eliminar un ingeniero por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngeniero(@PathVariable("id") Long id) {
        boolean deleted = ingenieroService.deleteIngeniero(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/proyecto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Ingeniero> getIngenieroByProyectoId(@PathVariable("id") Long id) {
        return ingenieroService.getIngenieroByProyectoId(id);
    }
}
