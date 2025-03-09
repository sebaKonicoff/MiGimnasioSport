package com.migimnasio.sport.services;

import com.migimnasio.sport.data.AlumnoRepository;
import com.migimnasio.sport.dto.AlumnoDTO;
import com.migimnasio.sport.mappers.AlumnoMapper;
import com.migimnasio.sport.models.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    private final AlumnoRepository alumnoRepository;

    private final AlumnoMapper alumnoMapper;

    public AlumnoService(AlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper) {
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
    }

    public Alumno crearAlumno(AlumnoDTO newAlumnoDTO){
        Alumno alumno = alumnoMapper.toEntity(newAlumnoDTO);
        return alumnoRepository.save(alumno);
    }
}
