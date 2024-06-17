package com.sd.proyectos.services;

import com.sd.proyectos.entities.Ingeniero;
import com.sd.proyectos.entities.Proyecto;
import com.sd.proyectos.repositories.IngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngenieroService {
   @Autowired
   private IngenieroRepository ingenieroRepository;

   public Iterable<Ingeniero> getIngenieros() {
       return  ingenieroRepository.findAll();
   }

   public Ingeniero addIngeniero(Ingeniero ingeniero){
       return ingenieroRepository.save(ingeniero);
   }

   public Optional<Ingeniero> getIngeniero(Long id) {
       return ingenieroRepository.findById(id);
   }

   public Ingeniero updateIngeniero(Ingeniero ingeniero) {
       return ingenieroRepository.save(ingeniero);
   }

   public boolean deleteIngeniero(Long id) {
       if(ingenieroRepository.existsById(id)) {
           ingenieroRepository.deleteById(id);
           return true;
       }
       return false;
   }

    public Iterable<Ingeniero> getIngenieroByProyectoId(Long id){
        return ingenieroRepository.findAllByProyectoId(id);
    }

}