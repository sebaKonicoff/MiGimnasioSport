package com.migimnasio.sport.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.migimnasio.sport.enums.InstructorEstado;
import com.migimnasio.sport.models.Instructor;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


public class InstructorDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long idInstructor;
    private String nombre;
    private String apellido;
    private String correo;
    private LocalDate fechaIngreso;
    private InstructorEstado estado;

    private UserDTO userDTO;

    public InstructorDTO(){

    }

    public InstructorDTO(long idInstructor, String nombre, String apellido, String correo, LocalDate fechaIngreso, InstructorEstado estado, UserDTO userDTO) {
        this.idInstructor = idInstructor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.userDTO = userDTO;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
