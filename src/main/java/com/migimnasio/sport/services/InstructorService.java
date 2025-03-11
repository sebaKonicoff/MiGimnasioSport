package com.migimnasio.sport.services;

import com.migimnasio.sport.data.InstructorRepository;
import com.migimnasio.sport.dto.InstructorDTO;
import com.migimnasio.sport.mappers.InstructorMapper;
import com.migimnasio.sport.models.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorService {

    @Autowired
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;


    public InstructorService(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }

    public InstructorDTO toDTO(Instructor instructor){
        return instructorMapper.toDTO(instructor);
    }

    public Instructor toEntity(InstructorDTO instructorDTO){
        return instructorMapper.toEntity(instructorDTO);
    }

    public InstructorDTO crearInstructor(InstructorDTO newInstructorDTO){
        Instructor instructor = instructorMapper.toEntity(newInstructorDTO);

        Instructor nuevoInstructor = instructorRepository.save(instructor);

        return toDTO(nuevoInstructor);
    }

    private Instructor getEntity(Long id) throws Exception {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontró Instructor"));
    }

    public List<InstructorDTO> getAllInstructor(){
        List<Instructor> instructor = instructorRepository.findAll();

        return instructor.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public InstructorDTO findById(Long id) throws Exception {
        Instructor instructor = getEntity(id);
        return toDTO(instructor);
    }
}
