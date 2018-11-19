<%@page import="donnees.DemandeAdministrative"%>
<%@page import="java.util.Collection"%>
<%@page import="controllers.DemandesAdministrativesControllerRemote"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Service de la scolarité</title>
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
                            <a class="navbar-brand">Service de la scolarité</a>
                        </div>
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="active">
                                    <a href="./index.jsp">Préconventions à valider</a>
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
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                javax.naming.InitialContext ic = new javax.naming.InitialContext();
                                DemandesAdministrativesControllerRemote ejb = (DemandesAdministrativesControllerRemote) ic.lookup("controllers.DemandesAdministrativesControllerRemote");
                                Collection<DemandeAdministrative> liste = ejb.obtenirDemandes();
                                for (DemandeAdministrative demandeEnCours : liste) {
                            %>
                            <tr>
                                <td><%= demandeEnCours.getKey() %></td>
                                <td><%= demandeEnCours.getDemande().getEtudiant().getPrenom() + " " + demandeEnCours.getDemande().getEtudiant().getNom().toUpperCase() + "(" + demandeEnCours.getDemande().getEtudiant().getNumero() + ")" %></td>
                                <td><%= demandeEnCours.getDemande().getDiplome().getNiveau() + " " + demandeEnCours.getDemande().getDiplome().getIntitule() %></td>
                                <td>
                                     <button>
                                        <i class="glyphicon glyphicon-eye-open"></i>
                                    </button>
                                    <form method="post" action="ValiderPreconvention">
                                        <button name="IdPreconvention" value="<%= demandeEnCours.getKey() %>">
                                            <i class="glyphicon glyphicon-ok"></i>
                                        </button>
                                    </form>
                                    <button class="storeId" data-id="<%= demandeEnCours.getKey() %>" data-toggle="modal" data-target="#ModelPreconvInvalide">
                                        <i class="glyphicon glyphicon-remove"></i>
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
    
    
    
    <!-- Modal Invalide -->
    <div class="modal fade" id="ModelPreconvInvalide" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <form method="post" action="InvaliderPreconvention">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="message-text" class="col-form-label">Motif du refus :</label>
                            <textarea class="form-control" id="message-text" name="motifRefus" ></textarea>
                            <input id="prodId" name="currentDepartementID" type="hidden" value="">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button id="getIdInvalide" class="btn btn-primary" type="submit" name="IdPreconvention" value="">Envoyer</button>
                    </div>
                </form>
            </div>
        </div>
    </div>  
    
 <script LANGUAGE="JavaScript">
$(document).on("click", ".storeId", function () {
     var currentId = $(this).data('id');
     document.getElementById("getIdInvalide").value = currentId;
});
</script>

</body>
</html>
