package com.migimnasio.sport.services;

import com.migimnasio.sport.dao.IAlumnoDao;
import com.migimnasio.sport.data.AlumnoRepository;
import com.migimnasio.sport.dto.AlumnoDTO;
import com.migimnasio.sport.enums.AlumnoEstado;
import com.migimnasio.sport.exception.ResourceNotFoundException;
import com.migimnasio.sport.mappers.AlumnoMapper;
import com.migimnasio.sport.models.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoService {

    @Autowired
    private final AlumnoRepository alumnoRepository;
    private final IAlumnoDao iAlumnoDao;
    private final AlumnoMapper alumnoMapper;

    public AlumnoService(AlumnoRepository alumnoRepository, IAlumnoDao iAlumnoDao, AlumnoMapper alumnoMapper) {
        this.alumnoRepository = alumnoRepository;
        this.iAlumnoDao = iAlumnoDao;
        this.alumnoMapper = alumnoMapper;
    }

    public AlumnoDTO toDTO(Alumno alumno){
        return alumnoMapper.toDTO(alumno);
    }

    public Alumno toEntity(AlumnoDTO alumnoDTO){
        return alumnoMapper.toEntity(alumnoDTO);
    }

    public AlumnoDTO crearAlumno(AlumnoDTO newAlumnoDTO){
        Alumno alumno = alumnoMapper.toEntity(newAlumnoDTO);

        Alumno nuevoAlumno = alumnoRepository.save(alumno);
        return toDTO(nuevoAlumno);
    }

    public Alumno getEntityById(Long id)  {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró Alumno con id: " + id));
    }

    public List<AlumnoDTO> getAll(){
        List<Alumno> alumnos = alumnoRepository.findAll();

        return alumnos.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public AlumnoDTO findById(Long id) {
        Alumno alumno = getEntityById(id);
        return toDTO(alumno);
    }

    public AlumnoDTO findByUserName(String userName){
        Alumno alumno = iAlumnoDao.findByUserName(userName);
        return toDTO(alumno);
    }

    public AlumnoDTO actualizarEstado(long id, AlumnoEstado nuevoEstado){
        Alumno alumno = getEntityById(id);
        alumno.setEstado(nuevoEstado);
        alumnoRepository.save(alumno);
        return toDTO(alumno);
    }

    public List<AlumnoDTO> buscarAlumnosPorEstado(AlumnoEstado estadoAlumno){
        List<Alumno> alumnos = iAlumnoDao.alumnoXEstado(estadoAlumno);

        return alumnos.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public boolean isHabilitado(String userName){
        AlumnoDTO alumnoDTO = findByUserName(userName);
        return alumnoDTO.getEstado() == AlumnoEstado.HABILITADO;
    }
}
