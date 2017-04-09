-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Dim 09 Avril 2017 à 10:28
-- Version du serveur :  5.5.54-0+deb8u1
-- Version de PHP :  5.6.30-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `build`
--

-- --------------------------------------------------------

--
-- Structure de la table `joueurs`
--

CREATE TABLE IF NOT EXISTS `joueurs` (
`ID` int(255) NOT NULL,
  `UUID` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `RANK` int(11) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `joueurs`
--

INSERT INTO `joueurs` (`ID`, `UUID`, `NAME`, `RANK`) VALUES
(15, 'e0296e92-aa12-48f3-9a7d-8a6c5b1597cb', 'coco33920', 100),
(16, 'be0c2435-8e66-40c7-9345-a589a2667ce2', 'nVidiaYT', 0),
(17, '1a575820-c2b7-4d53-8de2-69e253d356a5', 'BlackDemon64', 0),
(18, '03dad5b5-63ec-48e5-aa70-3b9ba91b61f7', 'Sarah_Pelle', 0),
(19, 'c7090bf4-41f8-4e4b-b91e-c137ec44c4d5', 'SkuzzHD', 0),
(20, '9d0e85d7-5823-4edd-b733-0c8deba64776', 'Krepuscule', 0),
(21, '134d574e-cb59-4d95-801d-a705cb723667', 'tisuisse33', 0);

-- --------------------------------------------------------

--
-- Structure de la table `variables`
--

CREATE TABLE IF NOT EXISTS `variables` (
`ID` int(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `VALEUR` int(11) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `variables`
--

INSERT INTO `variables` (`ID`, `NAME`, `VALEUR`) VALUES
(1, 'TIME_LIBRE', 421),
(2, 'TIME_IMPOSE', 301);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `joueurs`
--
ALTER TABLE `joueurs`
 ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `variables`
--
ALTER TABLE `variables`
 ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `joueurs`
--
ALTER TABLE `joueurs`
MODIFY `ID` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT pour la table `variables`
--
ALTER TABLE `variables`
MODIFY `ID` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
