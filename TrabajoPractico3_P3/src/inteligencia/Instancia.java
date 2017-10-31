package inteligencia;

import java.util.ArrayList;

public class Instancia {

	private ArrayList<Jugador> jugadores;
	
	public Instancia(){
		jugadores=new ArrayList<Jugador>();
	}
		
	public void agregarJugador(String nombre,String posicion,int nivelJuego,String incompatible){
		jugadores.add(new Jugador(nombre,posicion,nivelJuego,incompatible));
	}
	
	public int cantidadDeJugadores(){
		return jugadores.size();
	}

}
