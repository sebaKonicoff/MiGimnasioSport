package com.migimnasio.sport.dto;

public class EjercicioMaquinaDTO {
    private long idMaquina;
    private long idEjercicio;

    public EjercicioMaquinaDTO(){

    }

    public EjercicioMaquinaDTO(long idMaquina, long idEjercicio) {
        this.idMaquina = idMaquina;
        this.idEjercicio = idEjercicio;
    }

    public long getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(long idMaquina) {
        this.idMaquina = idMaquina;
    }

    public long getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(long idEjercicio) {
        this.idEjercicio = idEjercicio;
    }
}
