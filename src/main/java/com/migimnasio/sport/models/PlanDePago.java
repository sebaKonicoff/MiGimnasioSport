package com.migimnasio.sport.models;

import com.migimnasio.sport.enums.PlanPagoEstado;
import com.migimnasio.sport.enums.TipoPlanPago;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "plan_de_pago")
public class PlanDePago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPlanPago;
    @ManyToOne
    @JoinColumn(name = "id_alumno", referencedColumnName = "idAlumno", unique = false)
    private Alumno alumno;
    @Enumerated(EnumType.STRING)
    private TipoPlanPago tipoPlanPago;
    @Enumerated(EnumType.STRING)
    private PlanPagoEstado planPagoEstado;
    private double montoTotal;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int nroCuotas;

    public PlanDePago(){
        this.planPagoEstado = PlanPagoEstado.EN_CURSO;
    }

    public PlanDePago(Long idPlanPago, Alumno alumno, TipoPlanPago tipoPlanPago, PlanPagoEstado planPagoEstado, double montoTotal, LocalDate fechaInicio, LocalDate fechaFin, int nroCuotas) {
        this.idPlanPago = idPlanPago;
        this.alumno = alumno;
        this.tipoPlanPago = tipoPlanPago;
        this.planPagoEstado = planPagoEstado;
        this.montoTotal = montoTotal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nroCuotas = nroCuotas;
    }

    public Long getIdPlanPago() {
        return idPlanPago;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public TipoPlanPago getTipoPlanPago() {
        return tipoPlanPago;
    }

    public void setTipoPlanPago(TipoPlanPago tipoPlanPago) {
        this.tipoPlanPago = tipoPlanPago;
    }

    public PlanPagoEstado getPlanPagoEstado() {
        return planPagoEstado;
    }

    public void setPlanPagoEstado(PlanPagoEstado planPagoEstado) {
        this.planPagoEstado = planPagoEstado;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getNroCuotas() {
        return nroCuotas;
    }

    public void setNroCuotas(int nroCuotas) {
        this.nroCuotas = nroCuotas;
    }
}
