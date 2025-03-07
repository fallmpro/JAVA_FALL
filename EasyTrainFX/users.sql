-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 07 mars 2025 à 13:40
-- Version du serveur : 8.2.0
-- Version de PHP : 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `easytrainfx`
--

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  `prenom` text NOT NULL,
  `role` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déclencheurs `users`
--
DROP TRIGGER IF EXISTS `trg_before_insert_users`;
DELIMITER $$
CREATE TRIGGER `trg_before_insert_users` BEFORE INSERT ON `users` FOR EACH ROW BEGIN
    IF LOWER(NEW.nom) = 'test' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Le login "test" est réservé et ne peut pas être utilisé.';
    END IF;
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `trg_before_update_users`;
DELIMITER $$
CREATE TRIGGER `trg_before_update_users` BEFORE UPDATE ON `users` FOR EACH ROW BEGIN
    IF LOWER(NEW.nom) = 'test' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Le login "test" est réservé et ne peut pas être utilisé.';
    END IF;
END
$$
DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
