package ejemplos;


/**
 * Esta clase demuestra el uso de la estrucutra condicional en Java
 * @author Sebastián de los Ángeles
 *
 */
public class Condicional {
	
	/*
	 * NOTA: Toda sentencia operativa (o sea, que realiza una acción) debe realizarse dentro del ámbito
	 * de un método.
	 */
	
	/*
	 * Estructura general de una estrucutra condicional (IF) en Java
	 * 	
	 * if (condición){
	 * 		sentencias que se ejecutan si la condición es TRUE
	 * }
	 * else{
	 * 		sentencias que se ejecutan si la condición es FALSE
	 * }
	 * 
	 */
	
	
	public void VerCondicionales() {
		int numero = 8;
		String dato = "a";
		
		//Condicional que chequea por valor TRUE
		if(numero>7) {
			System.out.println("El número es mayor que 7");
		}
		
		//Condicional que chequea por valor FALSE negado. 
		if( !(numero<7) ) {
			System.out.println("El número no es menor que 7");
		}
		
		//Condicional por valor de variable booleana
		boolean condicion = true;
		
		if(condicion) {
			System.out.println("La condición devuelve valor TRUE");
		}
		
		//De forma semejante, se puede declarar una condicional forzada, que nunca se ejecuta o que siempre se
		//  ejecuta, muy poco útil, pero sirve como ejemplo
		
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
