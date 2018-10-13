# Système de gestion de convention de stages

## Architecture
* ServiceJuridique : Projet JEE / Application d'entreprise 
* DptEnseignement : Projet JEE / Application d'entreprise 
* ServiceScolarite : Projet JEE / Application d'entreprise 
* ServiceStages : Projet JEE / Application d'entreprise 
* ServeurEtudiant :

## Desription du workfkow 
1. L'étudiant envoi le formulaire au service des stages 
2. Le service des stages transmet le volet administratif au service de la scolarité :
     - Avec le nom, prénom et numéro étudiant : vérifie que l'étudiant est inscrit dans une formation universitaire 
3. **SI VOLET ADMINISTRATIF VALIDE**, le service des stages transmet le volet au département d'enseignement :
     - Le département d'enseignement vérifie :
         - que le stage est bien inscrit dans le cursus de la formation

⋅⋅⋅⋅3. que les activités décrites dans le résumé relèvent bien à la fois de la thématique de la formation et du niveau de compétence adéquate   

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
  
  

