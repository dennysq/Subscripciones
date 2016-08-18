/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.teamj.arquitectura.subscripcion.model.SolicitudPremium;
import com.teamj.arquitectura.subscripcion.services.SolicitudPremiumServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author RICARDO
 */
@Path("solicitudpremium")
@RequestScoped
public class SolicitudPremiumFacadeREST {

    @Context
    private UriInfo context;

    @EJB
    SolicitudPremiumServicio solicitudPremiumServicio;

    public SolicitudPremiumFacadeREST() {
    }

    //1
    @POST
    @Produces("text/plain")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/crearSolicitudPremium")
    public String crearSolicitud(@FormParam(value = "idUsu") String idUsuario,
            @FormParam(value = "emailUsu") String emailUsu, @FormParam(value = "nombresUsu") String nombresUsu,
            @FormParam(value = "apellUsu") String apellUsu, @FormParam(value = "geneUsu") String geneUsu,
            @FormParam(value = "certVIH") String certVIH, @FormParam(value = "certGON") String certGON,
            @FormParam(value = "certSIF") String certSIF, @FormParam(value = "certHER") String certHER,
            @FormParam(value = "certCLA") String certCLA, @FormParam(value = "certTRI") String certTRI) {

        
        return solicitudPremiumServicio.crearSolicitudPremium(idUsuario, emailUsu, nombresUsu, apellUsu, geneUsu, certVIH, certGON, certSIF, certHER, certCLA, certTRI);
    }
    

    //2
    @POST
    @Produces("text/plain")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/estadoSolicitudPremium")
    public String consultarEstadoSolicitud(@FormParam(value = "idUsu") String idUsuario)
    {
        return solicitudPremiumServicio.consultarEstadoSolicitudPremium(idUsuario);
    }
}
