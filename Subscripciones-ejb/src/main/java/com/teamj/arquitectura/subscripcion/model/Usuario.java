/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.subscripcion.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Klever
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
public class Usuario implements Serializable{
//    @SequenceGenerator(name = "USUARIO_ID", sequenceName = "USUARIO_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USUARIO_ID")
    @Id
    @Column(name = "ID_USUARIO")
    private Integer id;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "NOMBRES")
    private String nombres;
    
    @Column(name = "APELLIDOS")
    private String apellidos;
    
    @Column(name = "GENERO")
    private String genero;

    @Column(name = "CERTIFICADO_VIH")
    private String certVIH;

    @Column(name = "CERTIFICADO_GON")
    private String certGON;

    @Column(name = "CERTIFICADO_SIF")
    private String certSIF;
    
    @Column(name = "CERTIFICADO_HER")
    private String certHER;
    
    @Column(name = "CERTIFICADO_CLA")
    private String certCLA;

    @Column(name = "CERTIFICADO_TRI")
    private String certTRI;
    

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCertVIH() {
        return certVIH;
    }

    public void setCertVIH(String certVIH) {
        this.certVIH = certVIH;
    }

    public String getCertGON() {
        return certGON;
    }

    public void setCertGON(String certGON) {
        this.certGON = certGON;
    }

    public String getCertSIF() {
        return certSIF;
    }

    public void setCertSIF(String certSIF) {
        this.certSIF = certSIF;
    }

    public String getCertHER() {
        return certHER;
    }

    public void setCertHER(String certHER) {
        this.certHER = certHER;
    }

    public String getCertCLA() {
        return certCLA;
    }

    public void setCertCLA(String certCLA) {
        this.certCLA = certCLA;
    }

    public String getCertTRI() {
        return certTRI;
    }

    public void setCertTRI(String certTRI) {
        this.certTRI = certTRI;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", nombres=" + nombres + ", apellidos=" + apellidos + ", genero=" + genero + ", certVIH=" + certVIH + ", certGON=" + certGON + ", certSIF=" + certSIF + ", certHER=" + certHER + ", certCLA=" + certCLA + ", certTRI=" + certTRI + '}';
    }

    
}
