package inteligencia;
//
import inteligencia.PosicionJuego.Posicion;

import java.util.ArrayList;
import java.util.Collections;

import datos.JugadoresJson;

public class Solver{

	private ArrayList<Jugador> _jugadores;
	private Jugadores _instancia;
	private Solucion _solucion;
	private Solucion _incumbente;
	public enum Algoritmo{BacktrackingOrdenado,FuerzaBruta};
	private Algoritmo _algoritmo;
	
	public Solver(Jugadores instancia,Algoritmo algoritmo){
		_instancia=instancia;
		_algoritmo=algoritmo;
		_jugadores=instancia.getJugadores();
	}

	public void ordenarJugadores(){
		Collections.sort(_jugadores, Comparador.porNivelDeJuego());
		Collections.reverse(_jugadores);
	}
	
	public ArrayList<Jugador> get_jugadores() {
		return _jugadores;
	}

	public Solucion resolver(){
		if( _algoritmo == Algoritmo.BacktrackingOrdenado )
			ordenarJugadores();
		
		_solucion = new Solucion();
		_incumbente = new Solucion();
		
		generarDesde(0);
		
		return _incumbente;
	}
	
	public void generarDesde(int i){
		if( i == _instancia.cantidadDeJugadores() )
		{
			// Caso base de la recursión
			if( esFactible(_solucion) && esMejor(_solucion, _incumbente) && verificarFormacionPedida(_solucion))
				_incumbente = _solucion.clonar();
		}
		else if( _algoritmo == Algoritmo.FuerzaBruta || esFactible(_solucion))
		{
			// Caso recursivo
			_solucion.agregar(_jugadores.get(i));
			generarDesde(i+1);
			
			_solucion.eliminar(_jugadores.get(i));
			generarDesde(i+1);
		}
	}
	
	public int nivelDeJuegoTotal(Solucion jugadores){
		int puntaje=0;
		for(Jugador jugador: jugadores.getObjetos()){
			puntaje+=jugador.nivelJuego();
		}
		return puntaje;
	}
	
	
	private static boolean verificarFormacionPedida(Solucion jugadores){
		int arquero=0;
		int defensores=0;
		int delanteros=0;
		int mediocampistas=0;
		for (Jugador jugador : jugadores.getObjetos()) {
			if(jugador.mismaPosicion(Posicion.Arquero))
				arquero++;
			if(jugador.mismaPosicion(Posicion.Defensor))
				defensores++;
			if(jugador.mismaPosicion(Posicion.Delantero))
				delanteros++;
			if(jugador.mismaPosicion(Posicion.Mediocampista))
				mediocampistas++;
		}
		return arquero == 1 && defensores <= 4 && mediocampistas <= 3
				&& delanteros <= 3;
	}
	
	private boolean esFactible(Solucion solucion)
	{
		return solucion.cantidadDeJugadores()<= _instancia.getCantidadDeJugadores(); 
	}
	
	
	private boolean esMejor(Solucion solucion, Solucion otra)
	{
		return solucion.nivelJuego() > otra.nivelJuego();
	}

//	private boolean esIncompatible(Jugador solucion,Jugador otra){
//		return 
//	}
}
