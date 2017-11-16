package inteligencia;

import inteligencia.PosicionJuego.Posicion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solucion{
	
	private Set<Jugador> jugadores;
	ArrayList<Jugador> jugadoresSolucion;
	
	public Solucion(){
		jugadores = new HashSet<Jugador>();
		jugadoresSolucion= new ArrayList<Jugador>();
	}

	public void agregar(Jugador jugador){
		jugadores.add(jugador);
	}

	public void eliminar(Jugador jugador){
		jugadores.remove(jugador);
	}

	public int nivelJuego(){
		int ret = 0;
		for(Jugador jugador: jugadores)
			ret += jugador.nivelJuego();
		
		return ret;
	}

	public Set<Jugador> getJugadores(){
		return jugadores;
	}
	
	public int cantidadDeJugadores(){
		return jugadores.size();
	}
	
	
	@Override
	public String toString(){
		String ret = "";
		for(Jugador jugador: jugadores)
			ret += (ret.length() > 0 ? "\n " : "") + jugador.nombre()+ " " +jugador.posicion()+ " "+ jugador.nivelJuego();
		return ret;
	}

	public Solucion clonar(){
		// Deep copy
		Solucion ret = new Solucion();
		for(Jugador solucion: jugadores)
			ret.agregar(solucion);
		
		return ret;
	}
		
//	public ArrayList<Jugador> ListasDePosiciones(Solucion optima)
//	{
//		for(Jugador j: optima.getJugadores())
//		{
//			if(j.mismaPosicion(Posicion.Arquero) )
//				jugadoresSolucion.add(j);
//			if(j.mismaPosicion(Posicion.Defensor) ){
//				jugadoresSolucion.add(j);
//			}
//			if(j.mismaPosicion(Posicion.Mediocampista) ){
//				jugadoresSolucion.add(j);
//			}
//			if(j.mismaPosicion(Posicion.Delantero) ){
//				jugadoresSolucion.add(j);
//			}
//		}
//		return jugadoresSolucion;
//	}
	
	public ArrayList<Jugador> ListasDePosiciones(Solucion optima)
	{
		for(Jugador j: optima.getJugadores())
		{
			if(j.mismaPosicion(Posicion.Arquero) )
				jugadoresSolucion.add(j);
		}
		for(Jugador j: optima.getJugadores())
		{
			if(j.mismaPosicion(Posicion.Defensor) )
			{
				jugadoresSolucion.add(j);
			}}
		for(Jugador j: optima.getJugadores())
		{
			if(j.mismaPosicion(Posicion.Mediocampista) ){
				jugadoresSolucion.add(j);
			}}
		for(Jugador j: optima.getJugadores())
		{
			if(j.mismaPosicion(Posicion.Delantero) )
			{
				jugadoresSolucion.add(j);
			}
		
		}
		
		return jugadoresSolucion;
	}
	
	
	
	
}









