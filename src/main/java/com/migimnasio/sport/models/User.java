package com.migimnasio.sport.models;

import com.migimnasio.sport.enums.Rol;
import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {

    @Id
    @Column(unique = true, nullable = false)
    private String user;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Alumno alumno;

    public User(){

    }

    public User(String user, Rol rol, String rawPassword) {
        this.user = user;
        this.rol = rol;
        this.setPassword(rawPassword);
    }

    public void setPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password); //realiza el hash de la contraseña
    }

    public boolean checkPassword(String rawPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(rawPassword, this.password);
    }


    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }
}
