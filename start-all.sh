#!/bin/bash
typeset -A config 

find -name "*.ear" > './ear-apps.cfg'

. ./path.cfg

githubrepo=${PWD}

cd "${config[galssfish_path]}"
cd ./bin/

cat "${githubrepo}/ear-apps.cfg" | while read app
  do  
  ./asadmin deploy --force=true "${githubrepo}$app"
  done 

start http://localhost:8080/DptEnseignement-web/
start http://localhost:8080/ServiceJuridique-web/
start http://localhost:8080/ServiceStages-web/
start http://localhost:8080/ServiceScolarite-web/
start http://localhost:8080/ServeurEtudiant-web/
start "http://localhost:8080/OpenDataConventions-web/webresources/conventionsvalidees?offset=0&limit=20"