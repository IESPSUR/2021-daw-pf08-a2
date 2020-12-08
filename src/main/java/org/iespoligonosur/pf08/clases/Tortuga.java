/**
 * 
 */
package org.iespoligonosur.pf08.clases;

/**
 * @author Ruben
 *
 */
public class Tortuga {

	int dado3;
	/**
	 * 
	 */
	public Tortuga() {
		// TODO Auto-generated constructor stub
	}
	
	public int DadoTortuga(int dado3) {
		dado3 = (int) Math.floor(Math.random() * 3+1);
		return dado3;
	}
	
	/**
	 * para probar los lanzamientos si funciona (añadir static a los metodos y variables, y comentar el escaner)
	 */
	/*public static void main(String[] args) {	
		System.out.println(DadoTortuga(dado3));
	}*/

}
