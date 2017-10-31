package inteligencia;

import java.util.ArrayList;

public class Instancia {

	private ArrayList<Jugador> jugadores;
	
	public Instancia(){
		jugadores=new ArrayList<Jugador>();
	}
		
	public void agregarJugador(Jugador jugador){
		jugadores.add(jugador);
	}
	
	public int cantidadDeJugadores(){
		return jugadores.size();
	}

}
