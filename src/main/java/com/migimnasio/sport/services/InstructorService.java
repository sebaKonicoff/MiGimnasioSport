package com.migimnasio.sport.services;

import com.migimnasio.sport.data.InstructorRepository;
import com.migimnasio.sport.dto.InstructorDTO;
import com.migimnasio.sport.exception.ResourceNotFoundException;
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

    public Instructor getEntityById(Long id){
        return instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró Instructor"));
    }

    public List<InstructorDTO> getAllInstructor(){
        List<Instructor> instructor = instructorRepository.findAll();

        return instructor.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public InstructorDTO findById(Long id){
        Instructor instructor = getEntityById(id);
        return toDTO(instructor);
    }
}
