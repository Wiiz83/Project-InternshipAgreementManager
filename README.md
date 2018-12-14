# Système de gestion de convention de stages


## Environnement 
* Glassfish 5
* Java 8
* OpenMQ 5.1 (optionnel)

## Architecture
* ServiceJuridique : Projet JEE / Application d'entreprise 
* DptEnseignement : Projet JEE / Application d'entreprise 
* ServiceScolarite : Projet JEE / Application d'entreprise 
* ServiceStages : Projet JEE / Application d'entreprise 
* ServeurEtudiant : Projet JEE / Application d'entreprise 
* OpenData : Projet JEE / Application d'entreprise 
* Shared: Projet Java
* ClientREST-INSEE: Projet Java fourni

## Installation 
Spécifier les chemins de glassfish et OpenMQ dans path.cfg

### Ressources glassfish
> ./install-glassfish-ressources.sh

### OpenMQ en mode REMOTE (optionnel si même serveur)
Modifier les paramètres de ligne de commande sur install-remote-jms.sh
> ./install-remote-jms.sh

## Démarrage
### Glassfish
> ./start-glassfish.sh
### OpenMQ (si en mode REMOTE)
> ./start-openmq.sh
### Applications
Compiler sur NetBeans et déployer. Si Les applications sont déjà compilées et présentes au format .ear, démarrer avec :
> ./start-apps.sh

NB: Vu qu'il n'y pas de SGBD où l'application OpenData peut récupérer les données comme expliqué au dossier de conception mis à jour, cette application doit tourner en permanence (caractère synchrone de HTTP).




  

