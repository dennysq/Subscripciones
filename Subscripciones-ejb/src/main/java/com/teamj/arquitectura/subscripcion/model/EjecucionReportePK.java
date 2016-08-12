/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.subscripcion.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Klever
 */
@Embeddable
public class EjecucionReportePK implements Serializable{
    @Column(name = "ID_ADMINISTRADOR")
    private Integer idAdministrador;
     
    @Column(name = "ID_REPORTE")
    private Integer idReporte;

    public EjecucionReportePK() {
    }

    public EjecucionReportePK(Integer idAdministrador, Integer idReporte) {
        this.idAdministrador = idAdministrador;
        this.idReporte = idReporte;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.idAdministrador);
        hash = 71 * hash + Objects.hashCode(this.idReporte);
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
        final EjecucionReportePK other = (EjecucionReportePK) obj;
        if (!Objects.equals(this.idAdministrador, other.idAdministrador)) {
            return false;
        }
        if (!Objects.equals(this.idReporte, other.idReporte)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EjecucionReportePK{" + "idAdministrador=" + idAdministrador + ", idReporte=" + idReporte + '}';
    }
}
