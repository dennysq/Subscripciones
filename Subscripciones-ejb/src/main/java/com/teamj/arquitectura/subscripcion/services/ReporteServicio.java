/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.subscripcion.services;

import com.teamj.arquitectura.subscripcion.dao.ReporteDAO;
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
public class ReporteServicio implements Serializable{
    @EJB
    private ReporteDAO reporteDAO;


    public Reporte obtenerPorId(Integer id) {
        return this.reporteDAO.findById(id, false);
    }
    public List<Reporte> retrieveReportes() {
        return this.reporteDAO.findAll();
    }
    public boolean registrarRepor(Reporte r) throws ValidationException {
        boolean flag = false;
        Reporte temp = new Reporte();
                
        try {
        temp.setNombre(r.getNombre());
//        String codecPassword = DigestUtils.md5Hex(u.getPassword());
//        temp.setPassword(codecPassword);

        temp.setDescripcion(r.getDescripcion());
        reporteDAO.insert(temp);
        flag=true;
        } catch (Exception e) {
            throw new ValidationException("Error al crear un nuevo reporte", e);
        }
        return flag;
    }
    public boolean editarRepor(Reporte r) throws ValidationException {
        boolean flag = false;
//        String codecPassword = DigestUtils.md5Hex(u.getPassword());
//        u.setPassword(codecPassword);
        try {
            this.reporteDAO.update(r);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar al reporte", e);
        }
        return flag;
    }
    
    public void eliminarRepor(Integer id) {
        Reporte temp = this.reporteDAO.findById(id, false);
        if (temp != null) {
            this.reporteDAO.remove(temp);
        }
    }
}
