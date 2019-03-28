
ALTER TABLE `asociado`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_asociado_turnos1_idx` (`turnos_ID`),
  ADD KEY `fk_asociado_recetas1_idx` (`recetas_ID`);

ALTER TABLE `contiene`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_contiene_medicamentos1_idx` (`medicamentos_ID`),
  ADD KEY `fk_contiene_recetas1_idx` (`recetas_ID`);

ALTER TABLE `doctores`
  ADD PRIMARY KEY (`CI`);

ALTER TABLE `entrega`
  ADD PRIMARY KEY (`recetas_ID`),
  ADD KEY `fk_entrega_Doctores1_idx` (`Doctores_CI`),
  ADD KEY `fk_entrega_recetas1_idx` (`recetas_ID`);

ALTER TABLE `genera`
  ADD PRIMARY KEY (`ID_turno`),
  ADD KEY `fk_CI_usuario_turno_idx` (`CI_usuario`);

ALTER TABLE `inicia`
  ADD PRIMARY KEY (`ID_sesion`),
  ADD KEY `fk_inicia_Usuarios1_idx` (`Ci_usuario`);

ALTER TABLE `medicamentos`
  ADD PRIMARY KEY (`ID`);

ALTER TABLE `recetas`
  ADD PRIMARY KEY (`ID`);

ALTER TABLE `recibe`
  ADD PRIMARY KEY (`recetas_ID`),
  ADD KEY `fk_recibe_Usuarios1_idx` (`Usuarios_CI`),
  ADD KEY `fk_recibe_recetas1_idx` (`recetas_ID`);

ALTER TABLE `sesiones`
  ADD PRIMARY KEY (`ID`);

ALTER TABLE `turnos`
  ADD PRIMARY KEY (`ID`);

ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`CI`);

ALTER TABLE `asociado`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `contiene`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE `recetas`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `sesiones`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;

ALTER TABLE `turnos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=337;

ALTER TABLE `asociado`
  ADD CONSTRAINT `fk_asociado_recetas1` FOREIGN KEY (`recetas_ID`) REFERENCES `recetas` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_asociado_turnos1` FOREIGN KEY (`turnos_ID`) REFERENCES `turnos` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `contiene`
  ADD CONSTRAINT `fk_contiene_medicamentos1` FOREIGN KEY (`medicamentos_ID`) REFERENCES `medicamentos` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_contiene_recetas1` FOREIGN KEY (`recetas_ID`) REFERENCES `recetas` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `entrega`
  ADD CONSTRAINT `fk_entrega_Doctores1` FOREIGN KEY (`Doctores_CI`) REFERENCES `doctores` (`CI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_entrega_recetas1` FOREIGN KEY (`recetas_ID`) REFERENCES `recetas` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `genera`
  ADD CONSTRAINT `fk_CI_usuario_turno` FOREIGN KEY (`CI_usuario`) REFERENCES `usuarios` (`CI`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ID_turno` FOREIGN KEY (`ID_turno`) REFERENCES `turnos` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `inicia`
  ADD CONSTRAINT `fk_inicia_Usuarios1` FOREIGN KEY (`Ci_usuario`) REFERENCES `usuarios` (`CI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_inicia_sesiones1` FOREIGN KEY (`ID_sesion`) REFERENCES `sesiones` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `recibe`
  ADD CONSTRAINT `fk_recibe_Usuarios1` FOREIGN KEY (`Usuarios_CI`) REFERENCES `usuarios` (`CI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_recibe_recetas1` FOREIGN KEY (`recetas_ID`) REFERENCES `recetas` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
