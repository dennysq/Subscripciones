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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
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
    @EJB
    private AdministradorServicio administradorServicio;

    public SolicitudPremium obtenerPorId(Integer id) {
        return this.solicitudPremiumDAO.findById(id, false);
    }

    public List<SolicitudPremium> obtenerSolicitudesPremium() {
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

        if (tempListA != null && tempListA.size() == 1 && tempListU != null && tempListU.size() == 1) {
            try {
                temp.setAdministrador(sp.getAdministrador());
                temp.setUsuario(sp.getUsuario());
                temp.setFechaSolicitud(sp.getFechaSolicitud());
                temp.setEstado(sp.getEstado());
                temp.setFechaResultado(sp.getFechaResultado());

                solicitudPremiumDAO.insert(temp);
                flag = true;
            } catch (Exception e) {
                throw new ValidationException("Error al registrar Solicitud Premium", e);
            }
        }
        return flag;
    }

    public boolean editar(SolicitudPremium sp) throws ValidationException {
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

    public boolean crearSolicitudPremium(String Id, String Email, String Nombres, String Apellidos, String Genero,
            String CertVIH, String CertGON, String CertSIF, String CertHER, String CertCLA, String CertTRI) {

        Usuario usuarioTemp = new Usuario();
        SolicitudPremium solicTemp = new SolicitudPremium();
        String emailAdmin = "ricardo10_21@hotmail.com";
        Administrador admin = administradorServicio.obtenerAdministradorByEmail(emailAdmin);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("ECT"));

        try {

            usuarioTemp.setId(Integer.parseInt(Id));
            usuarioTemp.setNombres(Nombres);
            usuarioTemp.setApellidos(Apellidos);
            usuarioTemp.setEmail(Email);
            usuarioTemp.setGenero(Genero);
            usuarioTemp.setCertVIH(CertVIH);
            usuarioTemp.setCertGON(CertGON);
            usuarioTemp.setCertSIF(CertSIF);
            usuarioTemp.setCertHER(CertHER);
            usuarioTemp.setCertCLA(CertCLA);
            usuarioTemp.setCertTRI(CertTRI);

            usuarioDAO.insert(usuarioTemp);

            if (admin != null) {
                solicTemp.setAdministrador(admin);
            }

            solicTemp.setUsuario(usuarioTemp);
            solicTemp.setFechaSolicitud(cal.getTime());
            solicTemp.setEstado("N");

            solicitudPremiumDAO.insert(solicTemp);

            return true;
        } catch (Exception e) {
            System.out.println("" + e);
        }

        return false;

    }

    public String consultarEstadoSolicitudPremium(String Id) {

        Usuario usuarioTemp = new Usuario();
        SolicitudPremium solicTemp = new SolicitudPremium();
        String emailAdmin = "ricardo10_21@hotmail.com";
        Administrador admin = administradorServicio.obtenerAdministradorByEmail(emailAdmin);
        List<SolicitudPremium> listaSolicitudes = new ArrayList();

        try {

            usuarioTemp = usuarioDAO.findById(Integer.parseInt(Id), false);

            if (usuarioTemp != null) {
                solicTemp.setUsuario(usuarioTemp);
                listaSolicitudes = solicitudPremiumDAO.find(solicTemp);
                if (!listaSolicitudes.isEmpty()) {
                    return listaSolicitudes.get(0).getEstado();
                }
            }
        } catch (Exception e) {
            System.out.println("" + e);
        }

        return "N";

    }
}
