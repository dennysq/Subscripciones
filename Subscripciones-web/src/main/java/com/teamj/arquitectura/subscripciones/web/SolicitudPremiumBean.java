/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.subscripciones.web;

import com.teamj.arquitectura.subscripcion.model.SolicitudPremium;
import com.teamj.arquitectura.subscripcion.model.Usuario;
import com.teamj.arquitectura.subscripcion.services.SolicitudPremiumServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author RICARDO
 */
@ManagedBean
@ViewScoped
public class SolicitudPremiumBean implements Serializable {

    private Usuario usuarioSeleccionado;

    @EJB
    private SolicitudPremiumServicio solicitudPremiumServicio;

    private List<SolicitudPremium> solicitudesPremiumLista;

    /**
     * Creates a new instance of SolicitudPremiumBean
     */
    public SolicitudPremiumBean() {
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public List<SolicitudPremium> getSolicitudesPremiumLista() {
        return solicitudesPremiumLista;
    }

    public void setSolicitudesPremiumLista(List<SolicitudPremium> solicitudesPremiumLista) {
        this.solicitudesPremiumLista = solicitudesPremiumLista;
    }

    @PostConstruct
    public void init() {
        this.solicitudesPremiumLista = solicitudPremiumServicio.obtenerSolicitudesPremium();
    }

    public void aceptarSolicitud(SolicitudPremium solicitud) {
        solicitud.setEstado("V");
        solicitudPremiumServicio.editar(solicitud);
    }

    public void rechazarSolicitud(SolicitudPremium solicitud) {
        solicitud.setEstado("N");
        solicitudPremiumServicio.editar(solicitud);
    }

    public void mostrarCertificados(SolicitudPremium solicitud) {
        usuarioSeleccionado = solicitud.getUsuario();
    }

    public boolean isEmptyString(String solicitud) {
        return solicitud == null || solicitud.isEmpty();
     }

    public boolean verificaCertificados(SolicitudPremium solicitud) {
        return (isEmptyString(solicitud.getUsuario().getCertVIH()) || isEmptyString(solicitud.getUsuario().getCertCLA())
                || isEmptyString(solicitud.getUsuario().getCertGON()) || isEmptyString(solicitud.getUsuario().getCertHER())
                || isEmptyString(solicitud.getUsuario().getCertSIF()) || isEmptyString(solicitud.getUsuario().getCertTRI()));
    }
}
