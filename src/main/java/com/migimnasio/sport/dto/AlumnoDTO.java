package com.migimnasio.sport.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.migimnasio.sport.enums.AlumnoEstado;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class AlumnoDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long idAlumno;
    private String nombre;
    private String apellido;
    private String correo;
    private String nroTelefono;
    private AlumnoEstado estado;

    private UserDTO userDTO;

    public AlumnoDTO(){

    }

    public AlumnoDTO(long idAlumno, String nombre, String apellido, String correo, String nroTelefono, AlumnoEstado estado, UserDTO userDTO) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.nroTelefono = nroTelefono;
        this.estado = estado;
        this.userDTO = userDTO;
    }

    public UserDTO getUserDTO() { // 💡 Agrega este getter si falta
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) { // 💡 Agrega este setter si falta
        this.userDTO = userDTO;
    }

    public long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(long idAlumno) {
        this.idAlumno = idAlumno;
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

    public String getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(String nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public AlumnoEstado getEstado() {
        return estado;
    }

    public void setEstado(AlumnoEstado estado) {
        this.estado = estado;
    }
}
