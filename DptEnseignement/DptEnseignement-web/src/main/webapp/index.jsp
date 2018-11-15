<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <title>D�partement d'enseignement</title>
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
                            <a class="navbar-brand">D�partement d'enseignement</a>
                        </div>
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="active">
                                    <a href="./index.jsp">Pr�conventions en cours</a>
                                </li>
                                <li>
                                    <a href="./preconvalides.jsp">Pr�conventions valid�es</a>
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
                                <th scope="col">Num�ro</th>
                                <th scope="col">Etudiant</th>
                                <th scope="col">Formation</th>
                                <th scope="col">Entreprise</th>
                                <th scope="col">D�but</th>
                                <th scope="col">Fin</th>
                                <th scope="col">R�sum� du sujet et des activit�s</th>
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>XXXX</td>
                                <td>XXXX</td>
                                <td>XXXX</td>
                                <td>XXXX</td>
                                <td>XXXX</td>
                                <td>XXXX</td>
                                <td>XXXX</td>
                                <td>
                                    <a href="javascript:void(0)" title="Ouvrir">
                                        <i class="glyphicon glyphicon-eye-open"></i>
                                    </a>
                                    <a href="javascript:void(0)" title="Valider">
                                        <i class="glyphicon glyphicon-ok"></i>
                                    </a>
                                    <a href="javascript:void(0)" title="Refuser">
                                        <i class="glyphicon glyphicon-remove"></i>
                                    </a>      
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    
                    
                   <% 
                       
                       

                   %>
                    <%
                        /* try {
                        List<Preconvention> PreconvEnCours = DebutRevision.getNavetteList(convertedLong);
                        for (Revision r : revisions) {
                            out.println("<tr>");
                            out.println("<td>XXXX</td>");
                            out.println("<td>XXXX</td>");
                            out.println("<td>XXXX</td>");
                            out.println("<td>XXXX</td>");
                            out.println("<td>XXXX</td>");
                            out.println("<td>XXXX</td>");
                            out.println("<td>XXXX</td>");
                            out.println("
                            <td>
                                <a href="javascript:void(0)" title="Ouvrir">
                                    <i class="glyphicon glyphicon-eye-open"></i>
                                </a>
                                <a href="javascript:void(0)" title="Valider">
                                    <i class="glyphicon glyphicon-ok"></i>
                                </a>
                                <a href="javascript:void(0)" title="Supprimer">
                                    <i class="glyphicon glyphicon-remove"></i>
                                </a>      
                            </td>
                            ");
                            out.println("</tr>");
                        }
                    }*/
                    %>
                </div>
            </div>
        </div>
    </div>
</body>
</html>