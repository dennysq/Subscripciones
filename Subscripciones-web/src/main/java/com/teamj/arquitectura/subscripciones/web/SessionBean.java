/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.subscripciones.web;

import com.teamj.arquitectura.subscripcion.model.Administrador;
import com.teamj.arquitectura.subscripcion.model.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dennys
 */
@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {

    public static final String HOME_PAGE_REDIRECT = "/user/home.xhtml?faces-redirect=true";
    public static final String LOGOUT_PAGE_REDIRECT = "/login.xhtml?faces-redirect=true";

    private Administrador admin;

    public Administrador getAdmin() {
        return admin;
    }

    public String login(Administrador a) {

        this.admin = a;

        return HOME_PAGE_REDIRECT;

    }

    public String logout() {
        // invalidate the session
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return LOGOUT_PAGE_REDIRECT;
    }

    public boolean isLoggedIn() {
        return admin != null;
    }

    public String isLoggedInForwardHome() {
        if (isLoggedIn()) {
            return HOME_PAGE_REDIRECT;
        }
        return null;
    }
/**
 * 
 * @return si es el usuario administrador del sistema
 */
//    public boolean isAdmin() {
//        if (user != null) {
//            return user.getNombre().equals("admin");
//        }
//        return false;
//    }

}
