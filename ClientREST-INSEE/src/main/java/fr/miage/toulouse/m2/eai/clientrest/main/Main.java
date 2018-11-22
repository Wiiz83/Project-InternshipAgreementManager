/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.toulouse.m2.eai.clientrest.main;

import com.google.gson.Gson;
import fr.miage.toulouse.m2.eai.clientrest.metiersiren.SirenPOJO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * Main
 *
 * @author Cédric Teyssié  <cedric.teyssie@irit.fr>, IRIT-SIERA, Université Paul Sabatier
 * @version 0.1, 1 oct. 2018
 * @since 0.1, 1 oct. 2018
 */
// ClientREST-INSEE
// fr.miage.toulouse.m2.eai.clientrest.insee
// Main.java
public class Main {

    public static void main(String[] args) throws IOException {
        // I/O clavier/écran
        BufferedReader inClavier = new BufferedReader(new InputStreamReader(System.in));
        PrintStream outEcran = new PrintStream(System.out);

        // I/O JSON
        Gson gson = new Gson();

        // TOKEN BEARER a récuperer sur INSEE
        String token = "Bearer 87faafeb-b34f-39d4-8cc0-cb9e7a15a8d9";
        // URI Service INSEE
        String uri = "http://data.opendatasoft.com/api/records/1.0/search/?dataset=sirene%40public";

        // a ajuster selon requete voir mode emploi INSEE
        String query = "&lang=fr&rows=1";

        // SIREN a chercher
        outEcran.print("Code SIREN a rechercher : ");
        String siren = inClavier.readLine();
        // Pour info siren = "552100554"; //PIGEOT.

        Client client = ClientBuilder.newClient();
        WebTarget wt = client.target(uri + "&q=" + siren + query);

        //WebResource webResource = client.resource(uri + siren + query);
        System.out.println("uri appel: " + uri + "&q=" + siren + query);

        Invocation.Builder invocationBuilder = wt.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        String reponse = response.readEntity(String.class);

        // Convertisseur JSON
        SirenPOJO model = gson.fromJson(reponse, SirenPOJO.class);

        System.out.println("Résultat: " + response.getStatus());
        System.out.println("Raison sociale : " + model.getRecords()[0].getFields().getL1_normalisee() + ", Date création entité : " + model.getRecords()[0].getFields().getDcren() + ", Activité : " + model.getRecords()[0].getFields().getActivite());
    }

}
