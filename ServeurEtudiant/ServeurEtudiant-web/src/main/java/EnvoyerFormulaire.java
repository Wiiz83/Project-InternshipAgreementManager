/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.DemandesConventionsEtudiantControllerRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.donnees.Diplome;
import shared.donnees.Entreprise;
import shared.donnees.Etudiant;
import shared.donnees.ResponsabiliteCivile;
import shared.donnees.Stage;
import shared.messages.demandes.DemandeConventionMessage;

/**
 *
 * @author uzanl
 */
public class EnvoyerFormulaire extends HttpServlet {

    @EJB
    DemandesConventionsEtudiantControllerRemote dce;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("PASSE");
        
        String NomEtudiant = request.getParameter("NomEtudiant");
        String PrenomEtudiant = request.getParameter("PrenomEtudiant");
        String NumeroEtudiant = request.getParameter("NumeroEtudiant");
        String EmailEtudiant = request.getParameter("EmailEtudiant");
        String NiveauFormation = request.getParameter("NiveauFormation");
        String IntituleFormation = request.getParameter("IntituleFormation");
        String NomAssurance = request.getParameter("NomAssurance");
        String NumContratAssurance = request.getParameter("NumContratAssurance");
        String NomEntreprise = request.getParameter("NomEntreprise");
        String SiretEntreprise = request.getParameter("SiretEntreprise");
        String EmailEntreprise = request.getParameter("EmailEntreprise");
        String DebutStage = request.getParameter("DebutStage");
        String FinStage = request.getParameter("FinStage");
        String GratificationStage = request.getParameter("GratificationStage");
        String ResumeStage = request.getParameter("ResumeStage");
       
        Etudiant etudiant = new Etudiant(NumeroEtudiant, NomEtudiant, PrenomEtudiant, EmailEtudiant);
        Diplome diplome = new Diplome(NiveauFormation, IntituleFormation);
        Entreprise entreprise = new Entreprise(SiretEntreprise, NomEntreprise, EmailEntreprise);
        ResponsabiliteCivile rc = new ResponsabiliteCivile(NomAssurance, NumContratAssurance);
        Stage stage = new Stage(DebutStage, FinStage, Double.parseDouble(GratificationStage.replace(",", ".")), ResumeStage);
        shared.messages.demandes.DemandeConventionMessage demande = new DemandeConventionMessage(etudiant, diplome, rc, stage, entreprise);
        
        dce.ajouterDemande(demande);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
