
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE SCHEMA systurno;
USE systurno;


CREATE TABLE `asociado` (
  `turnos_ID` int(11) NOT NULL,
  `recetas_ID` int(11) NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `contiene` (
  `medicamentos_ID` int(11) NOT NULL,
  `cantidad` int(3) DEFAULT NULL,
  `entregado` tinyint(1) NOT NULL,
  `recetas_ID` int(11) NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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


CREATE TABLE `entrega` (
  `Doctores_CI` int(8) NOT NULL,
  `recetas_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `genera` (
  `CI_usuario` int(8) NOT NULL,
  `ID_turno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `inicia` (
  `Ci_usuario` int(8) NOT NULL,
  `ID_sesion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `medicamentos` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `laboratorio` varchar(30) NOT NULL,
  `principio` varchar(50) NOT NULL,
  `presentacion` varchar(30) NOT NULL,
  `controlado` tinyint(1) NOT NULL,
  `stock` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `recetas` (
  `ID` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `recibe` (
  `Usuarios_CI` int(8) NOT NULL,
  `recetas_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sesiones` (
  `ID` int(11) NOT NULL,
  `fechahora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `estado` enum('activa','cerrada') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `usuarios` (
  `CI` int(8) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Telefono` varchar(12) NOT NULL,
  `email` varchar(45) NOT NULL,
  `sal` varchar(65) NOT NULL,
  `hash` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;
