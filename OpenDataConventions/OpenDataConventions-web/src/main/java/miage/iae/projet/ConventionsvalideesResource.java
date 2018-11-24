/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.iae.projet;

import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import shared.opendata.ConventionValidee;
import repositories.ConventionsValideesRepositoryLocal;

/**
 * REST Web Service
 *
 * @author Mahdi
 */
@Path("conventionsvalidees")
@RequestScoped

public class ConventionsvalideesResource {

    @Context
    private UriInfo context;

    @Inject
    ConventionsValideesRepositoryLocal repo;

    /**
     * Creates a new instance of ConventionsvalideesResource
     */
    public ConventionsvalideesResource() {
    }

    /**
     *
     * @param offset
     * @param limit
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ConventionValidee> getConventionValidee(@QueryParam("offset") int offset, @QueryParam("limit") int limit) {
        return repo.get(offset, limit);
    }

    /**
     *
     * @param c
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postConventionValidee(ConventionValidee c) {
        repo.insert(c);
    }
}
