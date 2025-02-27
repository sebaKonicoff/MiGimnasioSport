package com.migimnasio.sport.data;

import com.migimnasio.sport.models.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "ejercicios")
public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {
}
