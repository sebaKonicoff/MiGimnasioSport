package com.migimnasio.sport.services;

import com.migimnasio.sport.data.EjercicioRepository;
import com.migimnasio.sport.models.Ejercicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EjercicioService {

    @Autowired
    private final EjercicioRepository ejercicioRepository;

    public EjercicioService(EjercicioRepository ejercicioRepository) {
        this.ejercicioRepository = ejercicioRepository;
    }

    public List<Ejercicio> getAllEjercicios(){
        return ejercicioRepository.findAll();
    }

    public Optional<Ejercicio> getById(Long id){
        return ejercicioRepository.findById(id);
    }

    public List<Ejercicio> getEjerciciosById(List<Long> ejerciciosIds){
        return ejercicioRepository.findAllById(ejerciciosIds);
    }

    public Ejercicio crearEjercicio(Ejercicio ejercicio){
        try {
            return ejercicioRepository.save(ejercicio);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
