#!/bin/bash
typeset -A config 

find -name "glassfish-resources.xml" > './gfressources.cfg'

. ./path.cfg

githubrepo=${PWD}

cd "${config[galssfish_path]}"
cd ./bin/
#./asadmin delete-jms-host default_JMS_host
./asadmin create-jms-host --mqhost localhost --mqport 56421 --mquser jmsclient --mqpassword 123456789 jmsuniversite
./asadmin set server.jms-service.type=REMOTE
./asadmin set server.jms-service.default-jms-host=jmsuniversite

cat ${githubrepo}/gfressources.cfg | while read gfr
  do  
  ./asadmin add-resources ${githubrepo}$gfr
  done 

cd ${config[openmq_path]}
./mq/bin/imqusermgr update -u admin -a true -p 123456789
./mq/bin/imqusermgr add -u jmsclient -p 123456789
