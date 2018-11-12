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
                            <a class="navbar-brand" href="Index">Département d'enseignement</a>
                        </div>
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li>
                                    <a href="./index.jsp">Préconventions en cours</a>
                                </li>
                                <li class="active">
                                    <a href="./preconvalides.jsp">Préconventions validées</a>
                                </li>
                            </ul>
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
                            <tr>
                                <td>XXXX</td>
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
                                    <a href="javascript:void(0)" title="Supprimer">
                                        <i class="glyphicon glyphicon-floppy-remove"></i>
                                    </a>      
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
