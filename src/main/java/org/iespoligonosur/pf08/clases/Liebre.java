package org.iespoligonosur.pf08.clases;

import java.util.Scanner;

public class Liebre {

	int dado6;
	Scanner teclado;
	
	/**
	 * Constructor para pasar por teclado
	 * @param teclado
	 */
	public Liebre(Scanner teclado) {
		this.teclado=teclado;
	}
	/**
	 * metodo para el lanzamiento de dado de 6 caras y cribado de opciones
	 * @param dado6
	 * @param teclado
	 * @return
	 */
	public int MovimientoLiebre(int dado6, Scanner teclado) {
		dado6 = (int) Math.floor(Math.random() * 6+1);
		if (dado6==3)
			return dado6;
		else {
			System.out.println("Adivina lo que a salido");
			int adivina= teclado.nextInt();
			if (adivina==dado6) {
				return dado6;
			}else {
				System.out.println("Lo sentimos salio " + dado6+ " intentelo el proximo turno");
				dado6=0;
				return dado6;
			}
			
		}
	}
	
	/**
	 * para probar los lanzamientos si funciona (añadir static a los metodos y variables, y comentar el escaner)
	 */
	/*public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		dado6=MovimientoLiebre(dado6, teclado);
		System.out.println(dado6);
		
		teclado.close
	}*/
}