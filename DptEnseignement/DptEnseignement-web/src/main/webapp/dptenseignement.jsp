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
                                <li>
                                    <a href="./index.jsp">Préconventions en cours</a>
                                </li>
                                <li>
                                    <a href="./preconvalides.jsp">Préconventions validées</a>
                                </li>
                                <li class="active">
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
                    <form class="navbar-form" role="search" method="post" action="ChangerDepartement">
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">Liste des départements d'enseignement :</label>
                            <select id="DptListe" class="form-control" name="DptSelected">
                                <%
                                    javax.naming.InitialContext ic = new javax.naming.InitialContext();
                                    PreconventionControllerRemote pc2 = (PreconventionControllerRemote) ic.lookup("controllers.PreconventionControllerRemote");
                                    Collection<Departement> listeD = pc2.obtenirDepartements();   
                                    for (Departement depEnCours : listeD) {
                                %>
                                <option value='<%=depEnCours.getKey().toString()+";"+depEnCours.getNom()%>' name="IdDptSelected"><%= depEnCours.getNom()%></option>
                                <%
                                    }
                                %>
                            </select>
                            <button type="submit" class="btn btn-primary">Choisir ce département d'enseignement</button>
                        </div>
                            
                    </form>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
