package com.migimnasio.sport.dto.response;

import com.migimnasio.sport.dto.AlumnoDTO;
import com.migimnasio.sport.dto.InstructorDTO;
import com.migimnasio.sport.enums.PlanDeCarreraEstado;

import java.time.LocalDate;
import java.util.List;

public class PlanDeCarreraResponseDTO {
    private Long idPlanDeCarrera;
    private AlumnoDTO alumnoDTO;
    private InstructorDTO instructorDTO;
    private List<Long> ejerciciosId;
    private String metaAlumno;
    private int cantDiasXSemana;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String descripcion;
    private PlanDeCarreraEstado estado;

    public PlanDeCarreraResponseDTO(Long idPlanDeCarrera, AlumnoDTO alumnoDTO, InstructorDTO instructorDTO, List<Long> ejerciciosId, String metaAlumno,
                                    int cantDiasXSemana, LocalDate fechaInicio, LocalDate fechaFin, String descripcion, PlanDeCarreraEstado estado) {
        this.idPlanDeCarrera = idPlanDeCarrera;
        this.alumnoDTO = alumnoDTO;
        this.instructorDTO = instructorDTO;
        this.ejerciciosId = ejerciciosId;
        this.metaAlumno = metaAlumno;
        this.cantDiasXSemana = cantDiasXSemana;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Long getIdPlanDeCarrera() {
        return idPlanDeCarrera;
    }

    public void setIdPlanDeCarrera(Long idPlanDeCarrera) {
        this.idPlanDeCarrera = idPlanDeCarrera;
    }

    public AlumnoDTO getAlumnoDTO() {
        return alumnoDTO;
    }

    public void setAlumnoDTO(AlumnoDTO alumnoDTO) {
        this.alumnoDTO = alumnoDTO;
    }

    public InstructorDTO getInstructorDTO() {
        return instructorDTO;
    }

    public void setInstructorDTO(InstructorDTO instructorDTO) {
        this.instructorDTO = instructorDTO;
    }

    public List<Long> getEjerciciosId() {
        return ejerciciosId;
    }

    public void setEjerciciosId(List<Long> ejerciciosId) {
        this.ejerciciosId = ejerciciosId;
    }

    public String getMetaAlumno() {
        return metaAlumno;
    }

    public void setMetaAlumno(String metaAlumno) {
        this.metaAlumno = metaAlumno;
    }

    public int getCantDiasXSemana() {
        return cantDiasXSemana;
    }

    public void setCantDiasXSemana(int cantDiasXSemana) {
        this.cantDiasXSemana = cantDiasXSemana;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PlanDeCarreraEstado getEstado() {
        return estado;
    }

    public void setEstado(PlanDeCarreraEstado estado) {
        this.estado = estado;
    }
}
