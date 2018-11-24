<%@page import="java.util.Collection"%>
<%@page import="shared.donnees.Diplome"%>
<%@page import="controllers.DemandesConventionsEtudiantControllerRemote"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Etudiant</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <script charset="utf-8" src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script charset="utf-8" src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
        <style>
            legend {
                font-weight: bold;
            }
            fieldset {
                margin-bottom: 30px;
            }
            label {
                font-weight: normal !important;
            }
        </style>
    </head>
    <body>

        <div class="container-fluid" >
            <div class="row">
                <div class="col-md-12">
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand">Etudiant</a>
                        </div>
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="active">
                                    <a href="./index.jsp">Formulaire de préconvention</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
            <div class="row" style="margin-left:100px; margin-right:100px; margin-top:20px;">
                <div class="col-md-12">
                    <form class="form-horizontal" method="post" action="EnvoyerFormulaire">
                        <fieldset>
                            <!-- Form Name -->
                            <legend>Etudiant</legend>
                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="textinput">Nom :</label>  
                                <div class="col-md-4">
                                    <input id="textinput" name="NomEtudiant" type="text" class="form-control">
                                </div>
                                <label class="col-md-2 control-label" for="textinput">Prénom :</label>  
                                <div class="col-md-4">
                                    <input id="textinput" name="PrenomEtudiant" type="text" class="form-control">
                                </div>
                            </div>    
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="textinput">Numéro étudiant :</label>  
                                <div class="col-md-4">
                                    <input id="textinput" name="NumeroEtudiant" type="text" class="form-control input-md">
                                </div>
                                <label class="col-md-2 control-label" for="textinput">Email :</label>  
                                <div class="col-md-4">
                                    <input id="textinput" name="EmailEtudiant" type="text" class="form-control input-md">
                                </div>
                            </div>
                        </fieldset>
                        <fieldset>
                            <!-- Form Name -->
                            <legend>Diplôme préparé</legend>
                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="textinput">Niveau et intitulé :</label>  
                                <div class="col-md-4">
                                    <select class="form-control" id="exampleFormControlSelect1" name="Formation">
                                        <%
                                            javax.naming.InitialContext ic = new javax.naming.InitialContext();
                                            DemandesConventionsEtudiantControllerRemote controller = (DemandesConventionsEtudiantControllerRemote) ic.lookup("controllers.DemandesConventionsEtudiantControllerRemote");
                                            Collection<Diplome> listeD = controller.obtenirTousLesDiplomes();
                                            for (Diplome dipEnCours : listeD) {
                                        %>
                                        <option value='<%= dipEnCours.getDepartement().getKey() +";" + dipEnCours.getNiveau() + ";" + dipEnCours.getIntitule()+";" + dipEnCours.getDepartement().getNom() %>' ><%= dipEnCours.getNiveau() + " " + dipEnCours.getIntitule() %></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                        </fieldset>
                        <fieldset>
                            <!-- Form Name -->
                            <legend>Responsabilité civile</legend>
                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="textinput">Compagnie d'assurance :</label>  
                                <div class="col-md-4">
                                    <input id="textinput" name="NomAssurance" type="text" class="form-control input-md">
                                </div>
                                <label class="col-md-2 control-label" for="textinput">Numéro de contrat :</label>  
                                <div class="col-md-4">
                                    <input id="textinput" name="NumContratAssurance" type="text" class="form-control input-md">
                                </div>
                            </div>
                        </fieldset>
                        <fieldset>
                            <!-- Form Name -->
                            <legend>Entreprise / Institution</legend>
                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="textinput">Nom :</label>  
                                <div class="col-md-4">
                                    <input id="textinput" name="NomEntreprise" type="text" class="form-control input-md">
                                </div>
                                <label class="col-md-2 control-label" for="textinput">Numéro SIRET :</label>  
                                <div class="col-md-4">
                                    <input id="textinput" name="SiretEntreprise" type="text" class="form-control input-md">
                                </div>
                            </div>    
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="textinput">Email de contact :</label>  
                                <div class="col-md-4">
                                    <input id="textinput" name="EmailEntreprise" type="text" class="form-control input-md">
                                </div>  
                            </div>
                        </fieldset>
                        <fieldset>
                            <!-- Form Name -->
                            <legend>Stage</legend>
                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="textinput">Date de début :</label>  
                                <div class="col-md-4">
                                    <input id="textinput" name="DebutStage" type="date" value="2018-01-01" class="form-control input-md">
                                </div>
                                <label class="col-md-2 control-label" for="textinput">Date de fin :</label>  
                                <div class="col-md-4">
                                    <input id="textinput" name="FinStage" type="date" value="2018-01-01" class="form-control input-md">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-2 control-label" for="textinput">Montant de la gratification :</label>  
                                <div class="col-md-4">
                                    <input id="textinput" name="GratificationStage" type="text" class="form-control input-md">
                                </div> 
                            </div>
                        </fieldset>
                        <fieldset>
                            <!-- Form Name -->
                            <legend>Résumé du sujet et des activités</legend>
                            <!-- Text input-->
                            <div class="form-group">
                                <div class="col-md-12">
                                    <textarea class="form-control" name="ResumeStage" rows="5" style="resize: none;"></textarea>
                                </div> 
                            </div>
                        </fieldset>

                        <button type="submit" class="btn btn-primary btn-lg btn-block">Envoyer le formulaire de préconvention</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
