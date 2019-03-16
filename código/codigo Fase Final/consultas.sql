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