package com.migimnasio.sport.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "maquina")
public class Maquina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long idMaquina;
    private String nombre;
    private String muscoObjetivo;
    private String descripcion;
    private String estado;

    @ManyToMany
    private List<Ejercicio> ejercicios;

    public Maquina(){

    }

    public Maquina(long idMaquina, String nombre, String muscoObjetivo, String descripcion, String estado, List<Ejercicio> ejercicios) {
        this.idMaquina = idMaquina;
        this.nombre = nombre;
        this.muscoObjetivo = muscoObjetivo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.ejercicios = ejercicios;
    }

    public long getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(long idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMuscoObjetivo() {
        return muscoObjetivo;
    }

    public void setMuscoObjetivo(String muscoObjetivo) {
        this.muscoObjetivo = muscoObjetivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }
}
