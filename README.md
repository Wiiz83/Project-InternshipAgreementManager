# Système de gestion de convention de stages

## Architecture
* Application web : étudiant
* Serveur web : 

## Types de projet  
* REST + JMS = Projet JEE
* REST = Projet Web
* JMS = Projet Java

## Liens utiles 
* Cours EAI : https://moodle.univ-tlse3.fr/course/view.php?id=2063 

## HowTo
* Filtrer des messages JMS : 
  * Côté sender : message.setJMSType("T1"); 
  * Côté receiver : receiver = session.createConsumer(dest, "JMSType IN ('T1','T2')");
  
  

