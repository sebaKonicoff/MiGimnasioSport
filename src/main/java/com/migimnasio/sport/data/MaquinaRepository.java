package com.migimnasio.sport.data;

import com.migimnasio.sport.models.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "maquinas")
public interface MaquinaRepository extends JpaRepository<Maquina, Long> {
}
