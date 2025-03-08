package com.migimnasio.sport.models;

import com.fasterxml.jackson.annotation.*;
import com.migimnasio.sport.enums.MaquinaEstado;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "maquina")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMaquina")
public class Maquina {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMaquina;
    private String nombre;
    private String muscoObjetivo;
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private MaquinaEstado estado;

    @ManyToMany(mappedBy = "maquinas", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Ejercicio> ejercicios;

    public Maquina(){

    }

    public Maquina(long idMaquina, String nombre, String muscoObjetivo, String descripcion, MaquinaEstado estado) {
        this.idMaquina = idMaquina;
        this.nombre = nombre;
        this.muscoObjetivo = muscoObjetivo;
        this.descripcion = descripcion;
        this.estado = estado;
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

    public MaquinaEstado getEstado() {
        return estado;
    }

    public void setEstado(MaquinaEstado estado) {
        this.estado = estado;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public void addEjercicio(Ejercicio ejercicio){
        ejercicios.add(ejercicio);
    }
}
