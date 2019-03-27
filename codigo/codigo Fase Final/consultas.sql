SELECT COUNT(sesiones.ID) FROM sesiones INNER JOIN inicia WHERE
inicia.Ci_usuario="45751221" AND sesiones.ID = inicia.ID_sesion;

SELECT COUNT(sesiones.ID) FROM sesiones INNER JOIN inicia WHERE
inicia.Ci_usuario="45751221" AND sesiones.estado='activa'
AND sesiones.ID = inicia.ID_sesion;

SELECT COUNT(sesiones.ID) FROM sesiones INNER JOIN inicia WHERE
inicia.Ci_usuario="45751221" AND sesiones.estado='cerrada'
AND sesiones.ID = inicia.ID_sesion;


UPDATE sesiones INNER JOIN inicia SET
sesiones.estado='cerrada'
WHERE inicia.Ci_usuario="45751221";

UPDATE sesiones INNER JOIN inicia SET
sesiones.estado='activa'
WHERE inicia.Ci_usuario="45751221"
AND sesiones.ID = inicia.ID_sesion;
;

UPDATE sesiones INNER JOIN inicia 
SET
sesiones.estado='cerrada'
WHERE inicia.Ci_usuario="45751220"
AND sesiones.ID = 21
AND sesiones.estado = 'activa'
AND sesiones.ID = inicia.ID_sesion;
;




SELECT contiene.medicamentos_ID,contiene.cantidad FROM
contiene INNER JOIN recibe
WHERE 
recibe.Usuarios_CI = 12345678
AND
contiene.recetas_ID = recibe.recetas_ID


SELECT 
contiene.medicamentos_ID,
(
    SELECT medicamentos.Nombre
    FROM medicamentos
    WHERE medicamentos.id = contiene.medicamentos_ID
) AS medicamento,



contiene.cantidad FROM
contiene INNER JOIN recibe
WHERE 
recibe.Usuarios_CI = 12345678
AND
contiene.recetas_ID = recibe.recetas_ID


/*
----- Version Final
*/
SELECT 
(
	SELECT 
	concat_ws(',',medicamentos.Nombre,medicamentos.presentacion)
	FROM medicamentos
    WHERE medicamentos.id = contiene.medicamentos_ID
) AS Medicamento,
contiene.cantidad AS Cantidad,
(
    SELECT 
    medicamentos.stock
    FROM medicamentos
    WHERE medicamentos.id = contiene.medicamentos_ID
) AS Disponibilidad
FROM
contiene INNER JOIN recibe
WHERE 
recibe.Usuarios_CI = 12345678
AND
contiene.recetas_ID = recibe.recetas_ID

/* -  Buscar el primer turno abierto*/
SELECT `ID` FROM `turnos` WHERE estado = 'abierto' LIMIT 1
/*Version Final*/
SELECT `ID`,`fechahora` FROM `turnos` WHERE estado = 'abierto' ORDER BY fechahora ASC LIMIT 1

/* Búsqueda de turnos confirmados  */

SELECT
asociado.turnos_ID AS "Num Turno",
(SELECT DATE(turnos.fechahora)
 FROM turnos
 WHERE turnos.ID = asociado.turnos_ID)
 AS Fecha,
 (SELECT TIME(turnos.fechahora)
 FROM turnos
 WHERE turnos.ID = asociado.turnos_ID)
 AS Hora,
 (SELECT turnos.estado
 FROM turnos
 WHERE turnos.ID = asociado.turnos_ID)
 AS Estado
FROM asociado INNER JOIN genera
WHERE asociado.turnos_ID = genera.ID_turno;

/* Consultas para reservar turnos */
UPDATE turnos 
SET turnos.estado = 'confirmado'
WHERE turnos.ID = 1;

INSERT INTO asociado
(asociado.turnos_ID, asociado.recetas_ID)
VALUES (1,1);

INSERT INTO genera
(genera.CI_usuario, genera.ID_turno)
VALUES ('12345678',1);

/* Busqueda de última receta */

SELECT recetas.ID, recetas.fecha
FROM recetas INNER JOIN recibe
WHERE recibe.Usuarios_CI = '12345678'
AND recetas.ID = recibe.recetas_ID
ORDER BY recetas.fecha DESC
LIMIT 1;

/* Búsqueda de turnos  */
SELECT 
CONCAT_WS(' - ',DATE(turnos.fechahora),TIME_FORMAT(turnos.fechahora,'%H:%i'))
AS Fecha
FROM turnos INNER JOIN genera
WHERE genera.CI_usuario = '12345678'
AND turnos.ID = genera.ID_turno

/* Versión Final */
SELECT 
CONCAT_WS(' - ',DATE(turnos.fechahora),TIME_FORMAT(turnos.fechahora,'%H:%i'))
AS Fecha,
turnos.estado AS 'Estado'
FROM turnos INNER JOIN genera
WHERE genera.CI_usuario = '12345678'
AND turnos.ID = genera.ID_turno

/* Contar Turnos Activos */

SELECT 
COUNT(turnos.ID)
FROM turnos INNER JOIN genera
WHERE genera.CI_usuario = '12345678'
AND turnos.estado = 'confirmado'
AND turnos.ID = genera.ID_turno

/* Datos del turno activo */

SELECT 
turnos.ID,
DATE(turnos.fechahora),
TIME_FORMAT(turnos.fechahora,'%H:%i')
FROM turnos INNER JOIN genera
WHERE genera.CI_usuario = '12345678'
AND turnos.estado = 'confirmado'
AND turnos.ID = genera.ID_turno


/* Obtener nombre y apellido */

SELECT 
CONCAT_WS(' ',usuarios.Nombre, usuarios.Apellido)
AS NOMBRE
FROM usuarios
WHERE usuarios.CI = '12345678'




