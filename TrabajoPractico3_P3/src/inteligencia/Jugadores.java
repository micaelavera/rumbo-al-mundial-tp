package inteligencia;

import java.util.ArrayList;

import datos.JugadoresJSON;
import inteligencia.Jugador;

public class Jugadores {

	public ArrayList<Jugador> jugadores;
	private int cantJugadores;
	private int nivelJuegoTotal;

	public Jugadores(){
		jugadores=new ArrayList<Jugador>();
		nivelJuegoTotal=0;
		cantJugadores=11;
	}
		
	public void agregarJugador(Jugador jugador){
		if(jugador==null){
			throw new IllegalArgumentException("Se intento agregar un jugador invalido");
		}
//		if(!existeJugador(jugador)){
			jugadores.add(jugador);
			nivelJuegoTotal+=jugador.nivelJuego();
//		}
	}
	
	public void eliminarJugador(String nombre){
		for(int i=0;i<jugadores.size();++i){
			if(jugadores.get(i).nombre().equals(nombre)){
				nivelJuegoTotal-=jugadores.get(i).nivelJuego();
				jugadores.remove(i);
			}
		}
	}
	
	public void cargarJugadores(String archivo){
		try{
			JugadoresJSON jugadoresJson= JugadoresJSON.leerGSON(archivo);
			jugadores=jugadoresJson.getJugadores();
			
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("No se encuentra el listado de jugadores. "+ archivo);
		}
	}
	
	public int cantidadDeJugadores(){
		return jugadores.size();
	}
	
	public int hayOnceJugadores() {
		return cantJugadores;
	}

	public Jugador getJugador(int i){
		return jugadores.get(i);
	}
	
	public int getNivelJuegoTotal() {
		return nivelJuegoTotal;
	}
	
	public boolean existeJugador(Jugador jugador){
		return jugadores.contains(jugador);
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
		+ " "+jugador.posicion()+ " "+ jugador.nivelJuego();
		
		return ret;
	}
}