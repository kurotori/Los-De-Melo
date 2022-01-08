
INSERT INTO `asociado` (`turnos_ID`, `recetas_ID`, `ID`) VALUES
(1, 1, 1),
(3, 1, 3);


INSERT INTO `contiene` (`medicamentos_ID`, `cantidad`, `entregado`, `recetas_ID`, `ID`) VALUES
(190871081, 10, 0, 1, 1),
(740872794, 20, 1, 2, 2),
(603842013, 25, 0, 3, 3),
(129780488, 5, 0, 4, 4),
(690926960, 5, 0, 1, 5),
(420804140, 6, 0, 2, 6);


INSERT INTO `doctores` (`CI`, `Nombre`, `Apellido`, `Telefono`, `email`, `sal`, `hash`, `Especialidad`) VALUES
(87654321, 'Fulanito', 'de tal', '45454545454', 'asdfasdfasfda', 'aasdfasdfasdfadsf', 'adsfadfasdfasdfadsf', 'Gastroenterólogo');


INSERT INTO `entrega` (`Doctores_CI`, `recetas_ID`) VALUES
(87654321, 1),
(87654321, 2),
(87654321, 3),
(87654321, 4);


INSERT INTO `genera` (`CI_usuario`, `ID_turno`) VALUES
(38915360, 1),
(38915360, 2),
(38915360, 3);


INSERT INTO `inicia` (`Ci_usuario`, `ID_sesion`) VALUES
(38915360, 29),
(38915360, 30),
(38915360, 31),
(38915360, 32),
(38915360, 33),
(38915360, 34),
(38915360, 35),
(38915360, 36),
(38915360, 37),
(38915360, 38),
(38915360, 39),
(38915360, 40),
(38915360, 41),
(38915360, 42),
(38915360, 43),
(38915360, 44),
(38915360, 45),
(38915360, 46),
(38915360, 47),
(38915360, 48),
(38915360, 49),
(38915360, 50),
(38915360, 51),
(38915360, 52),
(38915360, 53),
(38915360, 54),
(38915360, 55),
(38915360, 56),
(38915360, 57),
(38915360, 58),
(38915360, 59),
(38915360, 60),
(38915360, 61),
(38915360, 62),
(38915360, 63),
(38915360, 64),
(38915360, 65),
(38915360, 66),
(38915360, 67),
(38915360, 68),
(38915360, 69),
(38915360, 70),
(38915360, 71),
(38915360, 72),
(38915360, 73),
(38915360, 74),
(38915360, 75),
(38915360, 76),
(38915360, 77),
(38915360, 78),
(38915360, 79),
(38915360, 80),
(38915360, 81),
(38915360, 82),
(38915360, 83),
(38915360, 84),
(38915360, 85),
(38915360, 86),
(38915360, 87),
(38915360, 88),
(38915360, 89),
(38915360, 90),
(38915360, 91),
(38915360, 92),
(38915360, 93),
(38915360, 94),
(38915360, 95),
(38915360, 96),
(38915360, 97),
(38915360, 98),
(38915360, 99),
(38915360, 100),
(38915360, 101),
(38915360, 102),
(38915360, 103),
(38915360, 104),
(38915360, 106),
(38915360, 107),
(38915360, 108),
(38915360, 109),
(38915360, 110),
(38915360, 111),
(38915360, 112),
(38915360, 113),
(38915360, 114),
(38915360, 115),
(38915360, 116),
(38915360, 117),
(38915360, 118),
(38915360, 119),
(38915360, 120),
(38915360, 121),
(38915360, 122),
(38915360, 123),
(38915360, 124),
(38915360, 125),
(38915360, 126),
(38915360, 127),
(38915360, 128),
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
(45751221, 26),
(87654321, 105);


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


INSERT INTO `recetas` (`ID`, `fecha`) VALUES
(1, '2019-05-15'),
(2, '2019-05-15'),
(3, '2019-02-24'),
(4, '2019-01-16');

INSERT INTO `recibe` (`Usuarios_CI`, `recetas_ID`) VALUES
(38915360, 1),
(38915360, 2),
(38915360, 3),
(45751220, 4);




