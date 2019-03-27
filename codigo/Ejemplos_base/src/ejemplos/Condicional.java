package ejemplos;


/**
 * Esta clase demuestra el uso de la estrucutra condicional en Java
 * @author Sebasti�n de los �ngeles
 *
 */
public class Condicional {
	
	/*
	 * NOTA: Toda sentencia operativa (o sea, que realiza una acci�n) debe realizarse dentro del �mbito
	 * de un m�todo.
	 */
	
	/*
	 * Estructura general de una estrucutra condicional (IF) en Java
	 * 	
	 * if (condici�n){
	 * 		sentencias que se ejecutan si la condici�n es TRUE
	 * }
	 * else{
	 * 		sentencias que se ejecutan si la condici�n es FALSE
	 * }
	 * 
	 */
	
	
	public void VerCondicionales() {
		int numero = 8;
		String dato = "a";
		
		//Condicional que chequea por valor TRUE
		if(numero>7) {
			System.out.println("El n�mero es mayor que 7");
		}
		
		//Condicional que chequea por valor FALSE negado. 
		if( !(numero<7) ) {
			System.out.println("El n�mero no es menor que 7");
		}
		
		//Condicional por valor de variable booleana
		boolean condicion = true;
		
		if(condicion) {
			System.out.println("La condici�n devuelve valor TRUE");
		}
		
		//De forma semejante, se puede declarar una condicional forzada, que nunca se ejecuta o que siempre se
		//  ejecuta, muy poco �til, pero sirve como ejemplo
		
		if(true) {
			System.out.println("Este texto SIEMPRE se va a mostrar");
		}
		
		if(true) {
			System.out.println("Este texto SIEMPRE se va a mostrar");
		}
		
		if(false) {
			System.out.println("Este texto NUNCA se va a mostrar");
		}
		
	}
	

}
