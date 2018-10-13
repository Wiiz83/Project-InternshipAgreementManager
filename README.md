# Système de gestion de convention de stages

## Architecture
* ServiceJuridique : Projet JEE / Application d'entreprise 
* DptEnseignement : Projet JEE / Application d'entreprise 
* ServiceScolarite : Projet JEE / Application d'entreprise 
* ServiceStages : Projet JEE / Application d'entreprise 
* ServeurEtudiant :

## Desription du workfkow 
1. L'étudiant envoi le formulaire au service des stages 
2. Le service des stages transmet le volet administratif au service de la scolarité 
 2.1. 

## Types de projet  
* REST + JMS = Projet JEE
* REST = Projet Web
* JMS = Projet Java

## Liens utiles 
* Cours EAI : https://moodle.univ-tlse3.fr/course/view.php?id=2063 
* Tutoriel JSF : https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/JMS2.0WebMessage/JMS2.0WebMessage.html

## HowTo
* Filtrer des messages JMS : 
  * Côté sender : message.setJMSType("T1"); 
  * Côté receiver : receiver = session.createConsumer(dest, "JMSType IN ('T1','T2')");
  
  

