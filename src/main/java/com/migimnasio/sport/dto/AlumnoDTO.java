package com.migimnasio.sport.dto;

import com.migimnasio.sport.enums.AlumnoEstado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoDTO {

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
}
