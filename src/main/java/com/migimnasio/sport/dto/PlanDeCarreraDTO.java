package com.migimnasio.sport.dto;

import com.migimnasio.sport.enums.PlanDeCarreraEstado;

import java.time.LocalDate;
import java.util.List;

public class PlanDeCarreraDTO {
    private Long idAlumno;
    private Long idInstructor;
    private List<Long> ejerciciosIds;
    private String metaAlumno;
    private int cantDiasXSemana;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String descripcion;
    private PlanDeCarreraEstado estado;

    public PlanDeCarreraDTO(Long idAlumno, Long idInstructor, List<Long> ejerciciosIds, String metaAlumno, int cantDiasXSemana, LocalDate fechaInicio, LocalDate fechaFin, String descripcion, PlanDeCarreraEstado estado) {
        this.idAlumno = idAlumno;
        this.idInstructor = idInstructor;
        this.ejerciciosIds = ejerciciosIds;
        this.metaAlumno = metaAlumno;
        this.cantDiasXSemana = cantDiasXSemana;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Long getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Long idInstructor) {
        this.idInstructor = idInstructor;
    }

    public List<Long> getEjerciciosIds() {
        return ejerciciosIds;
    }

    public void setEjerciciosIds(List<Long> ejerciciosIds) {
        this.ejerciciosIds = ejerciciosIds;
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
