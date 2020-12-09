package org.iespoligonosur.pf08.clases;


public class CorreCaminos {
	static int dado10;
	

	/**
	 * metodo para el lanzamiento de dado de 10 caras y cribado de opciones
	 * @param dado6
	 * @param teclado
	 * @return
	 */
	public int DadoCorrecaminos(int dado10) {
		int resto;
		
		dado10 = (int) Math.floor(Math.random() * 10+1);
		resto = dado10 % 2;
		if (resto==0)
			return dado10;
		else {
			dado10=0;
			return dado10;
		}
	}
	
	/**
	 * para probar los lanzamientos si funciona (añadir static a los metodos y variables)
	 */
	/*public static void main(String[] args) {

		dado10=DadoCorrecaminos(dado10);
		System.out.println(dado10);
		
	}*/

}
