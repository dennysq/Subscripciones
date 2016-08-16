/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.subscripcion.services;

import com.teamj.arquitectura.subscripcion.dao.UsuarioDAO;
import com.teamj.arquitectura.subscripcion.model.Usuario;
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
public class UsuarioServicio implements Serializable{
    @EJB
    private UsuarioDAO usuarioDAO;
    
    public Usuario obtenerPorId(Integer id) {
        return this.usuarioDAO.findById(id, false);
    }
    public List<Usuario> retrieveUsers() {
        return this.usuarioDAO.findAll();
    }
    
 
    public boolean registrarUsu(Usuario u) throws ValidationException {
        boolean flag = false;
        Usuario temp = new Usuario();
        try {
        temp.setEmail(u.getEmail());
//        String codecPassword = DigestUtils.md5Hex(u.getPassword());
//        temp.setPassword(codecPassword);

        temp.setNombres(u.getNombres());
        temp.setApellidos(u.getApellidos());
        temp.setGenero(u.getGenero());
        usuarioDAO.insert(temp);
        flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al crear un nuevo usuario", e);
        }
        return flag;
    }
    
    public boolean editarUsu(Usuario u) throws ValidationException {
        boolean flag = false;
//        String codecPassword = DigestUtils.md5Hex(u.getPassword());
//        u.setPassword(codecPassword);
        try {
            this.usuarioDAO.update(u);
            flag = true;
        } catch (Exception e) {
            throw new ValidationException("Error al editar al usuario", e);
        }
        return flag;
    }
    
    public void eliminarUsu(Integer id) {
        Usuario temp = this.usuarioDAO.findById(id, false);
        if (temp != null) {
            this.usuarioDAO.remove(temp);
        }
    }
    
    public Usuario retrieveUserLoged(String usuario, String password){
        Usuario tempUsu = new Usuario();
        tempUsu.setEmail(usuario);

        List<Usuario> tempList = this.usuarioDAO.find(tempUsu);
        if (tempList != null && tempList.size() == 1) {
            if (password.equals(tempList.get(0).getEmail())) {
                return tempList.get(0);
            }
        }
        return null;
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
