package com.migimnasio.sport.services;

import com.migimnasio.sport.data.EjercicioRepository;
import com.migimnasio.sport.models.Ejercicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
