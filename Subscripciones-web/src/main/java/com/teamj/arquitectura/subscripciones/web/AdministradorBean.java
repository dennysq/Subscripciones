/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.subscripciones.web;

import com.teamj.arquitectura.subscripcion.dao.AdministradorDAO;
import com.teamj.arquitectura.subscripcion.model.Administrador;
import com.teamj.arquitectura.subscripcion.services.AdministradorServicio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author RICARDO
 */
@ManagedBean
@ViewScoped
public class AdministradorBean implements Serializable {

    @EJB
    private AdministradorServicio administradorServicio;

    
    private List<Administrador> administradoresLista;

    /**
     * Creates a new instance of AdministradorBean
     */
    public AdministradorBean() {
    }

    public List<Administrador> getAdministradoresLista() {
        return administradoresLista;
    }

    public void setAdministradoresLista(List<Administrador> administradoresLista) {
        this.administradoresLista = administradoresLista;
    }
    
    @PostConstruct
    public void init(){
        this.administradoresLista=administradorServicio.retrieveAdministrador();
    }
    

}
