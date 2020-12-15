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


	int [] avanza= new int[100]; 
	int contador=0;

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
	public TipoJugador getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}

	
	@Override
	public int getVelocidadUltimoTurno() {
		// TODO Auto-generated method stub
		int num = avanza.length;
		int [] VelocidadUltimoTurno = new int[num];
		for (int x=0;x<VelocidadUltimoTurno.length;x++)
			VelocidadUltimoTurno[x] = avanza[x];
		
		return VelocidadUltimoTurno[contador-1];
	}

	@Override
	public int getVelocidadAlcanzadaMaxima() {
		
		int num = avanza.length;
		int [] VelocidadAlcanzadaMaxima = new int[num];
		for (int x=0;x<VelocidadAlcanzadaMaxima.length;x++)
			VelocidadAlcanzadaMaxima[x] = avanza[x];
		
		
		/*
		 * Si no funciona como esta abajo descomentar arriba y cambiar abajo VelocidadAlcanzadaMaxima por array
		 */
		
		
		for (int columna = 0; columna < contador; columna++) {
			for (int elemento = columna+1; elemento < contador; elemento++) {
				
				if(VelocidadAlcanzadaMaxima[columna]>VelocidadAlcanzadaMaxima[elemento]) {
					int aux = VelocidadAlcanzadaMaxima[columna];
					VelocidadAlcanzadaMaxima[columna]=VelocidadAlcanzadaMaxima[elemento];
					VelocidadAlcanzadaMaxima[elemento]=aux;
				}
				
			}
			
		}
		return VelocidadAlcanzadaMaxima[contador-1];

	}

	@Override
	public void resetea() {
		// TODO Auto-generated method stub
		contador=0;
	}

	@Override
	public int avanza(Scanner teclado) {
		
		int avanzar = tresCaras.lanzarDado();
		int contar=contador;
		contador++;
		return avanza[contar]=avanzar;

	}


}
