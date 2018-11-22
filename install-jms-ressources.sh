#!/bin/bash
typeset -A config 

find -name "glassfish-resources.xml" > './gfressources.cfg'

. ./path.cfg

githubrepo=${PWD}

cd "${config[galssfish_path]}"
cd ./bin/


cat "${githubrepo}/gfressources.cfg" | while read gfr
  do  
  ./asadmin add-resources "${githubrepo}$gfr"
  done 
