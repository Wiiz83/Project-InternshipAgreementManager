<%@page import="controllers.PreconventionControllerRemote"%>
<%@page import="controllers.PreconventionController"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="donnees.DemandePedagogique"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Département d'enseignement</title>
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
                            <a class="navbar-brand">Département d'enseignement</a>
                        </div>
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="active">
                                    <a href="./index.jsp">Préconventions en cours</a>
                                </li>
                                <li>
                                    <a href="./preconvalides.jsp">Préconventions validées</a>
                                </li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <form class="navbar-form" role="search" method="post" action="Recherche">
                                    <div class="form-group">
                                        <select class="form-control" >
                                            <option>Informatique</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </select>
                                    </div>
                                </form>
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
                                <th scope="col">Début</th>
                                <th scope="col">Fin</th>
                                <th scope="col">Résumé du sujet et des activités</th>
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>
                        <tbody>

                            <%
                                javax.naming.InitialContext ic = new javax.naming.InitialContext();
                                PreconventionControllerRemote pc2 = (PreconventionControllerRemote) ic.lookup("controllers.PreconventionControllerRemote");
                                Map<Long, DemandePedagogique> listePEC2 = pc2.recupererPreconventionsEnCours();
                                Long idEnCours;
                                DemandePedagogique dpEnCours;
                                for (Map.Entry<Long, DemandePedagogique> entry : listePEC2.entrySet()) {
                                    idEnCours = entry.getKey();
                                    dpEnCours = entry.getValue();
                            %>
                            <tr>
                                <td><%= idEnCours%></td>
                                <td><%= dpEnCours.getDemande().getEtudiant().getPrenom() + " " + dpEnCours.getDemande().getEtudiant().getNom().toUpperCase() + "(" + dpEnCours.getDemande().getEtudiant().getNumero() + ")" %></td>
                                <td><%= dpEnCours.getDemande().getDiplome().getNiveau() + " " + dpEnCours.getDemande().getDiplome().getIntitule()%></td>
                                <td><%= dpEnCours.getDemande().getEntreprise().getNom()%></td>
                                <td><%= dpEnCours.getDemande().getStage().getDebut()%></td>
                                <td><%= dpEnCours.getDemande().getStage().getFin()%></td>
                                <td><%= dpEnCours.getDemande().getStage().getResume() %></td>
                                <td>
                                    <button>
                                        <i class="glyphicon glyphicon-eye-open"></i>
                                    </button>
                                    <button OnClick=<% session.setAttribute("idEnCours", idEnCours); %> data - toggle = "modal" data-target="#ModelPreconvValide">
                                        <i class="glyphicon glyphicon-ok"></i>
                                    </button>
                                    <button OnClick=<% session.setAttribute("idEnCours", idEnCours); %> data - toggle = "modal" data-target="#ModelPreconvInvalide">
                                        <i class="glyphicon glyphicon-ok"></i>
                                    </button>
                                </td>
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

    <!-- Modal Valide -->
    <div class="modal fade" id="ModelPreconvValide" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <form method="post" action="ValiderPreconvention">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">Nom du tuteur :</label>
                            <input type="text" class="form-control" id="recipient-name" name="nomTuteur">
                        </div>
                        
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" type="submit" name="IdPreconvention" value="<%= session.getAttribute("idEnCours")%>">Envoyer</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Modal Invalide -->
    <div class="modal fade" id="ModelPreconvInvalide" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <form method="post" action="InvaliderPreconvention">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">Motif du refus :</label>
                            <textarea class="form-control" id="message-text" name="motifRefus" ></textarea>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" type="submit" name="IdPreconvention" value="<%= session.getAttribute("idEnCours")%>">Envoyer</button>
                    </div>
                </form>
            </div>
        </div>
    </div>   

</body>
</html>
