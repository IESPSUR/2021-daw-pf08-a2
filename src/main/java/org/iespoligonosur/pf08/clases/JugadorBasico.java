package org.iespoligonosur.pf08.clases;

/**
 * Clases base de Jugadores.
 * Se deben implemenntar las clases hijas Tortuga, Liebre y CorreCaminos
 * @author eserrano
 *
 */
public abstract class JugadorBasico implements IJugador {

	private String nombre;
	private int velocidadPunta;
	private int ultimaTirada;
	private int recorrido;
	
	private IDado dado;
	
	public JugadorBasico() {
		// TODO Auto-generated constructor stub
	}

	public JugadorBasico(String nombre) {
		this.nombre=nombre;
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	
	/*public void setNombre(String Nombre) {
		this.nombre=Nombre;
	}*/

}
