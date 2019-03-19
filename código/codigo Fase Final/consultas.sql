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

