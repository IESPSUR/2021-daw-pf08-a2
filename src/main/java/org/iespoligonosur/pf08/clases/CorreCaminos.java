package org.iespoligonosur.pf08.clases;

import java.util.Scanner;

public class CorreCaminos extends JugadorBasico {
private static final TipoJugador tipo = TipoJugador.CORRECAMINOS;
	private String nombre;
	int [] avanza= new int[100]; 
	int contador=0;
	
	IDado DiezCaras = new DadoBase(10) {
        
		
		@Override	
	    public int lanzarDado() {
		int dado=0;
		dado = (int) Math.floor(Math.random()*numeroCaras+ 1);
		return dado;
		}
		
	};
	
	/**
	 * @param nombre
	 */
	public CorreCaminos(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public TipoJugador getTipo() {
		// TODO Auto-generated method stub
		return tipo ;
	}

	@Override
	public int getVelocidadUltimoTurno() {
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
		contador=0;
		
	}

	@Override
	public int avanza(Scanner teclado) {
		int avanzar = DiezCaras.lanzarDado();
		int contar=contador;
		if (avanzar %2==0) {
			System.out.println("Avanzas " + avanzar +" pasos.");
			contador++;
			return avanza[contar]=avanzar;
		}else {
			contador++;
			return avanza[contar]=0;
		}
		
	
	
	}
	}