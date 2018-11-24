<%@page import="shared.messages.validations.Validation"%>
<%@page import="donnees.DemandeConvention"%>
<%@page import="java.util.Collection"%>
<%@page import="controllers.DemandesConventionsControllerRemote"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Service des stages</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <script charset="utf-8" src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script charset="utf-8" src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand">Service des stages</a>
                        </div>
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li>
                                    <a href="./index.jsp">Préconventions en cours</a>
                                </li>
                                <li>
                                    <a href="./preconvalides.jsp">Préconventions validées</a>
                                </li>
                                <li>
                                    <a href="./preconrefuses.jsp">Préconventions refusées</a>
                                </li>
                                <li class="active">
                                    <a href="./preconarchives.jsp">Préconventions archivées</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
            <div class="row" style="margin:50px">
                <div class="col-md-12">
                    <table class="table"  id="example" class="display" style="width:100%">
                        <thead>
                            <tr>
                                <th scope="col">Numéro</th>
                                <th scope="col">Etudiant</th>
                                <th scope="col">Formation</th>
                                <th scope="col">Entreprise</th>
                                <th scope="col">Statut final</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                javax.naming.InitialContext ic = new javax.naming.InitialContext();
                                DemandesConventionsControllerRemote ejb = (DemandesConventionsControllerRemote) ic.lookup("controllers.DemandesConventionsControllerRemote");
                                Collection<DemandeConvention> liste = ejb.obtenirDemandesArchivees();
                                Validation v = null;
                                for (DemandeConvention demandeEnCours : liste) {
                                    v = ejb.obtenirVoletInvalide(demandeEnCours);
                            %>
                            <tr>
                                <td><%= demandeEnCours.getKey() %></td>
                                <td><%= demandeEnCours.getEtudiant().getPrenom() + " " + demandeEnCours.getEtudiant().getNom().toUpperCase() + "(" + demandeEnCours.getEtudiant().getNumero() + ")" %></td>
                                <td><%= demandeEnCours.getDiplome().getNiveau() + " " + demandeEnCours.getDiplome().getIntitule() %></td>
                                <td><%= demandeEnCours.getEntreprise().getNom() + " (" + demandeEnCours.getEntreprise().getSiret() + ")" %></td>
                                <td><%= ejb.obtenirVoletInvalide(demandeEnCours) == null? "Validé" : "Refusé" %></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
