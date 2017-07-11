-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 23 Juin 2017 à 11:13
-- Version du serveur :  10.1.21-MariaDB
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `mytowndb`
--

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

CREATE TABLE `account` (
  `accountId` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL,
  `professionalId` int(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `account`
--

INSERT INTO `account` (`accountId`, `username`, `password`, `isAdmin`, `professionalId`, `email`) VALUES
(1, 'toto', 'titi', 0, 1, 'test@net.fr'),
(2, 'lulu', 'paswordlulu', 1, 0, 'lulu@free.fr');

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `subCategory` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `category`
--

INSERT INTO `category` (`categoryId`, `name`, `type`, `subCategory`) VALUES
(1, 'plombier', 'travaux', ''),
(2, 'serrurier', 'travaux', ''),
(3, 'médecin', 'médical', ''),
(4, 'dentiste', 'médical', ''),
(5, 'electricien', 'travaux', ''),
(6, 'psychiatre', 'médical', '');

-- --------------------------------------------------------

--
-- Structure de la table `categorytype`
--

CREATE TABLE `categorytype` (
  `subcategoryId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Contenu de la table `categorytype`
--

INSERT INTO `categorytype` (`subcategoryId`, `name`, `description`) VALUES
(1, 'travaux', 'services de dépannage à domicile'),
(2, 'médical', 'interventions à domicile'),
(3, 'culture', 'évenements culturels et artistiques');

-- --------------------------------------------------------

--
-- Structure de la table `directory`
--

CREATE TABLE `directory` (
  `directoryId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `postalCode` varchar(255) NOT NULL,
  `town` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `lat` varchar(255) NOT NULL,
  `lng` varchar(255) NOT NULL,
  `picture` varchar(255) NOT NULL,
  `webPage` varchar(25) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Structure de la table `directoryhour`
--

CREATE TABLE `directoryhour` (
  `directoryId` int(11) NOT NULL,
  `dDay` varchar(255) NOT NULL,
  `dHour` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Structure de la table `event`
--

CREATE TABLE `event` (
  `eventId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `picture` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `postCode` varchar(255) NOT NULL,
  `town` varchar(255) NOT NULL,
  `lat` varchar(255) NOT NULL,
  `lng` varchar(255) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Structure de la table `eventhour`
--

CREATE TABLE `eventhour` (
  `eventId` int(11) NOT NULL,
  `eHour` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `professional`
--

CREATE TABLE `professional` (
  `professionalId` int(11) NOT NULL,
  `businessName` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `postCode` varchar(255) NOT NULL,
  `town` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `isConnected` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `professional`
--

INSERT INTO `professional` (`professionalId`, `businessName`, `name`, `address`, `postCode`, `town`, `category`, `phone`, `isConnected`) VALUES
(1, 'totosarl', 'totopro', 'rue de tata', '75018', 'Paris', 'plombier', '0631471984', 0);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`accountId`);

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryId`);

--
-- Index pour la table `categorytype`
--
ALTER TABLE `categorytype`
  ADD PRIMARY KEY (`subcategoryId`);

--
-- Index pour la table `directory`
--
ALTER TABLE `directory`
  ADD PRIMARY KEY (`directoryId`);

--
-- Index pour la table `directoryhour`
--
ALTER TABLE `directoryhour`
  ADD PRIMARY KEY (`directoryId`);

--
-- Index pour la table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`evenementId`);

--
-- Index pour la table `eventhour`
--
ALTER TABLE `eventhour`
  ADD PRIMARY KEY (`eventId`);

--
-- Index pour la table `professional`
--
ALTER TABLE `professional`
  ADD PRIMARY KEY (`professionalId`);
  
ALTER TABLE `account` ADD FOREIGN KEY (`professionalId`) REFERENCES `professional`(`professionalId`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `account`
--
ALTER TABLE `account`
  MODIFY `accountId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `category`
--
ALTER TABLE `category`
  MODIFY `categoryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `categorytype`
--
ALTER TABLE `categorytype`
  MODIFY `subcategoryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `directory`
--
ALTER TABLE `directory`
  MODIFY `directoryId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `event`
--
ALTER TABLE `event`
  MODIFY `evenementId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `professional`
--
ALTER TABLE `professional`
  MODIFY `professionalId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
