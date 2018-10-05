/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.toulouse.serveuretudiant;

import com.miage.toulouse.shared.messages.DemandeConvention;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Mahdi
 */
@Path("DemandeConvention")
public class DemandeConventionResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DemandeConventionResource
     */
    public DemandeConventionResource() {
    }
 
    /**
     * PUT method for updating or creating an instance of DemandeConventionResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(DemandeConvention content) {
    }
}
