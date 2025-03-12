package com.migimnasio.sport.dto;

import com.migimnasio.sport.enums.PlanPagoEstado;
import com.migimnasio.sport.enums.TipoPlanPago;

import java.time.LocalDate;

public class PlanDePagoDTO {
    private Long idAlumno;
    private TipoPlanPago tipoPlanPago;
    private PlanPagoEstado planPagoEstado;
    private double montoTotal;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int nroCuotas;

    public PlanDePagoDTO(Long idAlumno, TipoPlanPago tipoPlanPago, PlanPagoEstado planPagoEstado, double montoTotal, LocalDate fechaInicio, LocalDate fechaFin, int nroCuotas) {
        this.idAlumno = idAlumno;
        this.tipoPlanPago = tipoPlanPago;
        this.planPagoEstado = planPagoEstado;
        this.montoTotal = montoTotal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nroCuotas = nroCuotas;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
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
