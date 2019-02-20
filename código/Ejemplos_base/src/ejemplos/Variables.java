package ejemplos;
	/**
	 * Esta clase demuestra las diferentes formas de declarar y manejar variables en Java
	 * @author Sebasti�n de los �ngeles
	 * 
	 */
public class Variables {
	
	/* Toda variable sigue este esquema de declaraci�n:
	 *   
	 *   Tipo nombre = valor;
	 *   
	 *   Java es un lenguaje FUERTEMENTE TIPADO, por lo que DEBEMOS declarar qu� tipo de datos
	 *     se guardar�n en la variable.
	 *   Por convenci�n, los nombres de variables se escriben con la primer letra en min�scula. 
	 */
	
	// 1 - Declaraci�n "corta": la variable y su inicializaci�n se declaran en una sola l�nea.
	//   Esta forma es �til para declarar variables globales.
	
	String datoA = "";
	int numeroA = 0;
	
	// 2 -  Declaraci�n "larga": la variable y su inicializaci�n se declaran en l�neas separadas.
	//   Esto es �til en casos en que la inicializaci�n se asigna en un proceso aparte.
	// NOTA: No se pueden hacer asignaciones de datos fuera de un m�todo.
	
	String datoB;
	
	/**
	 * Este m�todo permite trabajar con las variables declaradas en esta clase
	 * @author Sebasti�n de los �ngeles
	 */
	public void VerVariables() {
		datoA="Una Cosa";
		System.out.println("La variable datoA contiene: "+datoA+" y la variable datoB contiene: "+datoB);
	}

}
