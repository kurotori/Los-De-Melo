package ejemplos;
	/**
	 * Esta clase demuestra las diferentes formas de declarar y manejar variables en Java
	 * @author Sebastián de los Ángeles
	 * 
	 */
public class Variables {
	
	/* Toda variable sigue este esquema de declaración:
	 *   
	 *   Tipo nombre = valor;
	 *   
	 *   Java es un lenguaje FUERTEMENTE TIPADO, por lo que DEBEMOS declarar qué tipo de datos
	 *     se guardarán en la variable.
	 *   Por convención, los nombres de variables se escriben con la primer letra en minúscula. 
	 */
	
	// 1 - Declaración "corta": la variable y su inicialización se declaran en una sola línea.
	//   Esta forma es útil para declarar variables globales.
	
	String datoA = "";
	int numeroA = 0;
	
	// 2 -  Declaración "larga": la variable y su inicialización se declaran en líneas separadas.
	//   Esto es útil en casos en que la inicialización se asigna en un proceso aparte.
	// NOTA: No se pueden hacer asignaciones de datos fuera de un método.
	
	String datoB;
	
	/**
	 * Este método permite trabajar con las variables declaradas en esta clase
	 * @author Sebastián de los Ángeles
	 */
	public void VerVariables() {
		datoA="Una Cosa";
		System.out.println("La variable datoA contiene: "+datoA+" y la variable datoB contiene: "+datoB);
	}

}
