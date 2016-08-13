/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.subscripcion.services;

import com.teamj.arquitectura.subscripcion.dao.AdministradorDAO;
import com.teamj.arquitectura.subscripcion.model.Administrador;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.validation.ValidationException;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Klever
 */
@Stateless
@LocalBean
public class AdministradorServicio implements Serializable{
    @EJB
    private AdministradorDAO administradorDAO;
    
    public Administrador obtenerPorId(Integer id) {
        return this.administradorDAO.findById(id, false);
    }
    public List<Administrador> retrieveAdministrador() {
        return this.administradorDAO.findAll();
    }
    
    public boolean registrarAdmi(Administrador a) throws ValidationException {
        boolean flag = false;
        Administrador temp = new Administrador();
        try {
        temp.setEmail(a.getEmail());
        String codecPassword = DigestUtils.md5Hex(a.getPassword());
        temp.setPassword(codecPassword);
        //temp.setPassword(a.getPassword());
        temp.setEstado(a.getEstado());
        administradorDAO.insert(temp);
        flag=true;
        } catch (Exception e) {
            throw new ValidationException("Error al crear un nuevo usuario", e);
        }
        return flag;
    }
    
    public boolean editarAdmi(Administrador a) throws ValidationException {
        boolean flag = false;
        String codecPassword = DigestUtils.md5Hex(a.getPassword());
        a.setPassword(codecPassword);
        try {
            this.administradorDAO.update(a);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar al administrador", e);
        }
        return flag;
    }
    
    public void eliminarAdmi(Integer id) {
        Administrador temp = this.administradorDAO.findById(id, false);
        if (temp != null) {
            this.administradorDAO.remove(temp);
        }
    }
    
    
//    public Usuario retrieveUserLoged(Usuario u){
//        Usuario tempUsu = new Usuario();
//        tempUsu.setUsername(u.getUsername());
//
//        List<Usuario> tempList = this.usuarioDAO.find(tempUsu);
//        if (tempList != null && tempList.size() == 1) {
//            if (DigestUtils.md5Hex(u.getPassword()).equals(tempList.get(0).getPassword())) {
//                return tempList.get(0);
//            }
//        }
//        return null;
//    }
}
