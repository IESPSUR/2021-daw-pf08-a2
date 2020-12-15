package org.iespoligonosur.pf08.main;
import org.iespoligonosur.pf08.clases.JugadorBasico;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.iespoligonosur.pf08.clases.IJugador;
import org.iespoligonosur.pf08.clases.Liebre;
import org.iespoligonosur.pf08.clases.DadoBase;
import org.iespoligonosur.pf08.clases.CorreCaminos;
import org.iespoligonosur.pf08.clases.TipoJugador;
import org.iespoligonosur.pf08.clases.Tortuga;
import org.iespoligonosur.pf08.clases.IDado;


public class ProgramaCarrera {

	//Array con los jugadores
	private static IJugador [] jugadores = new IJugador[6];
	private int longitudPistaCarreras=100;
	private int turno;
	private LocalDateTime inicioPartida;
	private LocalDateTime finalPartida;
	
	public ProgramaCarrera() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Este metodo ejecutara el programa de Carreras
	 * El usuario debe poder realizar tantas carreras como quiera
	 * Se pueden repetir carreras con los usuarios creados
	 * Se pueden repetir carreras creando nuevos usuarios
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		creaJugadores(teclado);
		
		
		for(int i=0;i<10;i++) {
			jugadores[0].avanza(teclado);
			jugadores[1].avanza(teclado);
			jugadores[2].avanza(teclado);
			}
			
			System.out.println( "La velocidad del ultimo turno de "+jugadores[0].getNombre()+" fue de "+jugadores[0].getVelocidadUltimoTurno()+ " pasos");
			System.out.println("La velocidad alcanzada maxima fue "+jugadores[0].getNombre()+" fue de " +jugadores[0].getVelocidadAlcanzadaMaxima()+ " pasos");

			System.out.println( "La velocidad del ultimo turno de "+jugadores[1].getNombre()+" fue de "+ jugadores[1].getVelocidadUltimoTurno()+ " pasos");
			System.out.println("La velocidad alcanzada maxima de "+jugadores[1].getNombre()+" fue de " + jugadores[1].getVelocidadAlcanzadaMaxima() + " pasos");
			System.out.println(jugadores[1].getNombre());

			System.out.println( "La velocidad del ultimo turno de "+jugadores[2].getNombre()+" fue de "+ jugadores[2].getVelocidadUltimoTurno()+ " pasos");
			System.out.println("La velocidad alcanzada maxima de "+jugadores[2].getNombre()+" fue de " + jugadores[2].getVelocidadAlcanzadaMaxima() + " pasos");
			System.out.println(jugadores[2].getNombre());

		
		
		
	/**
	 * es una prueba de dado para tortuga y liebre
	 */
	/*IJugador 0 = new IJUGADOR("ruben");
	IJugador 1 = new Tortuga("manuel");
	IJugador 2 = new CorreCaminos("lolo");

	
	for(int i=0;i<10;i++) {
	0.avanza(teclado);
	1.avanza(null);
	2.avanza(null);
	}
	
	System.out.println( "La velocidad del ultimo turno de liebre fue de "+0.getVelocidadUltimoTurno()+ " pasos");
	System.out.println("La velocidad alcanzada maxima fue liebre fue de " +0.getVelocidadAlcanzadaMaxima()+ " pasos");
	
	System.out.println( "La velocidad del ultimo turno de tortuga fue de "+ 1.getVelocidadUltimoTurno()+ " pasos");
	System.out.println("La velocidad alcanzada maxima de tortuga fue de " + 1.getVelocidadAlcanzadaMaxima() + " pasos");

	System.out.println( "La velocidad del ultimo turno de correcaminos fue de "+ 2.getVelocidadUltimoTurno()+ " pasos");
	System.out.println("La velocidad alcanzada maxima de correcaminos fue de " + 2.getVelocidadAlcanzadaMaxima() + " pasos");
	*/
		
		
	
	
	}
	/**
	 * Este metodo se encarga de crear uno a uno hasta 6 jugadores
	 * con la ayuda del usuario que introduce los datos a través de
	 * la consola.
	 */
	private static void creaJugadores(Scanner teclado) {
		
		int i;
		String usuario = "";
		String animal;
		
		System.out.println("�Cuanto usuario desea crear? \n[1-6]: ");
		int numero = teclado.nextInt();
		for ( i=0; i<numero; i++) {
			System.out.println("�Con que animal desea participar? \n[Tortuga/Liebre/Correcaminos]: ");
			animal = teclado.next();
			System.out.println("Introduzca su nombre de usuario: ");
			usuario =teclado.next();
			
			
			
			switch (animal) {
			case ("Tortuga"): jugadores [i]= new Tortuga (usuario); break;
			case ("Liebre"): jugadores [i]= new Liebre (usuario); break;
			case ("Correcaminos"): jugadores [i]= new CorreCaminos (usuario);break;	
			}
			
			/*
			 * 
			 * este si funciona
			 * if (animal.equals("Tortuga")) {
			 
				 jugadores [i]= new Tortuga (usuario);
			} else if (animal.equals("Liebre")) {
				jugadores [i]= new Liebre (usuario);
			}else if (animal.equals("Correcaminos")) {
				jugadores [i]= new CorreCaminos (usuario);
			}else
				System.out.println("no furula");
			 */
		}
	}
	
	/**
	 * Este metodo inicia la partida con los jugadores ya previamente
	 * creados por el usuario
	 * La partida termina cuando cualquiera de los jugadores recorre toda
	 * la longitud determinada para la pista alcanzando la meta.
	 */
	private void iniciaPartida() {
		
	}
	
	/**
	 * Este metodo realiza una representacion grafica en consola de la 
	 * pista y la posicion de los jugadores en la misma
	 */
	private void pintaCarrera() {
		
	}
	
	/**
	 * Este metodo llama al metodo avanza para cada uno de los participantes
	 * de la carrea para ejecutar un turno de la carrera
	 */
	private void ejecutaTurno() {
		
	}
	
	/**
	 * Este método debe imprimir la estadística de la carrera
	 * Fecha y Hora de la realización
	 * Duración en minutos
	 * Número de participantes
	 * Ranking de participantes
	 * Velocidad Punta Máxima y Jugador que la alcanzó
	 * Velocidad Media más alta y jugador que la alcanzo
	 */
	private void imprimeEstadisticaCarrera() {
		
	}
	
	
	
	/** Devuelve del array de participantes el jugador
	 * que alcanzo la mayor velocidad punta
	 * @return
	 */
	private IJugador masVeloz() {
		return null;
	}
	
	/** Devuelve del array de participantes el jugador
	 * que alcanzo la mayor velocidad media
	 * @return
	 */
	private IJugador mayorMedia() {
		return null;
	}
	
	/**
	 * Método que devuelve un array de Jugadores con los jugadores
	 * de la partida ordenados por puesto de carrera.
	 * En caso de que dos jugadores lleguen a meta en el mismo turno,
	 * o sin llegar a meta empaten en el numero de pasos recorridos,
	 * gana aquel que su velocidad en el ultimo turno fuera mas alta
	 * @return
	 */
	private IJugador[] ordenaRanking() {
		return null;
	}

}
