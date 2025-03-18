package com.migimnasio.sport.models;

import com.migimnasio.sport.models.pk.PlanCarreraEjercicioPK;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plancarreraxejercicio")
public class PlanCarreraEjercicio {

    @Id
    private PlanCarreraEjercicioPK id;

    public PlanCarreraEjercicio(){}

    public PlanCarreraEjercicio(PlanCarreraEjercicioPK id) {
        this.id = id;
    }

    public PlanCarreraEjercicioPK getId() {
        return id;
    }

}
