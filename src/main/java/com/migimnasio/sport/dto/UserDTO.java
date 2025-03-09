package com.migimnasio.sport.dto;

import com.migimnasio.sport.enums.Rol;

public class UserDTO {

    private String user;
    private Rol rol;

    public UserDTO(){

    }

    public UserDTO(String user, Rol rol) {
        this.user = user;
        this.rol = rol;
    }
}
