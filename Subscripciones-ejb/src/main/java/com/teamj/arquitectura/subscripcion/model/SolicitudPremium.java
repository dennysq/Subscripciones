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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "SOLICITUD_PREMIUM")
public class SolicitudPremium implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//MYSQL&&SQL
    @Column(name = "ID_SOLICITUD_PREMIUM")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "ID_ADMINISTRADOR")
    private SolicitudPremium solicitudPremium;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
    
    @Column(name = "FECHA_SOLICITUD")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaSolicitud;
    
    @Column(name = "ESTADO")
    private String estado;
    
    @Column(name = "FECHA_RESULTADO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date fechaResultado;

    public SolicitudPremium() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SolicitudPremium getSolicitudPremium() {
        return solicitudPremium;
    }

    public void setSolicitudPremium(SolicitudPremium solicitudPremium) {
        this.solicitudPremium = solicitudPremium;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaResultado() {
        return fechaResultado;
    }

    public void setFechaResultado(Date fechaResultado) {
        this.fechaResultado = fechaResultado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final SolicitudPremium other = (SolicitudPremium) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SolicitudPremium{" + "id=" + id + ", solicitudPremium=" + solicitudPremium + ", usuario=" + usuario + ", fechaSolicitud=" + fechaSolicitud + ", estado=" + estado + ", fechaResultado=" + fechaResultado + '}';
    }
}
