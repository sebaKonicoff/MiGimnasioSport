package com.migimnasio.sport.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.migimnasio.sport.enums.Rol;

public class UserDTO {

    private String user;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //con esta anotacion, solo pedira password para post o put
    private String password;
    private Rol rol;

    public UserDTO(){

    }

    public UserDTO(String user, Rol rol, String newPassord) {
        this.user = user;
        this.rol = rol;
        this.password = newPassord;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
