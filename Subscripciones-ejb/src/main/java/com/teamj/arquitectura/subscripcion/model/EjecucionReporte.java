/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.subscripcion.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "EJECUCION_REPORTE")
public class EjecucionReporte implements Serializable{
    @EmbeddedId
    EjecucionReportePK ejecucionReportePK;
    
    @ManyToOne
    @JoinColumn(name = "ID_ADMINISTRADOR", nullable = false,insertable = false,updatable = false)
    private Administrador administrador;

    @ManyToOne
    @JoinColumn(name = "ID_REPORTE", nullable = false,insertable = false,updatable = false)
    private Reporte reporte;
    
    @Column(name = "FECHA_EJECUCION")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaEjecucion;

    public EjecucionReporte() {
    }

    public EjecucionReportePK getEjecucionReportePK() {
        return ejecucionReportePK;
    }

    public void setEjecucionReportePK(EjecucionReportePK ejecucionReportePK) {
        this.ejecucionReportePK = ejecucionReportePK;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public Date getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.ejecucionReportePK);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EjecucionReporte other = (EjecucionReporte) obj;
        if (!Objects.equals(this.ejecucionReportePK, other.ejecucionReportePK)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EjecucionReporte{" + "ejecucionReportePK=" + ejecucionReportePK + ", fechaEjecucion=" + fechaEjecucion + '}';
    }
}
