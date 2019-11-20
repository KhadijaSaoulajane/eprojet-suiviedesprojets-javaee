-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le :  sam. 02 fév. 2019 à 10:32
-- Version du serveur :  5.6.38
-- Version de PHP :  7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `gestion_projets`
--

-- --------------------------------------------------------

--
-- Structure de la table `Employe`
--

CREATE TABLE `Employe` (
  `id_empl` int(11) NOT NULL,
  `date_naissance_empl` datetime DEFAULT NULL,
  `email_empl` varchar(100) DEFAULT NULL,
  `mot_passe_empl` varchar(10) DEFAULT NULL,
  `nom_empl` varchar(45) DEFAULT NULL,
  `prenom_empl` varchar(45) DEFAULT NULL,
  `role_empl` varchar(45) DEFAULT NULL,
  `code_equipe` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Employe`
--

INSERT INTO `Employe` (`id_empl`, `date_naissance_empl`, `email_empl`, `mot_passe_empl`, `nom_empl`, `prenom_empl`, `role_empl`, `code_equipe`) VALUES
(17, '1980-01-04 00:00:00', 'Boukouchi@gmail.com', 'dija', 'Mr. Boukouchi', 'Youness', 'Administrateur', 1),
(18, '1997-09-11 00:00:00', 'Khadija@gmail.com', 'dija', 'Saoulajane', 'Khadija', 'Chef de projet', 1),
(19, '1970-02-10 00:00:00', 'Employe1@gmail.com', 'dija', 'Fabian', 'Lara', 'Employe', 2),
(20, '1963-03-07 00:00:00', 'Employe2@gmail.com', 'dija', 'Andaloussi', 'Chakib', 'Administrateur', 3);

-- --------------------------------------------------------

--
-- Structure de la table `Equipe`
--

CREATE TABLE `Equipe` (
  `code_equipe` int(11) NOT NULL,
  `description_equipe` varchar(255) DEFAULT NULL,
  `nom_equipe` varchar(45) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Equipe`
--

INSERT INTO `Equipe` (`code_equipe`, `description_equipe`, `nom_equipe`) VALUES
(1, 'Equipe motivé à noter les présentateurs', 'Jury'),
(2, 'Equipe qui présente devant le jury', 'Présentation'),
(3, 'Equipe qui vérifie le bon déroulement de la présentation', 'Organisation'),
(16, 'teste équipe', 'testee');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(6),
(6);

-- --------------------------------------------------------

--
-- Structure de la table `Projet`
--

CREATE TABLE `Projet` (
  `code_pro` varchar(6) NOT NULL,
  `charge_horaire_pro` int(11) DEFAULT NULL,
  `description_pro` varchar(255) DEFAULT NULL,
  `nom_pro` varchar(45) DEFAULT NULL,
  `id_empl` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Projet`
--

INSERT INTO `Projet` (`code_pro`, `charge_horaire_pro`, `description_pro`, `nom_pro`, `id_empl`) VALUES
('P3', 70, 'Gestion des cabinets médicales', 'Cabinet', 18),
('P2', 80, 'Gestion des agences d\'assurances', 'Assurance', 18),
('P1', 80, 'Projet de gestion de comptes bancaires', 'Banque', 18),
('P4', 60, 'Gestion des absences dans une entreprise', 'Absences', 18);

-- --------------------------------------------------------

--
-- Structure de la table `Taches`
--

CREATE TABLE `Taches` (
  `id_tache` int(11) NOT NULL,
  `charge_horaire_tache` int(11) DEFAULT NULL,
  `date_debut_tache` datetime DEFAULT NULL,
  `date_fin_tache` datetime DEFAULT NULL,
  `description_tache` varchar(45) DEFAULT NULL,
  `priorite_tache` int(11) DEFAULT NULL,
  `statut_tache` varchar(10) DEFAULT NULL,
  `id_empl` int(11) DEFAULT NULL,
  `code_pro` varchar(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Taches`
--

INSERT INTO `Taches` (`id_tache`, `charge_horaire_tache`, `date_debut_tache`, `date_fin_tache`, `description_tache`, `priorite_tache`, `statut_tache`, `id_empl`, `code_pro`) VALUES
(11, 20, '2019-02-01 00:00:00', '2019-01-18 00:00:00', 'Construire une base de données', 2, 'A faire', 20, 'P3'),
(10, 10, '2019-01-01 00:00:00', '2019-01-27 00:00:00', 'Numériser les documents ', 1, 'A faire', 19, 'P3'),
(12, 10, '2019-01-04 00:00:00', '2019-01-13 00:00:00', 'cahier de charges des agencess', 1, 'A faire', 19, 'P2'),
(13, 5, '2019-01-03 00:00:00', '2019-01-08 00:00:00', 'Analyse des spécifications', 2, 'En cours', 20, 'P3');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Employe`
--
ALTER TABLE `Employe`
  ADD PRIMARY KEY (`id_empl`),
  ADD KEY `FK75hvh5dxtdy9lgh5tww0582mu` (`code_equipe`);

--
-- Index pour la table `Equipe`
--
ALTER TABLE `Equipe`
  ADD PRIMARY KEY (`code_equipe`);

--
-- Index pour la table `Projet`
--
ALTER TABLE `Projet`
  ADD PRIMARY KEY (`code_pro`),
  ADD KEY `FKmyqb3r9aun3tofdywrfoxamrp` (`id_empl`);

--
-- Index pour la table `Taches`
--
ALTER TABLE `Taches`
  ADD PRIMARY KEY (`id_tache`),
  ADD KEY `FKpvtet95644qjei6xgc5iu2emk` (`id_empl`),
  ADD KEY `FK6wl7dspmjiooj8jksdc7r0q35` (`code_pro`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Employe`
--
ALTER TABLE `Employe`
  MODIFY `id_empl` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT pour la table `Equipe`
--
ALTER TABLE `Equipe`
  MODIFY `code_equipe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `Taches`
--
ALTER TABLE `Taches`
  MODIFY `id_tache` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
