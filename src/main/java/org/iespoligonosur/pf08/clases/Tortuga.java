/**
 * 
 */
package org.iespoligonosur.pf08.clases;

import java.util.Scanner;

/**
 * @author Ruben
 *
 */
public class Tortuga extends JugadorBasico  {
	private static final TipoJugador tipo = TipoJugador.TORTUGA;


	int avanza;
	int contador=0;
	int [] VelocidadUltimoTurno = new int[contador];
	int [] VelocidadAlcanzadaMaxima = new int[contador];

	IDado tresCaras = new DadoBase(3) {
		
		@Override
		public int lanzarDado() {
			int dado=0;
			dado = (int) Math.floor(Math.random() * numeroCaras + 1);
			return dado;	
		}
	};
	
	
	/**
	 * 
	 */
	public Tortuga(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return getNombre();
	}

	@Override
	public TipoJugador getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}

	
	@Override
	public int getVelocidadUltimoTurno() {
		
		return VelocidadUltimoTurno[VelocidadUltimoTurno.length-1];
	}

	
	@Override
	public int getVelocidadAlcanzadaMaxima() {
		/*
		int num = VelocidadAlcanzadaMaxima.length;
		int [] array = new int[num];
		for (int x=0;x<array.length;x++)
			  array[x] = VelocidadAlcanzadaMaxima[x];
		*/
		
		/*
		 * Si no funciona como esta abajo descomentar arriba y cambiar abajo VelocidadAlcanzadaMaxima por array
		 */
		
		
		for (int columna = 0; columna < VelocidadAlcanzadaMaxima.length; columna++) {
			for (int elemento = columna+1; elemento < VelocidadAlcanzadaMaxima.length; elemento++) {
				
				if(VelocidadAlcanzadaMaxima[columna]>VelocidadAlcanzadaMaxima[elemento]) {
					int aux = VelocidadAlcanzadaMaxima[columna];
					VelocidadAlcanzadaMaxima[columna]=VelocidadAlcanzadaMaxima[elemento];
					VelocidadAlcanzadaMaxima[elemento]=aux;
				}
				
			}
			
		}
		return VelocidadAlcanzadaMaxima[VelocidadAlcanzadaMaxima.length-1];
	}

	@Override
	public void resetea() {
		// TODO Auto-generated method stub
		contador=0;
	}

	@Override
	public void avanza(Scanner teclado) {
		avanza = tresCaras.lanzarDado();
		VelocidadUltimoTurno [contador]=avanza;
		VelocidadAlcanzadaMaxima [contador]=avanza;
		contador++;

	}


}
