L’objectif de ce projet est de développer une application de gestion des projets e-Projet pour la société GreenIT, cette application doit assurer la gestion et le suivie de la réalisation des projets.

<h1>Partie I : Base de données</h1>
L’application e-Projet utilise la base de données gestion_projets gérée par le SGBD MySQL, la base de données gestion_projets contient quatre tables : « equipe », « employe », « projet » et « tache ». La société GreenIT dispose d’un serveur MySql et d’un serveur Tomcat. Pour accéder à la base de donnée, on utilise le compte de l’utilisateur Admin (nom: admin, mot de pass :admin)
<br>
Le MLD de l’application e-Projet.
<br> Un employé est affecté à une équipe,
<br> Un employé peut être le chef de plusieurs projets,
<br> Un projet est compose de plusieurs tâches,
<br> Une tache peut être réalisée par un seul employé,
<br> Un employé est caractérisé par un ensemble d’informations dont le rôle {Administrateur, Chef de projet, Employé }.
<br> Une tâche est caractérisée par un ensemble d’informations dont le statut d’une tâche {A faire, En cours, Terminé }.

<h1>￼Partie II : métier </h1>
Les fonctionnalités principales à développer sont :
<br> l’authentification et la déconnexion,
<br> Selon le rôle de l’employé connecté, on lui affiche ses propres fonctionnalités :
    <br>  o Rôle Administrateur : permet à l’administrateur de gérer les équipes et les employés.
     <br> o Rôle Chef de projet : permet au chef de projet de gérer ses propres projets et leurs tâches et aussi il peut affecter des taches à des employés.
     <br> o Rôle Employé : permet à l’employé de voir seulement ses taches et les mettre-à-jour (statut, date de début et date de fin).
<br>La fonction «gérer» présente les fonctions CRUD: consulter, rechercher, modifier et supprimer.

<h1>Partie III : IHM</h1>
La société GreenIT exige que les pages web développées soit ergonomiques et conviviales, et pour cela il faut utiliser le framework Bootstrap.
<br>Il faut développer les interfaces nécessaires pour réaliser toutes les fonctionnalités citées dans la partie métier.
￼￼￼
