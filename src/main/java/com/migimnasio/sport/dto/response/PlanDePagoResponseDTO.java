package com.migimnasio.sport.dto.response;

import com.migimnasio.sport.dto.AlumnoDTO;
import com.migimnasio.sport.enums.PlanPagoEstado;
import com.migimnasio.sport.enums.TipoPlanPago;

import java.time.LocalDate;

public class PlanDePagoResponseDTO {
    private Long idPlanDePago;
    private AlumnoDTO alumnoDTO;
    private TipoPlanPago tipoPlanPago;
    private PlanPagoEstado planPagoEstado;
    private double montoTotal;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int nroCuotas;

    public PlanDePagoResponseDTO(Long idPlanDePago, AlumnoDTO alumnoDTO, TipoPlanPago tipoPlanPago, PlanPagoEstado planPagoEstado, double montoTotal, LocalDate fechaInicio, LocalDate fechaFin, int nroCuotas) {
        this.idPlanDePago = idPlanDePago;
        this.alumnoDTO = alumnoDTO;
        this.tipoPlanPago = tipoPlanPago;
        this.planPagoEstado = planPagoEstado;
        this.montoTotal = montoTotal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nroCuotas = nroCuotas;
    }

    public Long getIdPlanDePago() {
        return idPlanDePago;
    }

    public AlumnoDTO getAlumnoDTO() {
        return alumnoDTO;
    }

    public TipoPlanPago getTipoPlanPago() {
        return tipoPlanPago;
    }

    public PlanPagoEstado getPlanPagoEstado() {
        return planPagoEstado;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public int getNroCuotas() {
        return nroCuotas;
    }
}
