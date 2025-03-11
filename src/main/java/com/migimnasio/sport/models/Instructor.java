package com.migimnasio.sport.models;

import java.time.LocalDate;

import com.migimnasio.sport.enums.AlumnoEstado;
import com.migimnasio.sport.enums.InstructorEstado;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idInstructor;
    private String nombre;
    private String apellido;
    private String correo;
    private LocalDate fechaIngreso;
    @Enumerated(EnumType.STRING)
    private InstructorEstado estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_name", referencedColumnName = "user")
    private User user;

    public Instructor() {
        this.estado = InstructorEstado.HABILITADO;
    }

    public Instructor(long idInstructor, String nombre, String apellido, String correo, LocalDate fechaIngreso, User user) {
        this.idInstructor = idInstructor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaIngreso = fechaIngreso;
        this.estado = InstructorEstado.HABILITADO;
        this.user = user;
    }

    public long getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(long idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public InstructorEstado getEstado() {
        return estado;
    }

    public void setEstado(InstructorEstado estado) {
        this.estado = estado;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
