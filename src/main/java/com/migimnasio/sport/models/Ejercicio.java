package com.migimnasio.sport.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ejercicio")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEjercicio")
public class Ejercicio {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEjercicio;
    private String nombre;
    private String descripcion;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ejercicio_maquina", joinColumns = {@JoinColumn(name = "idEjercicio")},
                inverseJoinColumns = {@JoinColumn(name = "idMaquina")})
    private List<Maquina> maquinas = new ArrayList<>();

    public Ejercicio(){

    }

    public Ejercicio(long idEjercicio, String nombre, String descripcion) {
        this.idEjercicio = idEjercicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public long getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(long idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(List<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public void addMaquina(Maquina maquina){
        maquinas.add(maquina);
    }
}
