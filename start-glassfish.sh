#!/bin/bash
typeset -A config 

. ./path.cfg

cd "${config[galssfish_path]}"
cd ./bin/
./asadmin stop-domain
./asadmin start-domain --verbose 
