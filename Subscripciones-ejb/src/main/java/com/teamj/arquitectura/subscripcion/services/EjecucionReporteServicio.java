/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.subscripcion.services;

import com.teamj.arquitectura.subscripcion.dao.AdministradorDAO;
import com.teamj.arquitectura.subscripcion.dao.EjecucionReporteDAO;
import com.teamj.arquitectura.subscripcion.dao.ReporteDAO;
import com.teamj.arquitectura.subscripcion.model.Administrador;
import com.teamj.arquitectura.subscripcion.model.EjecucionReporte;
import com.teamj.arquitectura.subscripcion.model.EjecucionReportePK;
import com.teamj.arquitectura.subscripcion.model.Reporte;
import java.io.Serializable;
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
public class EjecucionReporteServicio implements Serializable{
    @EJB
    private EjecucionReporteDAO ejecucionReporteDAO;
    @EJB
    private ReporteDAO reporteDAO;
    @EJB
    private AdministradorDAO administradorDAO;
    
    public EjecucionReporte obtenerPorId(Integer id) {
        return this.ejecucionReporteDAO.findById(id, false);
    }
    
    public List<EjecucionReporte> retrieveERepor() {
        return this.ejecucionReporteDAO.findAll();
    }
    
    public boolean registrarERepor(EjecucionReporte er) throws ValidationException {
        boolean flag = false;
        EjecucionReporte temp = new EjecucionReporte();
        Administrador tempAdmi = new Administrador();
        Reporte tempRep = new Reporte();
        
        tempAdmi.setId(er.getAdministrador().getId());
        tempRep.setId(er.getReporte().getId());
        
        List<Administrador> tempListA = this.administradorDAO.find(tempAdmi);
        List<Reporte> tempListR = this.reporteDAO.find(tempRep);
        
        if (tempListA != null && tempListA.size() == 1 && tempListR != null && tempListR.size() == 1){
        try {
            EjecucionReportePK ejecucionReportePK=new EjecucionReportePK();
            
            ejecucionReportePK.setIdAdministrador(er.getAdministrador().getId());
            ejecucionReportePK.setIdReporte(er.getReporte().getId());
            
            temp.setEjecucionReportePK(ejecucionReportePK);
        
            temp.setFechaEjecucion(er.getFechaEjecucion());
            ejecucionReporteDAO.insert(temp);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al crear una nueva Ejecucion de Reporte", e);
        }
        }
        return flag;
    }
    
    public boolean editarERepor(EjecucionReporte er) throws ValidationException {
        boolean flag = false;
//        String codecPassword = DigestUtils.md5Hex(u.getPassword());
//        u.setPassword(codecPassword);
        try {
            this.ejecucionReporteDAO.update(er);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar la ejecucion de reporte", e);
        }
        return flag;
    }
    
    public void eliminarERepor(Integer id) {
        EjecucionReporte temp = this.ejecucionReporteDAO.findById(id, false);
        if (temp != null) {
            this.ejecucionReporteDAO.remove(temp);
        }
    }
}
