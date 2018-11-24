<%@page import="shared.donnees.Departement"%>
<%@page import="java.util.Collection"%>
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
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
                                <li >
                                    <a href="./index.jsp">Préconventions en cours</a>
                                </li>
                                <li class="active">
                                    <a href="./preconvalides.jsp">Préconventions validées</a>
                                </li>
                                <li>
                                    <a href="./dptenseignement.jsp">Changer de département</a>
                                </li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <span class="navbar-text">Département en cours : <% 
                                    if (session.getAttribute("NomDptEnCours") != null) {  
                                        out.print(session.getAttribute("NomDptEnCours"));
                                    } else {
                                        out.print("Informatique");
                                    }
                                %>
                                </span>
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
                                <th scope="col">Tuteur</th>
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>
                        <tbody>

                            <%
                                javax.naming.InitialContext ic = new javax.naming.InitialContext();
                                PreconventionControllerRemote pc2 = (PreconventionControllerRemote) ic.lookup("controllers.PreconventionControllerRemote");
                                
                                Long idDptEnCours = 1L;
                                
                                if(session.getAttribute("IdDptEnCours") != null){
                                    idDptEnCours = Long.parseLong(session.getAttribute("IdDptEnCours").toString());
                                }
                                
                                Map<Long, DemandePedagogique> listePEC2 = pc2.recupererPreconventionsValides(idDptEnCours);
                                Long idEnCours;
                                DemandePedagogique dpEnCours;
                                for (Map.Entry<Long, DemandePedagogique> entry : listePEC2.entrySet()) {
                                    idEnCours = entry.getKey();
                                    dpEnCours = entry.getValue();
                            %>
                            <tr>
                                <td><%= idEnCours%></td>
                                <td><%= dpEnCours.getDemande().getEtudiant().getPrenom() + " " + dpEnCours.getDemande().getEtudiant().getNom().toUpperCase() + "(" + dpEnCours.getDemande().getEtudiant().getNumero() + ")"%></td>
                                <td><%= dpEnCours.getDemande().getDiplome().getNiveau() + " " + dpEnCours.getDemande().getDiplome().getIntitule()%></td>
                                <td><%= dpEnCours.getDemande().getEntreprise().getNom()%></td>
                                <td><%= dpEnCours.getDemande().getStage().getDebut()%></td>
                                <td><%= dpEnCours.getDemande().getStage().getFin()%></td>
                                <td><%= dpEnCours.getDemande().getStage().getResume()%></td>
                                <td>
                                    <button class="storeId" data-id="<%= idEnCours%>" data-toggle="modal" data-target="#ModelPreconvInvalide">
                                        <i class="glyphicon glyphicon-floppy-remove"></i>
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

</body>
</html>
