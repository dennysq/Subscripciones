/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.subscripcion.services;

import com.teamj.arquitectura.subscripcion.dao.AdministradorDAO;
import com.teamj.arquitectura.subscripcion.dao.SolicitudPremiumDAO;
import com.teamj.arquitectura.subscripcion.dao.UsuarioDAO;
import com.teamj.arquitectura.subscripcion.model.Administrador;
import com.teamj.arquitectura.subscripcion.model.SolicitudPremium;
import com.teamj.arquitectura.subscripcion.model.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.validation.ValidationException;

/**
 *
 * @author Klever
 */
@Stateless
@LocalBean
public class SolicitudPremiumServicio {
    @EJB
    private SolicitudPremiumDAO solicitudPremiumDAO;
    @EJB
    private AdministradorDAO administradorDAO;
    @EJB
    private UsuarioDAO usuarioDAO;
    
    public SolicitudPremium obtenerPorId(Integer id) {
        return this.solicitudPremiumDAO.findById(id, false);
    }
    
    public List<SolicitudPremium> retrieveSPrem() {
        return this.solicitudPremiumDAO.findAll();
    }
    
    public boolean registrarSPrem(SolicitudPremium sp) throws ValidationException {
        boolean flag = false;
        SolicitudPremium temp = new SolicitudPremium();
        Administrador tempAdmi = new Administrador();
        Usuario tempUsu = new Usuario();
        
        tempAdmi.setId(sp.getAdministrador().getId());
        tempUsu.setId(sp.getUsuario().getId());
        
        List<Administrador> tempListA = this.administradorDAO.find(tempAdmi);
        List<Usuario> tempListU = this.usuarioDAO.find(tempUsu);

        if (tempListA != null && tempListA.size() == 1 && tempListU != null && tempListU.size() == 1){
        try {
            temp.setAdministrador(sp.getAdministrador());
            temp.setUsuario(sp.getUsuario());
            temp.setFechaSolicitud(sp.getFechaSolicitud());
            temp.setEstado(sp.getEstado());
            temp.setFechaResultado(sp.getFechaResultado());

            solicitudPremiumDAO.insert(temp);
            flag=true;
        } catch (Exception e) {
            throw new ValidationException("Error al registrar Solicitud Premium", e);
        }
        }
        return flag;
    }
    
    public boolean editarSPrem(SolicitudPremium sp) throws ValidationException {
        boolean flag = false;
//        String codecPassword = DigestUtils.md5Hex(u.getPassword());
//        u.setPassword(codecPassword);
        try {
            this.solicitudPremiumDAO.update(sp);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar la solicitud premium", e);
        }
        return flag;
    }
    
    public void eliminarSPrem(Integer id) {
        SolicitudPremium temp = this.solicitudPremiumDAO.findById(id, false);
        if (temp != null) {
            this.solicitudPremiumDAO.remove(temp);
        }
    }
}
