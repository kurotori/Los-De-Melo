-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-03-2019 a las 00:44:55
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `systurno`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asociado`
--

CREATE TABLE `asociado` (
  `turnos_ID` int(11) NOT NULL,
  `recetas_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contiene`
--

CREATE TABLE `contiene` (
  `medicamentos_ID` int(11) NOT NULL,
  `cantidad` int(3) DEFAULT NULL,
  `entregado` tinyint(1) NOT NULL,
  `recetas_ID` int(11) NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `contiene`
--

INSERT INTO `contiene` (`medicamentos_ID`, `cantidad`, `entregado`, `recetas_ID`, `ID`) VALUES
(190871081, 10, 0, 1, 1),
(740872794, 20, 1, 2, 2),
(603842013, 25, 0, 3, 3),
(129780488, 5, 0, 4, 4),
(690926960, 5, 0, 1, 5),
(420804140, 6, 0, 2, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctores`
--

CREATE TABLE `doctores` (
  `CI` int(8) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Telefono` varchar(12) NOT NULL,
  `email` varchar(45) NOT NULL,
  `sal` varchar(65) NOT NULL,
  `hash` varchar(32) NOT NULL,
  `Especialidad` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `doctores`
--

INSERT INTO `doctores` (`CI`, `Nombre`, `Apellido`, `Telefono`, `email`, `sal`, `hash`, `Especialidad`) VALUES
(87654321, 'Fulanito', 'de tal', '45454545454', 'asdfasdfasfda', 'aasdfasdfasdfadsf', 'adsfadfasdfasdfadsf', 'Gastroenterólogo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrega`
--

CREATE TABLE `entrega` (
  `Doctores_CI` int(8) NOT NULL,
  `recetas_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `entrega`
--

INSERT INTO `entrega` (`Doctores_CI`, `recetas_ID`) VALUES
(87654321, 1),
(87654321, 2),
(87654321, 3),
(87654321, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genera`
--

CREATE TABLE `genera` (
  `CI_usuario` int(8) NOT NULL,
  `ID_turno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inicia`
--

CREATE TABLE `inicia` (
  `Ci_usuario` int(8) NOT NULL,
  `ID_sesion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `inicia`
--

INSERT INTO `inicia` (`Ci_usuario`, `ID_sesion`) VALUES
(12345678, 29),
(12345678, 30),
(12345678, 31),
(12345678, 32),
(12345678, 33),
(12345678, 34),
(12345678, 35),
(12345678, 36),
(12345678, 37),
(12345678, 38),
(12345678, 39),
(12345678, 40),
(12345678, 41),
(12345678, 42),
(12345678, 43),
(12345678, 44),
(12345678, 45),
(12345678, 46),
(12345678, 47),
(12345678, 48),
(12345678, 49),
(12345678, 50),
(12345678, 51),
(12345678, 52),
(12345678, 53),
(12345678, 54),
(12345678, 55),
(12345678, 56),
(12345678, 57),
(12345678, 58),
(12345678, 59),
(12345678, 60),
(45751220, 10),
(45751220, 11),
(45751220, 12),
(45751220, 13),
(45751220, 14),
(45751220, 23),
(45751220, 27),
(45751220, 28),
(45751221, 8),
(45751221, 9),
(45751221, 15),
(45751221, 16),
(45751221, 17),
(45751221, 18),
(45751221, 19),
(45751221, 20),
(45751221, 21),
(45751221, 22),
(45751221, 24),
(45751221, 25),
(45751221, 26);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamentos`
--

CREATE TABLE `medicamentos` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `laboratorio` varchar(30) NOT NULL,
  `principio` varchar(50) NOT NULL,
  `presentacion` varchar(30) NOT NULL,
  `controlado` tinyint(1) NOT NULL,
  `stock` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `medicamentos`
--

INSERT INTO `medicamentos` (`ID`, `Nombre`, `laboratorio`, `principio`, `presentacion`, `controlado`, `stock`) VALUES
(129780488, 'HUMIRA', 'AGUETTANT', 'Flunisolida', '200 ml', 0, 2),
(190871081, 'ACETADOTE', 'AGUETTANT', 'Anagrelida', '200 ml', 1, 35),
(244322131, 'SECTRAL', 'IRISFARMA, S.A.', 'Pioglitazona', 'blister x 10', 0, 0),
(387581905, 'ZIAGEN', 'AGFA HEALTHCARE NV', 'Aripiprazol', 'blister x 10', 0, 20),
(401219585, 'ZOVIRAX', 'AIR LIQUIDE MEDICINAL', 'Tirofibán', 'blister x 10', 0, 0),
(417182822, 'HEPSERA', 'AIR LIQUIDE MEDICINAL', 'Salmeterol', '200 ml', 0, 20),
(420804140, 'PRECOSE', 'ALCON', 'Alclometasona', '200 ml', 0, 0),
(424455265, 'ALBENZA', 'AGUETTANT', 'Pseudoefedrina', 'blister x 10', 0, 0),
(459896864, 'SORIATANE', 'IRISFARMA, S.A.', 'Oximetazolina', '200 ml', 0, 20),
(485601565, 'DIFFERIN', 'IRISFARMA, S.A.', 'Adenosina', 'blister x 10', 1, 5),
(527740226, 'ORENCIA', 'AGUETTANT', 'Paclitaxel', '200 ml', 0, 20),
(577446509, 'REOPRO', 'AIR LIQUIDE MEDICINAL', 'Zafirlukast', 'blister x 10', 0, 10),
(603842013, 'TYLENOL', 'IRISFARMA, S.A.', 'Ketorolaco', '200 ml', 0, 5),
(690926960, 'DIAMOX', 'AIR LIQUIDE MEDICINAL', 'Amprenavir', 'blister x 10', 1, 30),
(740872794, 'ACTH', 'AGUETTANT', 'Pemirolast', 'blister x 10', 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recetas`
--

CREATE TABLE `recetas` (
  `ID` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `recetas`
--

INSERT INTO `recetas` (`ID`, `fecha`) VALUES
(1, '2019-03-15'),
(2, '2019-03-15'),
(3, '2019-02-24'),
(4, '2019-01-16');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibe`
--

CREATE TABLE `recibe` (
  `Usuarios_CI` int(8) NOT NULL,
  `recetas_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `recibe`
--

INSERT INTO `recibe` (`Usuarios_CI`, `recetas_ID`) VALUES
(12345678, 1),
(12345678, 2),
(12345678, 3),
(45751220, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesiones`
--

CREATE TABLE `sesiones` (
  `ID` int(11) NOT NULL,
  `fechahora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `estado` enum('activa','cerrada') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sesiones`
--

INSERT INTO `sesiones` (`ID`, `fechahora`, `estado`) VALUES
(1, '2019-03-06 02:07:12', 'cerrada'),
(2, '2019-03-06 02:19:13', 'cerrada'),
(3, '2019-03-06 02:20:02', 'cerrada'),
(4, '2019-03-06 02:22:31', 'cerrada'),
(5, '2019-03-06 02:23:07', 'cerrada'),
(6, '2019-03-06 02:24:46', 'cerrada'),
(7, '2019-03-06 02:24:56', 'cerrada'),
(8, '2019-03-06 03:02:35', 'cerrada'),
(9, '2019-03-08 01:24:24', 'cerrada'),
(10, '2019-03-08 01:24:25', 'cerrada'),
(11, '2019-03-08 01:24:55', 'cerrada'),
(12, '2019-03-08 01:24:57', 'cerrada'),
(13, '2019-03-08 01:24:58', 'cerrada'),
(14, '2019-03-08 01:25:00', 'cerrada'),
(15, '2019-03-08 01:25:11', 'cerrada'),
(16, '2019-03-08 01:25:13', 'cerrada'),
(17, '2019-03-08 01:25:17', 'cerrada'),
(18, '2019-03-08 01:25:18', 'cerrada'),
(19, '2019-03-08 01:25:19', 'cerrada'),
(20, '2019-03-08 01:25:20', 'cerrada'),
(21, '2019-03-08 01:53:31', 'cerrada'),
(22, '2019-03-08 01:54:29', 'cerrada'),
(23, '2019-03-08 02:19:51', 'activa'),
(24, '2019-03-10 19:28:09', 'activa'),
(25, '2019-03-10 19:28:19', 'activa'),
(26, '2019-03-10 19:28:36', 'activa'),
(27, '2019-03-10 20:09:38', 'activa'),
(28, '2019-03-10 20:31:17', 'activa'),
(29, '2019-03-15 01:47:11', 'activa'),
(30, '2019-03-15 01:49:48', 'activa'),
(31, '2019-03-15 01:52:15', 'activa'),
(32, '2019-03-15 22:04:17', 'activa'),
(33, '2019-03-15 22:32:01', 'cerrada'),
(34, '2019-03-15 22:33:24', 'cerrada'),
(35, '2019-03-16 01:28:14', 'activa'),
(36, '2019-03-18 00:06:09', 'activa'),
(37, '2019-03-18 00:07:43', 'activa'),
(38, '2019-03-18 00:24:26', 'activa'),
(39, '2019-03-18 00:42:08', 'activa'),
(40, '2019-03-18 01:00:29', 'activa'),
(41, '2019-03-18 01:05:27', 'activa'),
(42, '2019-03-18 01:08:46', 'activa'),
(43, '2019-03-18 01:11:17', 'activa'),
(44, '2019-03-18 01:19:48', 'activa'),
(45, '2019-03-18 01:22:56', 'activa'),
(46, '2019-03-18 01:24:57', 'activa'),
(47, '2019-03-18 01:25:47', 'activa'),
(48, '2019-03-18 01:26:52', 'cerrada'),
(49, '2019-03-18 01:54:39', 'cerrada'),
(50, '2019-03-18 02:04:26', 'cerrada'),
(51, '2019-03-18 02:09:16', 'cerrada'),
(52, '2019-03-18 23:48:43', 'cerrada'),
(53, '2019-03-18 23:51:37', 'cerrada'),
(54, '2019-03-18 23:58:32', 'activa'),
(55, '2019-03-19 00:28:24', 'activa'),
(56, '2019-03-19 00:51:12', 'cerrada'),
(57, '2019-03-19 00:51:59', 'cerrada'),
(58, '2019-03-19 00:58:57', 'cerrada'),
(59, '2019-03-19 01:09:47', 'cerrada'),
(60, '2019-03-19 01:10:37', 'cerrada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turnos`
--

CREATE TABLE `turnos` (
  `ID` int(11) NOT NULL,
  `fechahora` datetime NOT NULL,
  `estado` enum('confirmado','cancelado','usado','abierto') NOT NULL DEFAULT 'abierto'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `turnos`
--

INSERT INTO `turnos` (`ID`, `fechahora`, `estado`) VALUES
(1, '2019-03-25 08:00:00', 'abierto'),
(2, '2019-03-25 08:10:00', 'abierto'),
(3, '2019-03-25 08:20:00', 'abierto'),
(4, '2019-03-25 08:30:00', 'abierto'),
(5, '2019-03-25 08:40:00', 'abierto'),
(6, '2019-03-25 08:50:00', 'abierto'),
(7, '2019-03-25 09:00:00', 'abierto'),
(8, '2019-03-25 09:10:00', 'abierto'),
(9, '2019-03-25 09:20:00', 'abierto'),
(10, '2019-03-25 09:30:00', 'abierto'),
(11, '2019-03-25 09:40:00', 'abierto'),
(12, '2019-03-25 09:50:00', 'abierto'),
(13, '2019-03-25 10:00:00', 'abierto'),
(14, '2019-03-25 10:10:00', 'abierto'),
(15, '2019-03-25 10:20:00', 'abierto'),
(16, '2019-03-25 10:30:00', 'abierto'),
(17, '2019-03-25 10:40:00', 'abierto'),
(18, '2019-03-25 10:50:00', 'abierto'),
(19, '2019-03-25 11:00:00', 'abierto'),
(20, '2019-03-25 11:10:00', 'abierto'),
(21, '2019-03-25 11:20:00', 'abierto'),
(22, '2019-03-25 11:30:00', 'abierto'),
(23, '2019-03-25 11:40:00', 'abierto'),
(24, '2019-03-25 11:50:00', 'abierto'),
(25, '2019-03-25 12:00:00', 'abierto'),
(26, '2019-03-25 14:00:00', 'abierto'),
(27, '2019-03-25 14:10:00', 'abierto'),
(28, '2019-03-25 14:20:00', 'abierto'),
(29, '2019-03-25 14:30:00', 'abierto'),
(30, '2019-03-25 14:40:00', 'abierto'),
(31, '2019-03-25 14:50:00', 'abierto'),
(32, '2019-03-25 15:00:00', 'abierto'),
(33, '2019-03-25 15:10:00', 'abierto'),
(34, '2019-03-25 15:20:00', 'abierto'),
(35, '2019-03-25 15:30:00', 'abierto'),
(36, '2019-03-25 15:40:00', 'abierto'),
(37, '2019-03-25 15:50:00', 'abierto'),
(38, '2019-03-25 16:00:00', 'abierto'),
(39, '2019-03-25 16:10:00', 'abierto'),
(40, '2019-03-25 16:20:00', 'abierto'),
(41, '2019-03-25 16:30:00', 'abierto'),
(42, '2019-03-25 16:40:00', 'abierto'),
(43, '2019-03-25 16:50:00', 'abierto'),
(44, '2019-03-25 17:00:00', 'abierto'),
(45, '2019-03-25 17:10:00', 'abierto'),
(46, '2019-03-25 17:20:00', 'abierto'),
(47, '2019-03-25 17:30:00', 'abierto'),
(48, '2019-03-25 17:40:00', 'abierto'),
(49, '2019-03-25 17:50:00', 'abierto'),
(50, '2019-03-25 18:00:00', 'abierto'),
(51, '2019-03-25 18:10:00', 'abierto'),
(52, '2019-03-25 18:20:00', 'abierto'),
(53, '2019-03-25 18:30:00', 'abierto'),
(54, '2019-03-25 18:40:00', 'abierto'),
(55, '2019-03-25 18:50:00', 'abierto'),
(56, '2019-03-25 19:00:00', 'abierto'),
(57, '2019-03-26 08:00:00', 'abierto'),
(58, '2019-03-26 08:10:00', 'abierto'),
(59, '2019-03-26 08:20:00', 'abierto'),
(60, '2019-03-26 08:30:00', 'abierto'),
(61, '2019-03-26 08:40:00', 'abierto'),
(62, '2019-03-26 08:50:00', 'abierto'),
(63, '2019-03-26 09:00:00', 'abierto'),
(64, '2019-03-26 09:10:00', 'abierto'),
(65, '2019-03-26 09:20:00', 'abierto'),
(66, '2019-03-26 09:30:00', 'abierto'),
(67, '2019-03-26 09:40:00', 'abierto'),
(68, '2019-03-26 09:50:00', 'abierto'),
(69, '2019-03-26 10:00:00', 'abierto'),
(70, '2019-03-26 10:10:00', 'abierto'),
(71, '2019-03-26 10:20:00', 'abierto'),
(72, '2019-03-26 10:30:00', 'abierto'),
(73, '2019-03-26 10:40:00', 'abierto'),
(74, '2019-03-26 10:50:00', 'abierto'),
(75, '2019-03-26 11:00:00', 'abierto'),
(76, '2019-03-26 11:10:00', 'abierto'),
(77, '2019-03-26 11:20:00', 'abierto'),
(78, '2019-03-26 11:30:00', 'abierto'),
(79, '2019-03-26 11:40:00', 'abierto'),
(80, '2019-03-26 11:50:00', 'abierto'),
(81, '2019-03-26 12:00:00', 'abierto'),
(82, '2019-03-26 14:00:00', 'abierto'),
(83, '2019-03-26 14:10:00', 'abierto'),
(84, '2019-03-26 14:20:00', 'abierto'),
(85, '2019-03-26 14:30:00', 'abierto'),
(86, '2019-03-26 14:40:00', 'abierto'),
(87, '2019-03-26 14:50:00', 'abierto'),
(88, '2019-03-26 15:00:00', 'abierto'),
(89, '2019-03-26 15:10:00', 'abierto'),
(90, '2019-03-26 15:20:00', 'abierto'),
(91, '2019-03-26 15:30:00', 'abierto'),
(92, '2019-03-26 15:40:00', 'abierto'),
(93, '2019-03-26 15:50:00', 'abierto'),
(94, '2019-03-26 16:00:00', 'abierto'),
(95, '2019-03-26 16:10:00', 'abierto'),
(96, '2019-03-26 16:20:00', 'abierto'),
(97, '2019-03-26 16:30:00', 'abierto'),
(98, '2019-03-26 16:40:00', 'abierto'),
(99, '2019-03-26 16:50:00', 'abierto'),
(100, '2019-03-26 17:00:00', 'abierto'),
(101, '2019-03-26 17:10:00', 'abierto'),
(102, '2019-03-26 17:20:00', 'abierto'),
(103, '2019-03-26 17:30:00', 'abierto'),
(104, '2019-03-26 17:40:00', 'abierto'),
(105, '2019-03-26 17:50:00', 'abierto'),
(106, '2019-03-26 18:00:00', 'abierto'),
(107, '2019-03-26 18:10:00', 'abierto'),
(108, '2019-03-26 18:20:00', 'abierto'),
(109, '2019-03-26 18:30:00', 'abierto'),
(110, '2019-03-26 18:40:00', 'abierto'),
(111, '2019-03-26 18:50:00', 'abierto'),
(112, '2019-03-26 19:00:00', 'abierto'),
(113, '2019-03-27 08:00:00', 'abierto'),
(114, '2019-03-27 08:10:00', 'abierto'),
(115, '2019-03-27 08:20:00', 'abierto'),
(116, '2019-03-27 08:30:00', 'abierto'),
(117, '2019-03-27 08:40:00', 'abierto'),
(118, '2019-03-27 08:50:00', 'abierto'),
(119, '2019-03-27 09:00:00', 'abierto'),
(120, '2019-03-27 09:10:00', 'abierto'),
(121, '2019-03-27 09:20:00', 'abierto'),
(122, '2019-03-27 09:30:00', 'abierto'),
(123, '2019-03-27 09:40:00', 'abierto'),
(124, '2019-03-27 09:50:00', 'abierto'),
(125, '2019-03-27 10:00:00', 'abierto'),
(126, '2019-03-27 10:10:00', 'abierto'),
(127, '2019-03-27 10:20:00', 'abierto'),
(128, '2019-03-27 10:30:00', 'abierto'),
(129, '2019-03-27 10:40:00', 'abierto'),
(130, '2019-03-27 10:50:00', 'abierto'),
(131, '2019-03-27 11:00:00', 'abierto'),
(132, '2019-03-27 11:10:00', 'abierto'),
(133, '2019-03-27 11:20:00', 'abierto'),
(134, '2019-03-27 11:30:00', 'abierto'),
(135, '2019-03-27 11:40:00', 'abierto'),
(136, '2019-03-27 11:50:00', 'abierto'),
(137, '2019-03-27 12:00:00', 'abierto'),
(138, '2019-03-27 14:00:00', 'abierto'),
(139, '2019-03-27 14:10:00', 'abierto'),
(140, '2019-03-27 14:20:00', 'abierto'),
(141, '2019-03-27 14:30:00', 'abierto'),
(142, '2019-03-27 14:40:00', 'abierto'),
(143, '2019-03-27 14:50:00', 'abierto'),
(144, '2019-03-27 15:00:00', 'abierto'),
(145, '2019-03-27 15:10:00', 'abierto'),
(146, '2019-03-27 15:20:00', 'abierto'),
(147, '2019-03-27 15:30:00', 'abierto'),
(148, '2019-03-27 15:40:00', 'abierto'),
(149, '2019-03-27 15:50:00', 'abierto'),
(150, '2019-03-27 16:00:00', 'abierto'),
(151, '2019-03-27 16:10:00', 'abierto'),
(152, '2019-03-27 16:20:00', 'abierto'),
(153, '2019-03-27 16:30:00', 'abierto'),
(154, '2019-03-27 16:40:00', 'abierto'),
(155, '2019-03-27 16:50:00', 'abierto'),
(156, '2019-03-27 17:00:00', 'abierto'),
(157, '2019-03-27 17:10:00', 'abierto'),
(158, '2019-03-27 17:20:00', 'abierto'),
(159, '2019-03-27 17:30:00', 'abierto'),
(160, '2019-03-27 17:40:00', 'abierto'),
(161, '2019-03-27 17:50:00', 'abierto'),
(162, '2019-03-27 18:00:00', 'abierto'),
(163, '2019-03-27 18:10:00', 'abierto'),
(164, '2019-03-27 18:20:00', 'abierto'),
(165, '2019-03-27 18:30:00', 'abierto'),
(166, '2019-03-27 18:40:00', 'abierto'),
(167, '2019-03-27 18:50:00', 'abierto'),
(168, '2019-03-27 19:00:00', 'abierto'),
(169, '2019-03-28 08:00:00', 'abierto'),
(170, '2019-03-28 08:10:00', 'abierto'),
(171, '2019-03-28 08:20:00', 'abierto'),
(172, '2019-03-28 08:30:00', 'abierto'),
(173, '2019-03-28 08:40:00', 'abierto'),
(174, '2019-03-28 08:50:00', 'abierto'),
(175, '2019-03-28 09:00:00', 'abierto'),
(176, '2019-03-28 09:10:00', 'abierto'),
(177, '2019-03-28 09:20:00', 'abierto'),
(178, '2019-03-28 09:30:00', 'abierto'),
(179, '2019-03-28 09:40:00', 'abierto'),
(180, '2019-03-28 09:50:00', 'abierto'),
(181, '2019-03-28 10:00:00', 'abierto'),
(182, '2019-03-28 10:10:00', 'abierto'),
(183, '2019-03-28 10:20:00', 'abierto'),
(184, '2019-03-28 10:30:00', 'abierto'),
(185, '2019-03-28 10:40:00', 'abierto'),
(186, '2019-03-28 10:50:00', 'abierto'),
(187, '2019-03-28 11:00:00', 'abierto'),
(188, '2019-03-28 11:10:00', 'abierto'),
(189, '2019-03-28 11:20:00', 'abierto'),
(190, '2019-03-28 11:30:00', 'abierto'),
(191, '2019-03-28 11:40:00', 'abierto'),
(192, '2019-03-28 11:50:00', 'abierto'),
(193, '2019-03-28 12:00:00', 'abierto'),
(194, '2019-03-28 14:00:00', 'abierto'),
(195, '2019-03-28 14:10:00', 'abierto'),
(196, '2019-03-28 14:20:00', 'abierto'),
(197, '2019-03-28 14:30:00', 'abierto'),
(198, '2019-03-28 14:40:00', 'abierto'),
(199, '2019-03-28 14:50:00', 'abierto'),
(200, '2019-03-28 15:00:00', 'abierto'),
(201, '2019-03-28 15:10:00', 'abierto'),
(202, '2019-03-28 15:20:00', 'abierto'),
(203, '2019-03-28 15:30:00', 'abierto'),
(204, '2019-03-28 15:40:00', 'abierto'),
(205, '2019-03-28 15:50:00', 'abierto'),
(206, '2019-03-28 16:00:00', 'abierto'),
(207, '2019-03-28 16:10:00', 'abierto'),
(208, '2019-03-28 16:20:00', 'abierto'),
(209, '2019-03-28 16:30:00', 'abierto'),
(210, '2019-03-28 16:40:00', 'abierto'),
(211, '2019-03-28 16:50:00', 'abierto'),
(212, '2019-03-28 17:00:00', 'abierto'),
(213, '2019-03-28 17:10:00', 'abierto'),
(214, '2019-03-28 17:20:00', 'abierto'),
(215, '2019-03-28 17:30:00', 'abierto'),
(216, '2019-03-28 17:40:00', 'abierto'),
(217, '2019-03-28 17:50:00', 'abierto'),
(218, '2019-03-28 18:00:00', 'abierto'),
(219, '2019-03-28 18:10:00', 'abierto'),
(220, '2019-03-28 18:20:00', 'abierto'),
(221, '2019-03-28 18:30:00', 'abierto'),
(222, '2019-03-28 18:40:00', 'abierto'),
(223, '2019-03-28 18:50:00', 'abierto'),
(224, '2019-03-28 19:00:00', 'abierto'),
(225, '2019-03-29 08:00:00', 'abierto'),
(226, '2019-03-29 08:10:00', 'abierto'),
(227, '2019-03-29 08:20:00', 'abierto'),
(228, '2019-03-29 08:30:00', 'abierto'),
(229, '2019-03-29 08:40:00', 'abierto'),
(230, '2019-03-29 08:50:00', 'abierto'),
(231, '2019-03-29 09:00:00', 'abierto'),
(232, '2019-03-29 09:10:00', 'abierto'),
(233, '2019-03-29 09:20:00', 'abierto'),
(234, '2019-03-29 09:30:00', 'abierto'),
(235, '2019-03-29 09:40:00', 'abierto'),
(236, '2019-03-29 09:50:00', 'abierto'),
(237, '2019-03-29 10:00:00', 'abierto'),
(238, '2019-03-29 10:10:00', 'abierto'),
(239, '2019-03-29 10:20:00', 'abierto'),
(240, '2019-03-29 10:30:00', 'abierto'),
(241, '2019-03-29 10:40:00', 'abierto'),
(242, '2019-03-29 10:50:00', 'abierto'),
(243, '2019-03-29 11:00:00', 'abierto'),
(244, '2019-03-29 11:10:00', 'abierto'),
(245, '2019-03-29 11:20:00', 'abierto'),
(246, '2019-03-29 11:30:00', 'abierto'),
(247, '2019-03-29 11:40:00', 'abierto'),
(248, '2019-03-29 11:50:00', 'abierto'),
(249, '2019-03-29 12:00:00', 'abierto'),
(250, '2019-03-29 14:00:00', 'abierto'),
(251, '2019-03-29 14:10:00', 'abierto'),
(252, '2019-03-29 14:20:00', 'abierto'),
(253, '2019-03-29 14:30:00', 'abierto'),
(254, '2019-03-29 14:40:00', 'abierto'),
(255, '2019-03-29 14:50:00', 'abierto'),
(256, '2019-03-29 15:00:00', 'abierto'),
(257, '2019-03-29 15:10:00', 'abierto'),
(258, '2019-03-29 15:20:00', 'abierto'),
(259, '2019-03-29 15:30:00', 'abierto'),
(260, '2019-03-29 15:40:00', 'abierto'),
(261, '2019-03-29 15:50:00', 'abierto'),
(262, '2019-03-29 16:00:00', 'abierto'),
(263, '2019-03-29 16:10:00', 'abierto'),
(264, '2019-03-29 16:20:00', 'abierto'),
(265, '2019-03-29 16:30:00', 'abierto'),
(266, '2019-03-29 16:40:00', 'abierto'),
(267, '2019-03-29 16:50:00', 'abierto'),
(268, '2019-03-29 17:00:00', 'abierto'),
(269, '2019-03-29 17:10:00', 'abierto'),
(270, '2019-03-29 17:20:00', 'abierto'),
(271, '2019-03-29 17:30:00', 'abierto'),
(272, '2019-03-29 17:40:00', 'abierto'),
(273, '2019-03-29 17:50:00', 'abierto'),
(274, '2019-03-29 18:00:00', 'abierto'),
(275, '2019-03-29 18:10:00', 'abierto'),
(276, '2019-03-29 18:20:00', 'abierto'),
(277, '2019-03-29 18:30:00', 'abierto'),
(278, '2019-03-29 18:40:00', 'abierto'),
(279, '2019-03-29 18:50:00', 'abierto'),
(280, '2019-03-29 19:00:00', 'abierto'),
(281, '2019-03-30 08:00:00', 'abierto'),
(282, '2019-03-30 08:10:00', 'abierto'),
(283, '2019-03-30 08:20:00', 'abierto'),
(284, '2019-03-30 08:30:00', 'abierto'),
(285, '2019-03-30 08:40:00', 'abierto'),
(286, '2019-03-30 08:50:00', 'abierto'),
(287, '2019-03-30 09:00:00', 'abierto'),
(288, '2019-03-30 09:10:00', 'abierto'),
(289, '2019-03-30 09:20:00', 'abierto'),
(290, '2019-03-30 09:30:00', 'abierto'),
(291, '2019-03-30 09:40:00', 'abierto'),
(292, '2019-03-30 09:50:00', 'abierto'),
(293, '2019-03-30 10:00:00', 'abierto'),
(294, '2019-03-30 10:10:00', 'abierto'),
(295, '2019-03-30 10:20:00', 'abierto'),
(296, '2019-03-30 10:30:00', 'abierto'),
(297, '2019-03-30 10:40:00', 'abierto'),
(298, '2019-03-30 10:50:00', 'abierto'),
(299, '2019-03-30 11:00:00', 'abierto'),
(300, '2019-03-30 11:10:00', 'abierto'),
(301, '2019-03-30 11:20:00', 'abierto'),
(302, '2019-03-30 11:30:00', 'abierto'),
(303, '2019-03-30 11:40:00', 'abierto'),
(304, '2019-03-30 11:50:00', 'abierto'),
(305, '2019-03-30 12:00:00', 'abierto'),
(306, '2019-03-30 14:00:00', 'abierto'),
(307, '2019-03-30 14:10:00', 'abierto'),
(308, '2019-03-30 14:20:00', 'abierto'),
(309, '2019-03-30 14:30:00', 'abierto'),
(310, '2019-03-30 14:40:00', 'abierto'),
(311, '2019-03-30 14:50:00', 'abierto'),
(312, '2019-03-30 15:00:00', 'abierto'),
(313, '2019-03-30 15:10:00', 'abierto'),
(314, '2019-03-30 15:20:00', 'abierto'),
(315, '2019-03-30 15:30:00', 'abierto'),
(316, '2019-03-30 15:40:00', 'abierto'),
(317, '2019-03-30 15:50:00', 'abierto'),
(318, '2019-03-30 16:00:00', 'abierto'),
(319, '2019-03-30 16:10:00', 'abierto'),
(320, '2019-03-30 16:20:00', 'abierto'),
(321, '2019-03-30 16:30:00', 'abierto'),
(322, '2019-03-30 16:40:00', 'abierto'),
(323, '2019-03-30 16:50:00', 'abierto'),
(324, '2019-03-30 17:00:00', 'abierto'),
(325, '2019-03-30 17:10:00', 'abierto'),
(326, '2019-03-30 17:20:00', 'abierto'),
(327, '2019-03-30 17:30:00', 'abierto'),
(328, '2019-03-30 17:40:00', 'abierto'),
(329, '2019-03-30 17:50:00', 'abierto'),
(330, '2019-03-30 18:00:00', 'abierto'),
(331, '2019-03-30 18:10:00', 'abierto'),
(332, '2019-03-30 18:20:00', 'abierto'),
(333, '2019-03-30 18:30:00', 'abierto'),
(334, '2019-03-30 18:40:00', 'abierto'),
(335, '2019-03-30 18:50:00', 'abierto'),
(336, '2019-03-30 19:00:00', 'abierto');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `CI` int(8) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Telefono` varchar(12) NOT NULL,
  `email` varchar(45) NOT NULL,
  `sal` varchar(65) NOT NULL,
  `hash` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`CI`, `Nombre`, `Apellido`, `Telefono`, `email`, `sal`, `hash`) VALUES
(1234578, 'Juan', 'Perez', '0000000000', 'algo@algo.com', '-4,-82,34,-105,5,51,-14,104,2,-31,22,-66,-104,73,-115,35', '4b5db8833203b5316d0b21cbae92958b'),
(12345678, 'Juan', 'Perez', '0000000000', 'algo@algo.com', '-28,-95,119,-14,-50,-57,-47,-97,4,-95,4,116,-80,-73,-71,30', '9ad47c18d503f9e90d85a65d9e279004'),
(45751220, 'Luis', 'Delosa', '46546546', 'algo@algo.com', '46,121,77,49,-74,-16,-99,44,80,53,64,1,-26,-33,104,84', '99faa4d826b955fa976309ec11171014'),
(45751221, 'Luis', 'Delosa', '46546546', 'algo@algo.com', '-10,-60,58,-25,-118,-103,25,50,-29,62,-42,-24,-13,-100,-19,28', '8a5a9b340cafb7a34f08b87dc4e3e727');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asociado`
--
ALTER TABLE `asociado`
  ADD PRIMARY KEY (`recetas_ID`),
  ADD KEY `fk_asociado_turnos1_idx` (`turnos_ID`),
  ADD KEY `fk_asociado_recetas1_idx` (`recetas_ID`);

--
-- Indices de la tabla `contiene`
--
ALTER TABLE `contiene`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_contiene_medicamentos1_idx` (`medicamentos_ID`),
  ADD KEY `fk_contiene_recetas1_idx` (`recetas_ID`);

--
-- Indices de la tabla `doctores`
--
ALTER TABLE `doctores`
  ADD PRIMARY KEY (`CI`);

--
-- Indices de la tabla `entrega`
--
ALTER TABLE `entrega`
  ADD PRIMARY KEY (`recetas_ID`),
  ADD KEY `fk_entrega_Doctores1_idx` (`Doctores_CI`),
  ADD KEY `fk_entrega_recetas1_idx` (`recetas_ID`);

--
-- Indices de la tabla `genera`
--
ALTER TABLE `genera`
  ADD PRIMARY KEY (`ID_turno`),
  ADD KEY `fk_CI_usuario_turno_idx` (`CI_usuario`);

--
-- Indices de la tabla `inicia`
--
ALTER TABLE `inicia`
  ADD PRIMARY KEY (`ID_sesion`),
  ADD KEY `fk_inicia_Usuarios1_idx` (`Ci_usuario`);

--
-- Indices de la tabla `medicamentos`
--
ALTER TABLE `medicamentos`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `recetas`
--
ALTER TABLE `recetas`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `recibe`
--
ALTER TABLE `recibe`
  ADD PRIMARY KEY (`recetas_ID`),
  ADD KEY `fk_recibe_Usuarios1_idx` (`Usuarios_CI`),
  ADD KEY `fk_recibe_recetas1_idx` (`recetas_ID`);

--
-- Indices de la tabla `sesiones`
--
ALTER TABLE `sesiones`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `turnos`
--
ALTER TABLE `turnos`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`CI`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contiene`
--
ALTER TABLE `contiene`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `recetas`
--
ALTER TABLE `recetas`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `sesiones`
--
ALTER TABLE `sesiones`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `turnos`
--
ALTER TABLE `turnos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=337;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asociado`
--
ALTER TABLE `asociado`
  ADD CONSTRAINT `fk_asociado_recetas1` FOREIGN KEY (`recetas_ID`) REFERENCES `recetas` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_asociado_turnos1` FOREIGN KEY (`turnos_ID`) REFERENCES `turnos` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `contiene`
--
ALTER TABLE `contiene`
  ADD CONSTRAINT `fk_contiene_medicamentos1` FOREIGN KEY (`medicamentos_ID`) REFERENCES `medicamentos` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_contiene_recetas1` FOREIGN KEY (`recetas_ID`) REFERENCES `recetas` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `entrega`
--
ALTER TABLE `entrega`
  ADD CONSTRAINT `fk_entrega_Doctores1` FOREIGN KEY (`Doctores_CI`) REFERENCES `doctores` (`CI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_entrega_recetas1` FOREIGN KEY (`recetas_ID`) REFERENCES `recetas` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `genera`
--
ALTER TABLE `genera`
  ADD CONSTRAINT `fk_CI_usuario_turno` FOREIGN KEY (`CI_usuario`) REFERENCES `usuarios` (`CI`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ID_turno` FOREIGN KEY (`ID_turno`) REFERENCES `turnos` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `inicia`
--
ALTER TABLE `inicia`
  ADD CONSTRAINT `fk_inicia_Usuarios1` FOREIGN KEY (`Ci_usuario`) REFERENCES `usuarios` (`CI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_inicia_sesiones1` FOREIGN KEY (`ID_sesion`) REFERENCES `sesiones` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `recibe`
--
ALTER TABLE `recibe`
  ADD CONSTRAINT `fk_recibe_Usuarios1` FOREIGN KEY (`Usuarios_CI`) REFERENCES `usuarios` (`CI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_recibe_recetas1` FOREIGN KEY (`recetas_ID`) REFERENCES `recetas` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
