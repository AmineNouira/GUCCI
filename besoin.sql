-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 01 nov. 2018 à 22:17
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `besoin`
--

DROP TABLE IF EXISTS `besoin`;
CREATE TABLE IF NOT EXISTS `besoin` (
  `Identifiant` int(100) NOT NULL AUTO_INCREMENT,
  `Utilisateur` int(11) DEFAULT NULL,
  `Titre` varchar(30) DEFAULT NULL,
  `Description` varchar(300) DEFAULT NULL,
  `Type` varchar(10) DEFAULT NULL,
  `Affiche` varchar(200) DEFAULT NULL,
  `Date_ajout` date DEFAULT NULL,
  `Status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Identifiant`)
) ENGINE=MyISAM AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `besoin`
--

INSERT INTO `besoin` (`Identifiant`, `Utilisateur`, `Titre`, `Description`, `Type`, `Affiche`, `Date_ajout`, `Status`) VALUES
(33, 1, 'irad', 'irad', 'Money', 'C:\\Users\\amrii\\Pictures\\a.jpg', '2018-11-01', 'non resolus'),
(34, 1, 'test', 'test', 'Money', 'C:\\Users\\amrii\\Pictures\\a.jpg', '2018-11-01', 'non resolus'),
(35, 1, 'iradtest', 'irad', 'Money', 'C:\\Users\\amrii\\Pictures\\a.jpg', '2018-11-01', 'saved'),
(36, 1, 'test image upload', 'test', 'Clothes', 'C:\\Users\\amrii\\Pictures\\b.jpg', '2018-11-01', 'non resolus'),
(37, 1, 'clothes', 'GUCCI', 'Clothes', 'C:\\Users\\amrii\\Pictures\\il_570xN.1352766075_dig8.jpg', '2018-11-01', 'non resolus'),
(40, 1, 'amine', 'Nouira', 'Medicine', 'C:\\Users\\amrii\\Pictures\\a.jpg', '2018-11-01', 'non resolus'),
(39, 1, 'image view', 'display', 'other', 'C:\\Users\\amrii\\Pictures\\b.jpg', '2018-11-01', 'non resolus');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
