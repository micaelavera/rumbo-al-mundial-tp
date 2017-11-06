package inteligencia;

import java.util.ArrayList;
import java.util.Collections;
import datos.JugadoresJson;
import inteligencia.Jugador;

public class Jugadores {

	private int nivelJuegoTotal;
	private ArrayList<Jugador> jugadores;
	private int cantJugadores;
	
	public Jugadores(){
		jugadores=new ArrayList<Jugador>();
		nivelJuegoTotal=0;
		cantJugadores=11;
	}
		
	public void agregarJugador(Jugador jugador){
		jugadores.add(jugador);
		nivelJuegoTotal+=jugador.nivelJuego();
	}
	
	public void eliminarJugador(Jugador jugador){
		jugadores.remove(jugador);
		nivelJuegoTotal-=jugador.nivelJuego();
	}
	
	public int cantidadDeJugadores(){
		return jugadores.size();
	}
	
	public int getCantidadDeJugadores() {
		return cantJugadores;
	}

	public Jugador getJugador(int i){
		return jugadores.get(i);
	}
	
	public int getNivelJuegoTotal() {
		return nivelJuegoTotal;
	}
	

	@SuppressWarnings("unchecked")
	public ArrayList<Jugador> getJugadores() {
		return (ArrayList<Jugador>) jugadores.clone();
	}
	
	@Override
	public String toString(){
		String ret = "";
		for(Jugador jugador: jugadores)
			ret += (ret.length() > 0 ? "\n" : "") + jugador.nombre()
		+ " "+jugador.posicion()+ " "+ jugador.nivelJuego()+" "+ jugador.incompatible();
		
		return ret;
	}
}
