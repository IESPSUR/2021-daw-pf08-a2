package org.iespoligonosur.pf08.main;
import org.iespoligonosur.pf08.clases.JugadorBasico;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
	private static int longitudPistaCarreras=100;
	private static int turno;
	private static LocalDateTime inicioPartida;
	private static LocalDateTime finalPartida;
	private static int numero;
	private static int i;
	private static LocalDateTime tiempo1;
	private static long tiempo2;
	static Scanner teclado;
	private static int [] totalrecorrido= new int[6];
	private static IJugador [] jugadormasveloz = new IJugador[6];
	private static IJugador [] jugadormayorMedia = new IJugador[6];



	public ProgramaCarrera() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Este metodo ejecutara el programa de Carreras
	 * El usuario debe poder realizar tantas carreras como quiera
	 * Se pueden repetir carreras con los usuarios creados
	 * Se pueden repetir carreras creando nuevos usuarios
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		teclado = new Scanner(System.in);
		
		
		creaJugadores();
		iniciaPartida();
		imprimeEstadisticaCarrera();
		
		/*for(i=0;i<10;i++) {
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
			
			*/

		
		
		
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
	private static void creaJugadores() {
		
		
		String usuario = "";
		String animal;
		
		tiempo1=LocalDateTime.now();
		System.out.println("�Cuanto usuario desea crear? \n[1-6]: ");
		numero = teclado.nextInt();
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
	 * @throws InterruptedException 
	 */
	private static void iniciaPartida() throws InterruptedException {
		
		int ganador=0;
		inicioPartida = LocalDateTime.now();

		do {
			for(i=0;i<numero;i++) {
				ejecutaTurno(teclado);
				totalrecorrido [i]=totalrecorrido [i] + turno;
				if (totalrecorrido [i]>=100) {
					ganador=100;
					System.out.println("El jugador "+jugadores[i].getNombre()+ " que es " + jugadores[i].getTipo() + " a alcanzado la meta");				
					System.out.println("-------------------------------------------------------------------------------------------------------------------");

					break;
				}
			}	
			
			if (ganador!=100) {
				System.out.println("-------------------------------------------------------------------------------------------------------------------");
				for ( i=0; i<numero;i++){
				pintaCarrera(  totalrecorrido);
				System.out.println(" ");
				}
				System.out.println("Procedemos a pasar a la siguiente ronda de tiradas.\n");
				System.out.println("-------------------------------------------------------------------------------------------------------------------");

				Thread.sleep(1000);

				
			}
		}while (longitudPistaCarreras!=ganador);
		
		
		finalPartida = LocalDateTime.now();
        tiempo2 = ChronoUnit.SECONDS.between(inicioPartida, finalPartida);
		


	}
	
	/**
	 * Este metodo realiza una representacion grafica en consola de la 
	 * pista y la posicion de los jugadores en la misma
	 */
	private static void pintaCarrera(int [] totalrecorrido) {

		
		System.out.println("El jugador "+jugadores[i].getNombre()+ " que es " + jugadores[i].getTipo() + " lleva recorrido " + totalrecorrido [i] + " metros de distancia.");

			for (int z=0; z<totalrecorrido[i];z++) {
				System.out.print("#");
			}
		
	}
	
	/**
	 * Este metodo llama al metodo avanza para cada uno de los participantes
	 * de la carrea para ejecutar un turno de la carrera
	 */
	private static void ejecutaTurno( Scanner teclado) {
		
		turno = jugadores[i].avanza(teclado);
		
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
	private static void imprimeEstadisticaCarrera() {
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		System.out.println("Esta partida se realizo: "+ tiempo1);
		System.out.println("La duraci�n de la partida ha sido de: "+ tiempo2+"s");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");

		System.out.println("El n�mero de participantes ha sido de: "+ numero);
		System.out.print("\n{");
		ordenaRanking();
		for ( i = 0;i<numero;i++) {
					
			System.out.print(i+1+"� "+jugadores[i].getNombre());
			
			if(i<numero-1)
				System.out.print(", ");
			
		}
		System.out.print("}\n");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		masVeloz();
		System.out.println("La velocidad Maxima del juego fue alcanzada por: "+ jugadormasveloz[0].getNombre());
		mayorMedia();
		System.out.println("La velocidad Media mayor del juego fue de: "+ jugadormasveloz[0].getNombre());

	}
	
	
	
	/** Devuelve del array de participantes el jugador
	 * que alcanzo la mayor velocidad punta
	 * @return
	 */
	private static IJugador [] masVeloz() {
		
		int [] masveloz = new int[numero];

		for (int x=0;x<masveloz.length;x++) {
			masveloz[x] = jugadores[x].getVelocidadAlcanzadaMaxima();
			jugadormasveloz[x]=jugadores[x];
		}
		
		for (int columna = 0; columna < masveloz.length; columna++) {
			for (int elemento = columna+1; elemento < masveloz.length; elemento++) {
				
				if(masveloz[columna]<masveloz[elemento]) {
					int aux = masveloz[columna];
					IJugador aux2= jugadores[columna];

					masveloz[columna]=masveloz[elemento];
					masveloz[elemento]=aux;
					jugadormasveloz[columna]=jugadormasveloz[elemento];
					jugadormasveloz[elemento]=aux2;
				}
			}
		}
		return jugadormasveloz;
	}
	
	/** Devuelve del array de participantes el jugador
	 * que alcanzo la mayor velocidad media
	 * @return
	 */
	private static IJugador [] mayorMedia() {
		 int [] mayorMedia = new int[numero];

		for (int x=0;x<mayorMedia.length;x++) {
			mayorMedia[x] = totalrecorrido[x]/100;
			jugadormayorMedia[x]=jugadores[x];
		}
		
		for (int columna = 0; columna < mayorMedia.length; columna++) {
			for (int elemento = columna+1; elemento < mayorMedia.length; elemento++) {
				
				if(mayorMedia[columna]<mayorMedia[elemento]) {
					int aux = mayorMedia[columna];
					IJugador aux2= jugadores[columna];

					mayorMedia[columna]=mayorMedia[elemento];
					mayorMedia[elemento]=aux;
					jugadormayorMedia[columna]=jugadormayorMedia[elemento];
					jugadormayorMedia[elemento]=aux2;
				}
			}
		}
		return jugadormasveloz;
	}
	
	/**
	 * Método que devuelve un array de Jugadores con los jugadores
	 * de la partida ordenados por puesto de carrera.
	 * En caso de que dos jugadores lleguen a meta en el mismo turno,
	 * o sin llegar a meta empaten en el numero de pasos recorridos,
	 * gana aquel que su velocidad en el ultimo turno fuera mas alta
	 * @return
	 */
	private static IJugador[] ordenaRanking() {
		for (int columna = 0; columna < totalrecorrido.length; columna++) {
			for (int elemento = columna+1; elemento < totalrecorrido.length; elemento++) {
				
				if(totalrecorrido[columna]<totalrecorrido[elemento]) {
					int aux = totalrecorrido[columna];
					IJugador aux2= jugadores[columna];
					totalrecorrido[columna]=totalrecorrido[elemento];
					totalrecorrido[elemento]=aux;
					jugadores[columna]=jugadores[elemento];
					jugadores[elemento]=aux2;
				}
				
			}
			
		}
		
		return jugadores;
	}

}
