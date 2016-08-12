/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.subscripcion.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import com.teamj.arquitectura.subscripcion.model.Administrador;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Klever
 */
@LocalBean
@Stateless
public class AdministradorDAO extends DefaultGenericDAOImple<Administrador, Integer>{
    public AdministradorDAO() {
            super(Administrador.class);
    }
}
