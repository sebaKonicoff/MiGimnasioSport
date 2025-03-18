package com.migimnasio.sport.models.pk;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlanCarreraEjercicioPK implements Serializable {

    private Long idPlanCarrera;
    private Long idEjercicio;

    public PlanCarreraEjercicioPK(){

    }

    public PlanCarreraEjercicioPK(Long idPlanCarrera, Long idEjercicio) {
        this.idPlanCarrera = idPlanCarrera;
        this.idEjercicio = idEjercicio;
    }

    public Long getIdPlanCarrera() {
        return idPlanCarrera;
    }

    public void setIdPlanCarrera(Long idPlanCarrera) {
        this.idPlanCarrera = idPlanCarrera;
    }

    public Long getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(Long idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanCarreraEjercicioPK that = (PlanCarreraEjercicioPK) o;
        return Objects.equals(idPlanCarrera, that.idPlanCarrera) &&
                Objects.equals(idEjercicio, that.idEjercicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlanCarrera, idEjercicio);
    }
}
