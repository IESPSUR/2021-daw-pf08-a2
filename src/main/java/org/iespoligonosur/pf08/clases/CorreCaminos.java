package org.iespoligonosur.pf08.clases;

import java.util.Scanner;

public class CorreCaminos extends JugadorBasico  {
	private static final TipoJugador tipo = TipoJugador.CORRECAMINOS;

	
	int [] avanza= new int[100]; 
	int contador=0;

	
	IDado seisCaras = new DadoBase(10) {
		
		@Override
		public int lanzarDado() {
			int dado=0;
			dado = (int) Math.floor(Math.random() * numeroCaras + 1);
			return dado;	
		}
	};
	/**
	 * metodo para el lanzamiento de dado de 10 caras y cribado de opciones
	 * @param dado6
	 * @param teclado
	 * @return
	 */

	public CorreCaminos(String nombre) {
		super(nombre);
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
		// TODO Auto-generated method stub
		int avanzar = seisCaras.lanzarDado();
		int contar=contador;
		int resto;
		
		resto = avanzar % 2;
		if (resto==0) {
			System.out.println("Ha salido un numero PAR te moveras " + avanzar +" pasos.");
			contador++;
			return avanza[contar]=avanzar;
		} else {
			System.out.println("Lo sentimos salio el numero IMPAR " + avanzar+ ". Intentelo el proximo turno.");
			contador++;
			return avanza[contar]=0;
		}

	}
	

	
	
	private int dado;
	
	public CorreCaminos() {
		
	}

	public CorreCaminos(int dado) {
		super();
		this.dado = dado;
	}

	/**
	 * @return the dado
	 */
	public int getDado() {
		return dado;
	}

	/**
	 * @param dado the dado to set
	 */
	public void setDado(int dado) {
		this.dado = dado;
	}
	public  void dadoCorreCamino() {
		int dado = (int) Math.floor(Math.random()*100);
		if ( dado%2==0) {
			
		}
		
		
	}
	
		
	
}