CREATE TABLE `turnos` (
  `ID` int(11) NOT NULL,
  `fechahora` datetime NOT NULL,
  `estado` enum('confirmado','cancelado','usado','abierto') NOT NULL DEFAULT 'abierto'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `turnos` (`ID`, `fechahora`, `estado`) VALUES
(1, '2019-05-05 08:00:00', 'cancelado'),
(2, '2019-05-05 08:10:00', 'cancelado'),
(3, '2019-05-05 08:20:00', 'confirmado'),
(4, '2019-05-05 08:30:00', 'abierto'),
(5, '2019-05-05 08:40:00', 'abierto'),
(6, '2019-05-05 08:50:00', 'abierto'),
(7, '2019-05-05 09:00:00', 'abierto'),
(8, '2019-05-05 09:10:00', 'abierto'),
(9, '2019-05-05 09:20:00', 'abierto'),
(10, '2019-05-05 09:30:00', 'abierto'),
(11, '2019-05-05 09:40:00', 'abierto'),
(12, '2019-05-05 09:50:00', 'abierto'),
(13, '2019-05-05 10:00:00', 'abierto'),
(14, '2019-05-05 10:10:00', 'abierto'),
(15, '2019-05-05 10:20:00', 'abierto'),
(16, '2019-05-05 10:30:00', 'abierto'),
(17, '2019-05-05 10:40:00', 'abierto'),
(18, '2019-05-05 10:50:00', 'abierto'),
(19, '2019-05-05 11:00:00', 'abierto'),
(20, '2019-05-05 11:10:00', 'abierto'),
(21, '2019-05-05 11:20:00', 'abierto'),
(22, '2019-05-05 11:30:00', 'abierto'),
(23, '2019-05-05 11:40:00', 'abierto'),
(24, '2019-05-05 11:50:00', 'abierto'),
(25, '2019-05-05 12:00:00', 'abierto'),
(26, '2019-05-05 14:00:00', 'abierto'),
(27, '2019-05-05 14:10:00', 'abierto'),
(28, '2019-05-05 14:20:00', 'abierto'),
(29, '2019-05-05 14:30:00', 'abierto'),
(30, '2019-05-05 14:40:00', 'abierto'),
(31, '2019-05-05 14:50:00', 'abierto'),
(32, '2019-05-05 15:00:00', 'abierto'),
(33, '2019-05-05 15:10:00', 'abierto'),
(34, '2019-05-05 15:20:00', 'abierto'),
(35, '2019-05-05 15:30:00', 'abierto'),
(36, '2019-05-05 15:40:00', 'abierto'),
(37, '2019-05-05 15:50:00', 'abierto'),
(38, '2019-05-05 16:00:00', 'abierto'),
(39, '2019-05-05 16:10:00', 'abierto'),
(40, '2019-05-05 16:20:00', 'abierto'),
(41, '2019-05-05 16:30:00', 'abierto'),
(42, '2019-05-05 16:40:00', 'abierto'),
(43, '2019-05-05 16:50:00', 'abierto'),
(44, '2019-05-05 17:00:00', 'abierto'),
(45, '2019-05-05 17:10:00', 'abierto'),
(46, '2019-05-05 17:20:00', 'abierto'),
(47, '2019-05-05 17:30:00', 'abierto'),
(48, '2019-05-05 17:40:00', 'abierto'),
(49, '2019-05-05 17:50:00', 'abierto'),
(50, '2019-05-05 18:00:00', 'abierto'),
(51, '2019-05-05 18:10:00', 'abierto'),
(52, '2019-05-05 18:20:00', 'abierto'),
(53, '2019-05-05 18:30:00', 'abierto'),
(54, '2019-05-05 18:40:00', 'abierto'),
(55, '2019-05-05 18:50:00', 'abierto'),
(56, '2019-05-05 19:00:00', 'abierto'),
(57, '2019-05-06 08:00:00', 'abierto'),
(58, '2019-05-06 08:10:00', 'abierto'),
(59, '2019-05-06 08:20:00', 'abierto'),
(60, '2019-05-06 08:30:00', 'abierto'),
(61, '2019-05-06 08:40:00', 'abierto'),
(62, '2019-05-06 08:50:00', 'abierto'),
(63, '2019-05-06 09:00:00', 'abierto'),
(64, '2019-05-06 09:10:00', 'abierto'),
(65, '2019-05-06 09:20:00', 'abierto'),
(66, '2019-05-06 09:30:00', 'abierto'),
(67, '2019-05-06 09:40:00', 'abierto'),
(68, '2019-05-06 09:50:00', 'abierto'),
(69, '2019-05-06 10:00:00', 'abierto'),
(70, '2019-05-06 10:10:00', 'abierto'),
(71, '2019-05-06 10:20:00', 'abierto'),
(72, '2019-05-06 10:30:00', 'abierto'),
(73, '2019-05-06 10:40:00', 'abierto'),
(74, '2019-05-06 10:50:00', 'abierto'),
(75, '2019-05-06 11:00:00', 'abierto'),
(76, '2019-05-06 11:10:00', 'abierto'),
(77, '2019-05-06 11:20:00', 'abierto'),
(78, '2019-05-06 11:30:00', 'abierto'),
(79, '2019-05-06 11:40:00', 'abierto'),
(80, '2019-05-06 11:50:00', 'abierto'),
(81, '2019-05-06 12:00:00', 'abierto'),
(82, '2019-05-06 14:00:00', 'abierto'),
(83, '2019-05-06 14:10:00', 'abierto'),
(84, '2019-05-06 14:20:00', 'abierto'),
(85, '2019-05-06 14:30:00', 'abierto'),
(86, '2019-05-06 14:40:00', 'abierto'),
(87, '2019-05-06 14:50:00', 'abierto'),
(88, '2019-05-06 15:00:00', 'abierto'),
(89, '2019-05-06 15:10:00', 'abierto'),
(90, '2019-05-06 15:20:00', 'abierto'),
(91, '2019-05-06 15:30:00', 'abierto'),
(92, '2019-05-06 15:40:00', 'abierto'),
(93, '2019-05-06 15:50:00', 'abierto'),
(94, '2019-05-06 16:00:00', 'abierto'),
(95, '2019-05-06 16:10:00', 'abierto'),
(96, '2019-05-06 16:20:00', 'abierto'),
(97, '2019-05-06 16:30:00', 'abierto'),
(98, '2019-05-06 16:40:00', 'abierto'),
(99, '2019-05-06 16:50:00', 'abierto'),
(100, '2019-05-06 17:00:00', 'abierto'),
(101, '2019-05-06 17:10:00', 'abierto'),
(102, '2019-05-06 17:20:00', 'abierto'),
(103, '2019-05-06 17:30:00', 'abierto'),
(104, '2019-05-06 17:40:00', 'abierto'),
(105, '2019-05-06 17:50:00', 'abierto'),
(106, '2019-05-06 18:00:00', 'abierto'),
(107, '2019-05-06 18:10:00', 'abierto'),
(108, '2019-05-06 18:20:00', 'abierto'),
(109, '2019-05-06 18:30:00', 'abierto'),
(110, '2019-05-06 18:40:00', 'abierto'),
(111, '2019-05-06 18:50:00', 'abierto'),
(112, '2019-05-06 19:00:00', 'abierto'),
(113, '2019-05-07 08:00:00', 'abierto'),
(114, '2019-05-07 08:10:00', 'abierto'),
(115, '2019-05-07 08:20:00', 'abierto'),
(116, '2019-05-07 08:30:00', 'abierto'),
(117, '2019-05-07 08:40:00', 'abierto'),
(118, '2019-05-07 08:50:00', 'abierto'),
(119, '2019-05-07 09:00:00', 'abierto'),
(120, '2019-05-07 09:10:00', 'abierto'),
(121, '2019-05-07 09:20:00', 'abierto'),
(122, '2019-05-07 09:30:00', 'abierto'),
(123, '2019-05-07 09:40:00', 'abierto'),
(124, '2019-05-07 09:50:00', 'abierto'),
(125, '2019-05-07 10:00:00', 'abierto'),
(126, '2019-05-07 10:10:00', 'abierto'),
(127, '2019-05-07 10:20:00', 'abierto'),
(128, '2019-05-07 10:30:00', 'abierto'),
(129, '2019-05-07 10:40:00', 'abierto'),
(130, '2019-05-07 10:50:00', 'abierto'),
(131, '2019-05-07 11:00:00', 'abierto'),
(132, '2019-05-07 11:10:00', 'abierto'),
(133, '2019-05-07 11:20:00', 'abierto'),
(134, '2019-05-07 11:30:00', 'abierto'),
(135, '2019-05-07 11:40:00', 'abierto'),
(136, '2019-05-07 11:50:00', 'abierto'),
(137, '2019-05-07 12:00:00', 'abierto'),
(138, '2019-05-07 14:00:00', 'abierto'),
(139, '2019-05-07 14:10:00', 'abierto'),
(140, '2019-05-07 14:20:00', 'abierto'),
(141, '2019-05-07 14:30:00', 'abierto'),
(142, '2019-05-07 14:40:00', 'abierto'),
(143, '2019-05-07 14:50:00', 'abierto'),
(144, '2019-05-07 15:00:00', 'abierto'),
(145, '2019-05-07 15:10:00', 'abierto'),
(146, '2019-05-07 15:20:00', 'abierto'),
(147, '2019-05-07 15:30:00', 'abierto'),
(148, '2019-05-07 15:40:00', 'abierto'),
(149, '2019-05-07 15:50:00', 'abierto'),
(150, '2019-05-07 16:00:00', 'abierto'),
(151, '2019-05-07 16:10:00', 'abierto'),
(152, '2019-05-07 16:20:00', 'abierto'),
(153, '2019-05-07 16:30:00', 'abierto'),
(154, '2019-05-07 16:40:00', 'abierto'),
(155, '2019-05-07 16:50:00', 'abierto'),
(156, '2019-05-07 17:00:00', 'abierto'),
(157, '2019-05-07 17:10:00', 'abierto'),
(158, '2019-05-07 17:20:00', 'abierto'),
(159, '2019-05-07 17:30:00', 'abierto'),
(160, '2019-05-07 17:40:00', 'abierto'),
(161, '2019-05-07 17:50:00', 'abierto'),
(162, '2019-05-07 18:00:00', 'abierto'),
(163, '2019-05-07 18:10:00', 'abierto'),
(164, '2019-05-07 18:20:00', 'abierto'),
(165, '2019-05-07 18:30:00', 'abierto'),
(166, '2019-05-07 18:40:00', 'abierto'),
(167, '2019-05-07 18:50:00', 'abierto'),
(168, '2019-05-07 19:00:00', 'abierto'),
(169, '2019-05-08 08:00:00', 'abierto'),
(170, '2019-05-08 08:10:00', 'abierto'),
(171, '2019-05-08 08:20:00', 'abierto'),
(172, '2019-05-08 08:30:00', 'abierto'),
(173, '2019-05-08 08:40:00', 'abierto'),
(174, '2019-05-08 08:50:00', 'abierto'),
(175, '2019-05-08 09:00:00', 'abierto'),
(176, '2019-05-08 09:10:00', 'abierto'),
(177, '2019-05-08 09:20:00', 'abierto'),
(178, '2019-05-08 09:30:00', 'abierto'),
(179, '2019-05-08 09:40:00', 'abierto'),
(180, '2019-05-08 09:50:00', 'abierto'),
(181, '2019-05-08 10:00:00', 'abierto'),
(182, '2019-05-08 10:10:00', 'abierto'),
(183, '2019-05-08 10:20:00', 'abierto'),
(184, '2019-05-08 10:30:00', 'abierto'),
(185, '2019-05-08 10:40:00', 'abierto'),
(186, '2019-05-08 10:50:00', 'abierto'),
(187, '2019-05-08 11:00:00', 'abierto'),
(188, '2019-05-08 11:10:00', 'abierto'),
(189, '2019-05-08 11:20:00', 'abierto'),
(190, '2019-05-08 11:30:00', 'abierto'),
(191, '2019-05-08 11:40:00', 'abierto'),
(192, '2019-05-08 11:50:00', 'abierto'),
(193, '2019-05-08 12:00:00', 'abierto'),
(194, '2019-05-08 14:00:00', 'abierto'),
(195, '2019-05-08 14:10:00', 'abierto'),
(196, '2019-05-08 14:20:00', 'abierto'),
(197, '2019-05-08 14:30:00', 'abierto'),
(198, '2019-05-08 14:40:00', 'abierto'),
(199, '2019-05-08 14:50:00', 'abierto'),
(200, '2019-05-08 15:00:00', 'abierto'),
(201, '2019-05-08 15:10:00', 'abierto'),
(202, '2019-05-08 15:20:00', 'abierto'),
(203, '2019-05-08 15:30:00', 'abierto'),
(204, '2019-05-08 15:40:00', 'abierto'),
(205, '2019-05-08 15:50:00', 'abierto'),
(206, '2019-05-08 16:00:00', 'abierto'),
(207, '2019-05-08 16:10:00', 'abierto'),
(208, '2019-05-08 16:20:00', 'abierto'),
(209, '2019-05-08 16:30:00', 'abierto'),
(210, '2019-05-08 16:40:00', 'abierto'),
(211, '2019-05-08 16:50:00', 'abierto'),
(212, '2019-05-08 17:00:00', 'abierto'),
(213, '2019-05-08 17:10:00', 'abierto'),
(214, '2019-05-08 17:20:00', 'abierto'),
(215, '2019-05-08 17:30:00', 'abierto'),
(216, '2019-05-08 17:40:00', 'abierto'),
(217, '2019-05-08 17:50:00', 'abierto'),
(218, '2019-05-08 18:00:00', 'abierto'),
(219, '2019-05-08 18:10:00', 'abierto'),
(220, '2019-05-08 18:20:00', 'abierto'),
(221, '2019-05-08 18:30:00', 'abierto'),
(222, '2019-05-08 18:40:00', 'abierto'),
(223, '2019-05-08 18:50:00', 'abierto'),
(224, '2019-05-08 19:00:00', 'abierto'),
(225, '2019-05-09 08:00:00', 'abierto'),
(226, '2019-05-09 08:10:00', 'abierto'),
(227, '2019-05-09 08:20:00', 'abierto'),
(228, '2019-05-09 08:30:00', 'abierto'),
(229, '2019-05-09 08:40:00', 'abierto'),
(230, '2019-05-09 08:50:00', 'abierto'),
(231, '2019-05-09 09:00:00', 'abierto'),
(232, '2019-05-09 09:10:00', 'abierto'),
(233, '2019-05-09 09:20:00', 'abierto'),
(234, '2019-05-09 09:30:00', 'abierto'),
(235, '2019-05-09 09:40:00', 'abierto'),
(236, '2019-05-09 09:50:00', 'abierto'),
(237, '2019-05-09 10:00:00', 'abierto'),
(238, '2019-05-09 10:10:00', 'abierto'),
(239, '2019-05-09 10:20:00', 'abierto'),
(240, '2019-05-09 10:30:00', 'abierto'),
(241, '2019-05-09 10:40:00', 'abierto'),
(242, '2019-05-09 10:50:00', 'abierto'),
(243, '2019-05-09 11:00:00', 'abierto'),
(244, '2019-05-09 11:10:00', 'abierto'),
(245, '2019-05-09 11:20:00', 'abierto'),
(246, '2019-05-09 11:30:00', 'abierto'),
(247, '2019-05-09 11:40:00', 'abierto'),
(248, '2019-05-09 11:50:00', 'abierto'),
(249, '2019-05-09 12:00:00', 'abierto'),
(250, '2019-05-09 14:00:00', 'abierto'),
(251, '2019-05-09 14:10:00', 'abierto'),
(252, '2019-05-09 14:20:00', 'abierto'),
(253, '2019-05-09 14:30:00', 'abierto'),
(254, '2019-05-09 14:40:00', 'abierto'),
(255, '2019-05-09 14:50:00', 'abierto'),
(256, '2019-05-09 15:00:00', 'abierto'),
(257, '2019-05-09 15:10:00', 'abierto'),
(258, '2019-05-09 15:20:00', 'abierto'),
(259, '2019-05-09 15:30:00', 'abierto'),
(260, '2019-05-09 15:40:00', 'abierto'),
(261, '2019-05-09 15:50:00', 'abierto'),
(262, '2019-05-09 16:00:00', 'abierto'),
(263, '2019-05-09 16:10:00', 'abierto'),
(264, '2019-05-09 16:20:00', 'abierto'),
(265, '2019-05-09 16:30:00', 'abierto'),
(266, '2019-05-09 16:40:00', 'abierto'),
(267, '2019-05-09 16:50:00', 'abierto'),
(268, '2019-05-09 17:00:00', 'abierto'),
(269, '2019-05-09 17:10:00', 'abierto'),
(270, '2019-05-09 17:20:00', 'abierto'),
(271, '2019-05-09 17:30:00', 'abierto'),
(272, '2019-05-09 17:40:00', 'abierto'),
(273, '2019-05-09 17:50:00', 'abierto'),
(274, '2019-05-09 18:00:00', 'abierto'),
(275, '2019-05-09 18:10:00', 'abierto'),
(276, '2019-05-09 18:20:00', 'abierto'),
(277, '2019-05-09 18:30:00', 'abierto'),
(278, '2019-05-09 18:40:00', 'abierto'),
(279, '2019-05-09 18:50:00', 'abierto'),
(280, '2019-05-09 19:00:00', 'abierto'),
(281, '2019-05-30 08:00:00', 'abierto'),
(282, '2019-05-30 08:10:00', 'abierto'),
(283, '2019-05-30 08:20:00', 'abierto');


INSERT INTO `usuarios` (`CI`, `Nombre`, `Apellido`, `Telefono`, `email`, `sal`, `hash`) VALUES
(38915360, 'Juan', 'Perez', '0000000000', 'algo@algo.com', '-08,-95,119,-14,-50,-57,-47,-97,4,-95,4,116,-80,-73,-71,30', '9ad47c18d503f9e90d85a65d9e279004');

--