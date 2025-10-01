-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-04-2025 a las 21:12:51
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nba_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `erabiltzaileak`
--

CREATE TABLE `erabiltzaileak` (
  `erabiltzailea` varchar(20) NOT NULL,
  `pasahitza` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `erabiltzaileak`
--

INSERT INTO `erabiltzaileak` (`erabiltzailea`, `pasahitza`) VALUES
('danelk', 'danel123'),
('irakaslea', 'irakaslea');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estatistikak`
--

CREATE TABLE `estatistikak` (
  `id` int(11) NOT NULL,
  `jokalaria_id` int(11) DEFAULT NULL,
  `puntuak` float NOT NULL,
  `erreboteak` float NOT NULL,
  `asistentziak` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estatistikak`
--

INSERT INTO `estatistikak` (`id`, `jokalaria_id`, `puntuak`, `erreboteak`, `asistentziak`) VALUES
(1, 1, 19, 2.6, 0.3),
(2, 2, 39.2, 12.2, 3),
(3, 3, 33, 13.4, 4.9),
(4, 4, 31.1, 12.4, 5.4),
(5, 5, 18.4, 0.5, 6.6),
(6, 6, 21.2, 13.9, 1.4),
(7, 7, 24, 3.3, 5.2),
(8, 8, 11.6, 10.8, 0.2),
(9, 9, 23.4, 7.2, 3.2),
(10, 10, 0.2, 13.3, 11.7),
(11, 11, 15.3, 12.7, 9.7),
(12, 12, 0.5, 6.2, 10.7),
(13, 13, 35.6, 12.4, 11.8),
(14, 14, 32.8, 0.1, 8.7),
(15, 15, 31.6, 5.4, 5.7),
(16, 16, 11.9, 6.1, 5.9),
(17, 17, 22.2, 5.8, 3.5),
(18, 18, 4.5, 9.8, 7.2),
(19, 19, 38.1, 12.5, 11.9),
(20, 20, 3.2, 1.9, 4),
(21, 21, 21.7, 4.5, 3.8),
(22, 22, 25.3, 5.1, 4),
(23, 23, 17.2, 11.3, 2.1),
(24, 24, 12.5, 6.7, 1.3),
(25, 25, 9.8, 2.9, 6.1),
(26, 26, 26.4, 3.2, 5.7),
(27, 27, 15.6, 7.4, 1.9),
(28, 28, 18.3, 8, 3.6),
(29, 29, 22.1, 5.6, 4.8),
(30, 30, 11, 9.2, 1.5),
(31, 31, 19.7, 4.3, 6),
(32, 32, 20.2, 3.7, 4.4),
(33, 33, 16.8, 2.2, 5.9),
(34, 34, 24.5, 6.9, 2.7),
(35, 35, 13.6, 10.1, 1.4),
(36, 36, 27.8, 4.5, 3.9),
(37, 37, 14.4, 5.8, 7.2),
(38, 38, 12.3, 3.5, 4.1),
(39, 39, 10.7, 6, 3.3),
(40, 40, 28.6, 7.9, 2.6),
(41, 41, 29.3, 6.4, 4.9),
(42, 42, 11.8, 7.7, 3.2),
(43, 43, 22.5, 8.3, 2.1),
(44, 44, 16.1, 2.9, 5.4),
(45, 45, 13.7, 4.5, 6.3),
(46, 46, 26.9, 5.2, 7.1),
(47, 47, 19.5, 3.1, 4.6),
(48, 48, 20.6, 9.5, 2.7),
(49, 49, 17.3, 4, 6.9),
(50, 50, 24.8, 11.2, 1),
(51, 51, 12.9, 6.8, 5.2),
(52, 52, 8.6, 7.1, 3.3),
(53, 53, 15.2, 5.4, 4),
(54, 54, 23.9, 8.6, 6.5),
(55, 55, 18, 4.2, 2.4),
(56, 56, 10.1, 6, 7.8),
(57, 57, 27.4, 3.9, 2.6),
(58, 58, 21, 10.5, 1.7),
(59, 59, 14.8, 2.3, 5),
(60, 60, 16.5, 7.6, 3.5),
(61, 61, 23.2, 5.9, 4.4),
(62, 62, 17.7, 6.5, 3.1),
(63, 63, 21.4, 4.3, 6.6),
(64, 64, 26.3, 8.1, 2.2),
(65, 65, 19.8, 5.7, 5),
(66, 66, 14.5, 3.6, 4.9),
(67, 67, 10.6, 7, 1.6),
(68, 68, 12.1, 4.8, 3.3),
(69, 69, 25.7, 9.4, 2.5),
(70, 70, 15.9, 6.2, 4.1),
(71, 71, 29.4, 11, 3.8),
(72, 72, 8.3, 2.6, 7),
(73, 73, 13.2, 4.1, 5.7),
(74, 74, 11, 6.3, 3.5),
(75, 75, 20.3, 5, 2.9),
(76, 76, 22.9, 7.5, 4),
(77, 77, 16, 4.7, 5.6),
(78, 78, 18.4, 3.4, 2.3),
(79, 79, 24.6, 8.9, 1.8),
(80, 80, 9.2, 3.8, 6.1),
(81, 81, 13.9, 6.6, 2.5),
(82, 82, 19.6, 5.2, 4.8),
(83, 83, 23.7, 7.9, 3.4),
(84, 84, 16.2, 4.6, 6.7),
(85, 85, 21.5, 3.3, 4),
(86, 86, 10, 5.5, 7.1),
(87, 87, 26.8, 6.7, 2),
(88, 88, 18.1, 7.4, 3.6),
(89, 89, 12.4, 3.5, 5.5),
(90, 90, 14.3, 2.1, 4.7),
(91, 91, 24.2, 8.8, 2.9),
(92, 92, 20.8, 4.9, 6.3),
(93, 93, 17, 6, 5.4),
(94, 94, 22.3, 7.3, 2.1),
(95, 95, 11.4, 3, 6.8),
(96, 96, 28.5, 9.1, 1.3),
(97, 97, 15.7, 5.6, 4.2),
(98, 98, 27.1, 10.7, 3),
(99, 99, 19, 4.4, 5.1),
(100, 100, 16.9, 6.2, 4.5),
(101, 101, 25.1, 7.1, 2.4),
(102, 102, 14.8, 6, 4.9),
(103, 103, 19.4, 5.8, 3.2),
(104, 104, 17.6, 4.3, 5.7),
(105, 105, 22, 8, 1.9),
(106, 106, 10.9, 3.7, 6.5),
(107, 107, 12.7, 4.9, 3.8),
(108, 108, 18.5, 6.4, 2),
(109, 109, 21.8, 9.3, 1.6),
(110, 110, 26.6, 5.5, 4.4),
(111, 111, 15.4, 7.8, 2.8),
(112, 112, 13, 6.2, 3.9),
(113, 113, 20.4, 8.6, 1.1),
(114, 114, 16.7, 2.5, 5.3),
(115, 115, 11.5, 4.1, 7),
(116, 116, 23, 7.7, 2.3),
(117, 117, 9.3, 2.4, 5.6),
(118, 118, 27.3, 6.8, 3.5),
(119, 119, 24.1, 9.7, 1.7),
(120, 120, 8.7, 3.3, 6.2),
(121, 121, 15.6, 4.2, 5),
(122, 122, 18.7, 6.1, 3.7),
(123, 123, 23.6, 7, 2.6),
(124, 124, 13.4, 3.8, 4.3),
(125, 125, 19.1, 5.9, 3.1),
(126, 126, 16.3, 4.4, 6),
(127, 127, 14.2, 6.6, 2.2),
(128, 128, 10.3, 3.1, 5.8),
(129, 129, 25, 9.6, 1.5),
(130, 130, 12.6, 5.3, 4.7),
(131, 131, 20.5, 6.7, 3.3),
(132, 132, 11.1, 3.2, 6.9),
(133, 133, 27.6, 8.4, 2.5),
(134, 134, 17.1, 4, 5.2),
(135, 135, 22.6, 5.5, 3.4),
(136, 136, 9.6, 7.2, 2.9),
(137, 137, 8, 6.3, 4.6),
(138, 138, 24.7, 7.6, 1.8),
(139, 139, 19.9, 4.8, 5.5),
(140, 140, 21.6, 9, 2.7),
(141, 141, 14, 2.7, 6.4),
(142, 142, 26, 8.7, 3.6),
(143, 143, 13.5, 5, 4.1),
(144, 144, 3.7, 6.8, 7.4),
(145, 145, 6, 14.6, 1.9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jokalaria`
--

CREATE TABLE `jokalaria` (
  `id` int(11) NOT NULL,
  `izena` varchar(50) NOT NULL,
  `abizena` varchar(50) NOT NULL,
  `posizioa` varchar(15) NOT NULL,
  `adina` int(11) NOT NULL,
  `taldea_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jokalaria`
--

INSERT INTO `jokalaria` (`id`, `izena`, `abizena`, `posizioa`, `adina`, `taldea_id`) VALUES
(1, 'Trae', 'Young', 'Point Guard', 25, 1),
(2, 'De\'Andre', 'Hunter', 'Small Forward', 26, 1),
(3, 'John', 'Collins', 'Power Forward', 26, 1),
(4, 'Clint', 'Capela', 'Center', 29, 1),
(5, 'Dyson', 'Daniels', 'Shooting Guard', 20, 1),
(6, 'Jayson', 'Tatum', 'Small Forward', 25, 2),
(7, 'Jaylen', 'Brown', 'Shooting Guard', 27, 2),
(8, 'Derrick', 'White', 'Point Guard', 29, 2),
(9, 'Kristaps', 'Porziņģis', 'Power Forward', 28, 2),
(10, 'Al', 'Horford', 'Center', 37, 2),
(11, 'Mikal', 'Bridges', 'Small Forward', 27, 3),
(12, 'Cam', 'Thomas', 'Shooting Guard', 22, 3),
(13, 'Nic', 'Claxton', 'Center', 24, 3),
(14, 'Dorian', 'Finney-Smith', 'Small Forward', 31, 3),
(15, 'Spencer', 'Dinwiddie', 'Point Guard', 30, 3),
(16, 'LaMelo', 'Ball', 'Point Guard', 22, 4),
(17, 'Brandon', 'Miller', 'Small Forward', 21, 4),
(18, 'Miles', 'Bridges', 'Small Forward', 25, 4),
(19, 'Mark', 'Williams', 'Center', 22, 4),
(20, 'Gordon', 'Hayward', 'Small Forward', 33, 4),
(21, 'Zach', 'LaVine', 'Shooting Guard', 28, 5),
(22, 'DeMar', 'DeRozan', 'Small Forward', 34, 5),
(23, 'Nikola', 'Vucevic', 'Center', 32, 5),
(24, 'Patrick', 'Williams', 'Power Forward', 22, 5),
(25, 'Ayo', 'Dosunmu', 'Point Guard', 24, 5),
(26, 'Donovan', 'Mitchell', 'Shooting Guard', 27, 6),
(27, 'Darius', 'Garland', 'Point Guard', 24, 6),
(28, 'Evan', 'Mobley', 'Power Forward', 22, 6),
(29, 'Jarrett', 'Allen', 'Center', 25, 6),
(30, 'Isaac', 'Okoro', 'Small Forward', 23, 6),
(31, 'Cade', 'Cunningham', 'Point Guard', 22, 7),
(32, 'Jaden', 'Ivey', 'Shooting Guard', 22, 7),
(33, 'Jalen', 'Duren', 'Center', 20, 7),
(34, 'Isaiah', 'Stewart', 'Power Forward', 23, 7),
(35, 'Bojan', 'Bogdanović', 'Small Forward', 34, 7),
(36, 'Tyrese', 'Haliburton', 'Point Guard', 23, 8),
(37, 'Buddy', 'Hield', 'Shooting Guard', 30, 8),
(38, 'Myles', 'Turner', 'Center', 27, 8),
(39, 'Aaron', 'Nesmith', 'Small Forward', 24, 8),
(40, 'Jalen', 'Smith', 'Power Forward', 23, 8),
(41, 'Jimmy', 'Butler', 'Small Forward', 34, 9),
(42, 'Bam', 'Adebayo', 'Center', 26, 9),
(43, 'Tyler', 'Herro', 'Shooting Guard', 23, 9),
(44, 'Kyle', 'Lowry', 'Point Guard', 38, 9),
(45, 'Caleb', 'Martin', 'Small Forward', 28, 9),
(46, 'Giannis', 'Antetokounmpo', 'Power Forward', 29, 10),
(47, 'Jrue', 'Holiday', 'Point Guard', 34, 10),
(48, 'Khris', 'Middleton', 'Shooting Guard', 32, 10),
(49, 'Brook', 'Lopez', 'Center', 35, 10),
(50, 'Malik', 'Beasley', 'Shooting Guard', 27, 10),
(51, 'Jalen', 'Brunson', 'Point Guard', 27, 11),
(52, 'Julius', 'Randle', 'Power Forward', 29, 11),
(53, 'RJ', 'Barrett', 'Shooting Guard', 23, 11),
(54, 'Mitchell', 'Robinson', 'Center', 25, 11),
(55, 'Josh', 'Hart', 'Small Forward', 28, 11),
(56, 'Paolo', 'Banchero', 'Power Forward', 21, 12),
(57, 'Franz', 'Wagner', 'Small Forward', 22, 12),
(58, 'Jalen', 'Suggs', 'Point Guard', 22, 12),
(59, 'Wendell', 'Carter Jr.', 'Center', 24, 12),
(60, 'Markelle', 'Fultz', 'Point Guard', 25, 12),
(61, 'Joel', 'Embiid', 'Center', 29, 13),
(62, 'Tyrese', 'Maxey', 'Point Guard', 23, 13),
(63, 'James', 'Harden', 'Shooting Guard', 34, 13),
(64, 'Tobias', 'Harris', 'Small Forward', 31, 13),
(65, 'P.J.', 'Tucker', 'Power Forward', 38, 13),
(66, 'Pascal', 'Siakam', 'Power Forward', 29, 14),
(67, 'Fred', 'VanVleet', 'Point Guard', 30, 14),
(68, 'OG', 'Anunoby', 'Small Forward', 26, 14),
(69, 'Jakob', 'Poeltl', 'Center', 28, 14),
(70, 'Gary', 'Trent Jr.', 'Shooting Guard', 25, 14),
(71, 'Bradley', 'Beal', 'Shooting Guard', 30, 15),
(72, 'Kyle', 'Kuzma', 'Small Forward', 28, 15),
(73, 'Kristaps', 'Porziņģis', 'Power Forward', 28, 15),
(74, 'Daniel', 'Gafford', 'Center', 24, 15),
(75, 'Jordan', 'Poole', 'Point Guard', 24, 15),
(76, 'Kyrie', 'Irving', 'Point Guard', 31, 16),
(77, 'Tim', 'Hardaway Jr.', 'Shooting Guard', 32, 16),
(78, 'Maxi', 'Kleber', 'Power Forward', 32, 16),
(79, 'Christian', 'Wood', 'Center', 28, 16),
(80, 'Jaden', 'Ivey', 'Small Forward', 22, 16),
(81, 'Stephen', 'Curry', 'Point Guard', 35, 18),
(82, 'Klay', 'Thompson', 'Shooting Guard', 33, 18),
(83, 'Draymond', 'Green', 'Power Forward', 33, 18),
(84, 'Andrew', 'Wiggins', 'Small Forward', 28, 18),
(85, 'Kevon', 'Looney', 'Center', 29, 18),
(86, 'Jalen', 'Green', 'Shooting Guard', 22, 19),
(87, 'Kevin', 'Porter Jr.', 'Point Guard', 24, 19),
(88, 'Jabari', 'Smith Jr.', 'Power Forward', 21, 19),
(89, 'Alperen', 'Şengün', 'Center', 21, 19),
(90, 'Fred', 'VanVleet', 'Point Guard', 30, 19),
(91, 'Kawhi', 'Leonard', 'Small Forward', 33, 20),
(92, 'Paul', 'George', 'Shooting Guard', 33, 20),
(93, 'Ivica', 'Zubac', 'Center', 26, 20),
(94, 'Terance', 'Mann', 'Shooting Guard', 27, 20),
(95, 'Norman', 'Powell', 'Small Forward', 31, 20),
(96, 'LeBron', 'James', 'Small Forward', 40, 21),
(97, 'Anthony', 'Davis', 'Power Forward', 30, 21),
(98, 'Luka', 'Dončić', 'Point Guard', 25, 21),
(99, 'D’Angelo', 'Russell', 'Point Guard', 28, 21),
(100, 'Rui', 'Hachimura', 'Small Forward', 26, 21),
(101, 'Anthony', 'Edwards', 'Shooting Guard', 22, 23),
(102, 'Karl-Anthony', 'Towns', 'Center', 28, 23),
(103, 'Rudy', 'Gobert', 'Center', 31, 23),
(104, 'Jaden', 'Ivey', 'Shooting Guard', 22, 23),
(105, 'Kyle', 'Anderson', 'Small Forward', 29, 23),
(106, 'Zion', 'Williamson', 'Power Forward', 24, 24),
(107, 'Brandon', 'Ingram', 'Small Forward', 26, 24),
(108, 'CJ', 'McCollum', 'Shooting Guard', 32, 24),
(109, 'Jonas', 'Valančiūnas', 'Center', 31, 24),
(110, 'Trey', 'Murphy III', 'Small Forward', 23, 24),
(111, 'Shai', 'Gilgeous-Alexander', 'Point Guard', 25, 25),
(112, 'Josh', 'Giddey', 'Shooting Guard', 21, 25),
(113, 'Jalen', 'Williams', 'Small Forward', 23, 25),
(114, 'Chet', 'Holmgren', 'Center', 22, 25),
(115, 'Isaiah', 'Joe', 'Shooting Guard', 25, 25),
(116, 'Kevin', 'Durant', 'Small Forward', 35, 26),
(117, 'Devin', 'Booker', 'Shooting Guard', 27, 26),
(118, 'Deandre', 'Ayton', 'Center', 25, 26),
(119, 'Chris', 'Paul', 'Point Guard', 38, 26),
(120, 'Matisse', 'Thybulle', 'Shooting Guard', 26, 26),
(121, 'Damian', 'Lillard', 'Point Guard', 33, 27),
(122, 'Anfernee', 'Simons', 'Shooting Guard', 24, 27),
(123, 'Jusuf', 'Nurkić', 'Center', 28, 27),
(124, 'Jerami', 'Grant', 'Small Forward', 29, 27),
(125, 'Shadeon', 'Sharpe', 'Shooting Guard', 20, 27),
(126, 'De’Aaron', 'Fox', 'Point Guard', 26, 28),
(127, 'Domantas', 'Sabonis', 'Center', 27, 28),
(128, 'Keegan', 'Murray', 'Small Forward', 24, 28),
(129, 'Harrison', 'Barnes', 'Small Forward', 32, 28),
(130, 'Davion', 'Mitchell', 'Shooting Guard', 26, 28),
(131, 'Victor', 'Wembanyama', 'Center', 19, 29),
(132, 'Keldon', 'Johnson', 'Small Forward', 24, 29),
(133, 'Trey', 'Jones', 'Point Guard', 25, 29),
(134, 'Devin', 'Vassell', 'Shooting Guard', 24, 29),
(135, 'Zach', 'Collins', 'Power Forward', 26, 29),
(136, 'Lauri', 'Markkanen', 'Power Forward', 26, 30),
(137, 'Jordan', 'Clarkson', 'Shooting Guard', 31, 30),
(138, 'Walker', 'Kessler', 'Center', 22, 30),
(139, 'Collin', 'Sexton', 'Point Guard', 25, 30),
(140, 'Talen', 'Horton-Tucker', 'Small Forward', 23, 30),
(141, 'Ja', 'Morant', 'Point Guard', 24, 22),
(142, 'Desmond', 'Bane', 'Shooting Guard', 25, 22),
(143, 'Jaren', 'Jackson Jr.', 'Power Forward', 24, 22),
(144, 'Steven', 'Adams', 'Center', 30, 22),
(145, 'Dillon', 'Brooks', 'Small Forward', 28, 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partida`
--

CREATE TABLE `partida` (
  `id` int(11) NOT NULL,
  `bertako_taldea_id` int(11) DEFAULT NULL,
  `kanpoko_taldea_id` int(11) DEFAULT NULL,
  `bertako_puntuak` int(11) DEFAULT NULL,
  `kanpoko_puntuak` int(11) DEFAULT NULL,
  `data_partida` date DEFAULT NULL,
  `jokatuta` enum('Bai','Ez') NOT NULL DEFAULT 'Ez'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `partida`
--

INSERT INTO `partida` (`id`, `bertako_taldea_id`, `kanpoko_taldea_id`, `bertako_puntuak`, `kanpoko_puntuak`, `data_partida`, `jokatuta`) VALUES
(1, 3, 8, 112, 107, '2025-04-10', 'Bai'),
(2, 5, 1, 98, 101, '2025-04-11', 'Bai'),
(3, 6, 12, 115, 110, '2025-04-08', 'Bai'),
(4, 14, 2, 99, 87, '2025-04-09', 'Bai'),
(5, 9, 15, 104, 108, '2025-04-12', 'Bai'),
(6, 10, 7, 87, 92, '2025-04-13', 'Bai'),
(7, 4, 13, 100, 96, '2025-04-14', 'Bai'),
(8, 11, 5, 109, 113, '2025-04-15', 'Bai'),
(9, 2, 14, 95, 101, '2025-04-11', 'Bai'),
(10, 8, 6, 120, 119, '2025-04-16', 'Bai'),
(11, 1, 9, 105, 106, '2025-04-12', 'Bai'),
(12, 7, 3, 111, 109, '2025-04-14', 'Bai'),
(13, 12, 10, 97, 99, '2025-04-15', 'Bai'),
(14, 13, 11, 102, 90, '2025-04-10', 'Bai'),
(15, 15, 4, NULL, NULL, '2025-04-24', 'Ez'),
(16, 16, 19, 109, 105, '2025-04-10', 'Bai'),
(17, 18, 22, 100, 110, '2025-04-11', 'Bai'),
(18, 17, 21, 104, 101, '2025-04-12', 'Bai'),
(19, 20, 23, 112, 109, '2025-04-13', 'Bai'),
(20, 24, 28, 99, 98, '2025-04-14', 'Bai'),
(21, 25, 27, 115, 117, '2025-04-15', 'Bai'),
(22, 30, 26, NULL, NULL, '2025-04-26', 'Ez'),
(23, 29, 19, NULL, NULL, '2025-04-27', 'Ez'),
(24, 21, 30, NULL, NULL, '2025-04-28', 'Ez'),
(25, 28, 22, NULL, NULL, '2025-04-29', 'Ez'),
(26, 26, 20, NULL, NULL, '2025-04-25', 'Ez'),
(27, 27, 18, 110, 108, '2025-04-20', 'Bai'),
(28, 19, 16, 90, 87, '2025-04-21', 'Bai'),
(29, 22, 17, 112, 115, '2025-04-22', 'Bai'),
(30, 23, 25, NULL, NULL, '2025-04-30', 'Ez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `taldea`
--

CREATE TABLE `taldea` (
  `id` int(10) NOT NULL,
  `izena` varchar(50) NOT NULL,
  `hiria` varchar(50) NOT NULL,
  `entrenatzailea` varchar(15) NOT NULL,
  `conference` enum('Eastern','Western') NOT NULL,
  `estadioa` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `taldea`
--

INSERT INTO `taldea` (`id`, `izena`, `hiria`, `entrenatzailea`, `conference`, `estadioa`) VALUES
(1, 'Hawks', 'Atlanta', 'Quin Snyder', 'Eastern', 'State Farm Arena'),
(2, 'Celtics', 'Boston', 'Joe Mazzulla', 'Eastern', 'TD Garden'),
(3, 'Nets', 'Brooklyn', 'Jordi Fernández', 'Eastern', 'Barclays Center'),
(4, 'Hornets', 'Charlotte', 'Steve Clifford', 'Eastern', 'Spectrum Center'),
(5, 'Bulls', 'Chicago', 'Billy Donovan', 'Eastern', 'United Center'),
(6, 'Cavaliers', 'Cleveland', 'J.B. Bickerstaf', 'Eastern', 'Rocket Mortgage Fiel'),
(7, 'Pistons', 'Detroit', 'Monty Williams', 'Eastern', 'Little Caesars Arena'),
(8, 'Pacers', 'Indianapolis', 'Rick Carlisle', 'Eastern', 'Gainbridge Fieldhous'),
(9, 'Heat', 'Miami', 'Erik Spoelstra', 'Eastern', 'Kaseya Center'),
(10, 'Bucks', 'Milwaukee', 'Doc Rivers', 'Eastern', 'Fiserv Forum'),
(11, 'Knicks', 'New York', 'Tom Thibodeau', 'Eastern', 'Madison Square Garde'),
(12, 'Magic', 'Orlando', 'Jamahl Mosley', 'Eastern', 'Kia Center'),
(13, '76ers', 'Philadelphia', 'Nick Nurse', 'Eastern', 'Wells Fargo Center'),
(14, 'Raptors', 'Toronto', 'Darko Rajaković', 'Eastern', 'Scotiabank Arena'),
(15, 'Wizards', 'Washington D.C.', 'Brian Keefe', 'Eastern', 'Capital One Arena'),
(16, 'Mavericks', 'Dallas', 'Jason Kidd', 'Western', 'American Airlines Ce'),
(17, 'Nuggets', 'Denver', 'Michael Malone', 'Western', 'Ball Arena'),
(18, 'Warriors', 'San Francisco', 'Steve Kerr', 'Western', 'Chase Center'),
(19, 'Rockets', 'Houston', 'Ime Udoka', 'Western', 'Toyota Center'),
(20, 'Clippers', 'Los Angeles', 'Tyronn Lue', 'Western', 'Intuit Dome'),
(21, 'Lakers', 'Los Angeles', 'Darvin Ham', 'Western', 'Crypto.com Arena'),
(22, 'Grizzlies', 'Memphis', 'Taylor Jenkins', 'Western', 'FedExForum'),
(23, 'Timberwolves', 'Minneapolis', 'Chris Finch', 'Western', 'Target Center'),
(24, 'Pelicans', 'New Orleans', 'Willie Green', 'Western', 'Smoothie King Center'),
(25, 'Thunder', 'Oklahoma City', 'Mark Daigneault', 'Western', 'Paycom Center'),
(26, 'Suns', 'Phoenix', 'Frank Vogel', 'Western', 'Footprint Center'),
(27, 'Trail Blazers', 'Portland', 'Chauncey Billup', 'Western', 'Moda Center'),
(28, 'Kings', 'Sacramento', 'Mike Brown', 'Western', 'Golden 1 Center'),
(29, 'Spurs', 'San Antonio', 'Gregg Popovich', 'Western', 'Frost Bank Center'),
(30, 'Utah Jazz', 'Salt Lake City', 'Will Hardy', 'Western', 'Delta Center');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `erabiltzaileak`
--
ALTER TABLE `erabiltzaileak`
  ADD PRIMARY KEY (`erabiltzailea`);

--
-- Indices de la tabla `estatistikak`
--
ALTER TABLE `estatistikak`
  ADD PRIMARY KEY (`id`),
  ADD KEY `jokalaria_id` (`jokalaria_id`);

--
-- Indices de la tabla `jokalaria`
--
ALTER TABLE `jokalaria`
  ADD PRIMARY KEY (`id`),
  ADD KEY `taldea_id` (`taldea_id`);

--
-- Indices de la tabla `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bertako_taldea_id` (`bertako_taldea_id`),
  ADD KEY `kanpoko_taldea_id` (`kanpoko_taldea_id`);

--
-- Indices de la tabla `taldea`
--
ALTER TABLE `taldea`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estatistikak`
--
ALTER TABLE `estatistikak`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=146;

--
-- AUTO_INCREMENT de la tabla `jokalaria`
--
ALTER TABLE `jokalaria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=146;

--
-- AUTO_INCREMENT de la tabla `partida`
--
ALTER TABLE `partida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `estatistikak`
--
ALTER TABLE `estatistikak`
  ADD CONSTRAINT `estatistikak_ibfk_1` FOREIGN KEY (`jokalaria_id`) REFERENCES `jokalaria` (`id`);

--
-- Filtros para la tabla `jokalaria`
--
ALTER TABLE `jokalaria`
  ADD CONSTRAINT `jokalaria_ibfk_1` FOREIGN KEY (`taldea_id`) REFERENCES `taldea` (`id`);

--
-- Filtros para la tabla `partida`
--
ALTER TABLE `partida`
  ADD CONSTRAINT `partida_ibfk_1` FOREIGN KEY (`bertako_taldea_id`) REFERENCES `taldea` (`id`),
  ADD CONSTRAINT `partida_ibfk_2` FOREIGN KEY (`kanpoko_taldea_id`) REFERENCES `taldea` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
