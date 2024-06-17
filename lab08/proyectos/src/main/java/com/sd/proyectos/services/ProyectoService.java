package com.sd.proyectos.services;

import com.sd.proyectos.entities.Proyecto;
import com.sd.proyectos.repositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProyectoService {
    @Autowired
    private ProyectoRepository proyectoRepository;

    public Iterable<Proyecto> getProyectos(){
        return proyectoRepository.findAll();
    }

    public Optional<Proyecto> getProyecto(Long id){
        return proyectoRepository.findById(id);
    }

    public Proyecto addProyecto(Proyecto proyecto){
        return proyectoRepository.save(proyecto);
    }

    public Proyecto updateProyecto(Proyecto proyecto){
        return proyectoRepository.save(proyecto);
    }

    public boolean deleteProyecto(Long id){
        if(proyectoRepository.existsById(id)) {
            proyectoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Iterable<Proyecto> getProyectoByDepartamentoId(Long id){
        return proyectoRepository.findAllByDepartamentoId(id);
    }

}
