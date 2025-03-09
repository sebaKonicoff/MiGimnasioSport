package com.migimnasio.sport.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.migimnasio.sport.enums.AlumnoEstado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Getter
@Setter
@Table(name = "alumno")
public class Alumno {

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
    @JoinColumn(name = "usuario_id", referencedColumnName = "user")
    private User usuario;

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

}
