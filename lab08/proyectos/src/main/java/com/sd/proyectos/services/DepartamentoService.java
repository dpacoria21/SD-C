package com.sd.proyectos.services;

import com.sd.proyectos.entities.Departamento;
import com.sd.proyectos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Iterable<Departamento> getDepartamentos(){
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> getDepartamento(Long id){
        return departamentoRepository.findById(id);
    }
    public Departamento addDepartamento(Departamento departamento){
        return departamentoRepository.save(departamento);
    }

    public Departamento updateDepartamento(Departamento departamento){
        return departamentoRepository.save(departamento);
    }

    public boolean deleteDepartamento(Long id){
        if(departamentoRepository.existsById(id)){
            departamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
