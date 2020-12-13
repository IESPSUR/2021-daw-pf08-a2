package org.iespoligonosur.pf08.clases;

import java.util.Scanner;

public class Liebre extends JugadorBasico {
	private static final TipoJugador tipo = TipoJugador.LIEBRE;

	
	int avanza;
	int contador=1;
	int [] VelocidadUltimoTurno = new int[contador];
	int [] VelocidadAlcanzadaMaxima = new int[contador];
	int dado;
	
	IDado seisCaras = new DadoBase(6) {
		
		@Override
		public int lanzarDado() {
			int dado=0;
			dado = (int) Math.floor(Math.random() * numeroCaras + 1);
			return dado;	
		}
	};
	//Scanner teclado;
	
	
	public Liebre(String nombre) {
		super(nombre);
	}
	/*public void setTecladoLiebre(Scanner teclado ) {
		this.teclado=teclado;
	}
	*/

	@Override
	public TipoJugador getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}

	@Override
	public int getVelocidadUltimoTurno() {
		// TODO Auto-generated method stub
		int num = VelocidadUltimoTurno.length;
		int [] array = new int[num];
		for (int x=0;x<array.length;x++)
			  array[x] = VelocidadUltimoTurno[x];
		
		return array[array.length-1];
	}

	@Override
	public int getVelocidadAlcanzadaMaxima() {
		
		int num = VelocidadAlcanzadaMaxima.length;
		int [] array = new int[num];
		for (int x=0;x<array.length;x++)
			  array[x] = VelocidadAlcanzadaMaxima[x];
		
		
		/*
		 * Si no funciona como esta abajo descomentar arriba y cambiar abajo VelocidadAlcanzadaMaxima por array
		 */
		
		
		for (int columna = 0; columna < array.length; columna++) {
			for (int elemento = columna+1; elemento < array.length; elemento++) {
				
				if(array[columna]>array[elemento]) {
					int aux = array[columna];
					array[columna]=array[elemento];
					array[elemento]=aux;
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
		// TODO Auto-generated method stub
		
		int avanzar = seisCaras.lanzarDado();
		int contar=contador;
		if (avanzar==3) {
			this.avanza=avanzar;
			this.VelocidadUltimoTurno [contar]=avanzar;
			this.VelocidadAlcanzadaMaxima [contar]=avanzar;
			this.contador++;
		}
		else {
			System.out.println("Adivina lo que a salido");
			int adivina = teclado.nextInt();
			if (adivina==avanza) {
				System.out.println("Has acertado te moveras " + avanzar +" pasos.");
				this.avanza=avanzar;
				this.VelocidadUltimoTurno [contar]=avanzar;
				this.VelocidadAlcanzadaMaxima [contar]=avanzar;
				this.contador++;			
				}else {
				System.out.println("Lo sentimos salio el numero " + avanzar+ ". Intentelo el proximo turno.");
				this.avanza=0;
				this.VelocidadUltimoTurno [contar]=0;
				this.VelocidadAlcanzadaMaxima [contar]=0;
				this.contador++;			
				}
			
		}
		
	}
	
}