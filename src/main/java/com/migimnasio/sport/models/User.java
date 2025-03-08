package com.migimnasio.sport.models;

import com.migimnasio.sport.enums.Rol;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Getter
public class User {

    @Setter
    @Id
    @Column(unique = true, nullable = false)
    private String user;
    @Column(nullable = false)
    private String password;
    @Setter
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Setter
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
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


}
