package com.migimnasio.sport.models;

import com.migimnasio.sport.enums.PlanDeCarreraEstado;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table(name = "plan_de_carrera")
public class PlanDeCarrera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPlanCarrera;

    @ManyToOne
    @JoinColumn(name = "id_alumno", referencedColumnName = "idAlumno", unique = false)
    private Alumno alumno;
    @ManyToOne
    @JoinColumn(name = "id_intructor", referencedColumnName = "idInstructor", unique = false)
    private Instructor instructor;
    @OneToMany
    @Column(nullable = false)
    private List<Ejercicio> ejercicios;
    private String metaAlumno;
    private int cantDiasXSemana;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private PlanDeCarreraEstado estado;

    public PlanDeCarrera (){
        this.estado = PlanDeCarreraEstado.CREADA;
    }

    public PlanDeCarrera(Long idPlanCarrera, Alumno alumno, Instructor instructor, List<Ejercicio> ejercicios, String metaAlumno, int cantDiasXSemana, LocalDate fechaInicio, LocalDate fechaFin, String descripcion) {
        this.idPlanCarrera = idPlanCarrera;
        this.alumno = alumno;
        this.instructor = instructor;
        this.ejercicios = ejercicios;
        this.metaAlumno = metaAlumno;
        this.cantDiasXSemana = cantDiasXSemana;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.estado = PlanDeCarreraEstado.CREADA;
    }

    public String calcularDuracion(){
        Period period = Period.between(fechaInicio, fechaFin);
        return period.getYears() + " años, " +
                period.getMonths() + " meses, " +
                period.getDays() + " días.";
    }

    public Long getIdPlanCarrera() {
        return idPlanCarrera;
    }


    public Alumno getAlumno() {
        return alumno;
    }


    public Instructor getInstructor() {
        return instructor;
    }


    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
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

    public void setIdPlanCarrera(Long idPlanCarrera) {
        this.idPlanCarrera = idPlanCarrera;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
