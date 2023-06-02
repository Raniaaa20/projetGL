#Projet de Simulation du Réseau de Métro Parisien
Ce projet vise à simuler le réseau de métro parisien en offrant aux utilisateurs la possibilité de planifier leurs trajets, 
de trouver le chemin optimal entre deux stations et d'obtenir des estimations de temps de trajet.

##Fonctionnalités:
Le système de simulation du métro parisien offre les fonctionnalités suivantes :

###Recherche du chemin optimal : 

Les utilisateurs peuvent rechercher le chemin optimal entre deux stations en spécifiant 
la station de départ et la station d'arrivée. L'algorithme de Ford Bellman est utilisé pour calculer le chemin le plus 
court en tenant compte des temps de parcours et des éventuels accidents.

###Estimation du temps de trajet :

Le système fournit une estimation du temps de trajet pour le chemin optimal calculé. 
Cela aide les utilisateurs à planifier leurs déplacements en fonction des contraintes de temps.

###Gestion des correspondances (non implémentée) :

L'idée était de fournir la possibilité à l'utilisateur d'éviter les itinéraires 
avec des correspondances

###Gestion des accidents : 

Le système évite les accidents qui peuvent se produire dans les stations ou les voies. 