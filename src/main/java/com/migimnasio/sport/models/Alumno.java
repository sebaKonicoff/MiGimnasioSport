package com.migimnasio.sport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.migimnasio.sport.enums.AlumnoEstado;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAlumno;
    private String nombre;
    private String apellido;
    private String correo;
    private String nroTelefono;

    @Enumerated(EnumType.STRING)
    private AlumnoEstado estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_name", referencedColumnName = "user")
    @JsonManagedReference
    private User user;

    public Alumno(){
        this.estado = AlumnoEstado.HABILITADO;
    }

    public Alumno(long idAlumno, String nombre, String apellido, String correo, String nroTelefono) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.nroTelefono = nroTelefono;
        this.estado = AlumnoEstado.HABILITADO;
    }

    public User getUser() {
        return user;
    }

    public long getIdAlumno() {
        return idAlumno;
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

    public void setUser(User user) {
        this.user = user;
    }
}
