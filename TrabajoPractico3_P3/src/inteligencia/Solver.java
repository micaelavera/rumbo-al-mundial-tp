package inteligencia;

import inteligencia.Jugador.Posicion;
import java.util.ArrayList;
import java.util.Collections;

public class Solver{

	private ArrayList<Jugador> jugadores;
	private Jugadores instancia;
	private Solucion solucion;
	private Solucion incumbente;
	public enum Algoritmo{BacktrackingOrdenado,FuerzaBruta};
	private Algoritmo algoritmo;
	
	private ArrayList<Jugador> jugadoresSolucion;
	
	public Solver(Jugadores instancia,Algoritmo algoritmo){
		this.instancia=instancia;
		this.algoritmo=algoritmo;
		jugadores=this.instancia.getJugadores();
		jugadoresSolucion= new ArrayList<Jugador>();
	
	}

	public void ordenarJugadores(){
		Collections.sort(jugadores, Comparador.porNivelDeJuego());
		Collections.reverse(jugadores);
	
	}
	
	public Solucion resolver(){
		if( algoritmo == Algoritmo.BacktrackingOrdenado )
			ordenarJugadores();
		
		solucion = new Solucion();
		incumbente = new Solucion();
		
		generarDesde(0);
		
		return incumbente;
	}
	
	
	public void generarDesde(int i){
		if( i == instancia.cantidadDeJugadores()){
			// Caso base de la recursion
			if( esFactible(solucion) && esMejor(solucion, incumbente) && verificarFormacionPedida(solucion))
				incumbente = solucion.clonar();
		}else if( algoritmo == Algoritmo.FuerzaBruta || esFactible(solucion)){
			
			// Caso recursivo
			solucion.agregar(jugadores.get(i));
			generarDesde(i+1);
			
			solucion.eliminar(jugadores.get(i));
			generarDesde(i+1);
		}
	}

	private static boolean verificarFormacionPedida(Solucion jugadores){
		int arquero=0;
		int defensores=0;
		int delanteros=0;
		int mediocampistas=0;
		for (Jugador jugador : jugadores.getJugadores()) {
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

	private boolean esFactible(Solucion solucion){
		return solucion.cantidadDeJugadores()<=instancia.hayOnceJugadores();			
	}
	
	private boolean esMejor(Solucion solucion, Solucion otra){
		return solucion.nivelJuego() > otra.nivelJuego();
	}
	
	public ArrayList<Jugador> get_jugadores() {
		return jugadores;
	}

	public ArrayList<Jugador> ListasDePosiciones(Solucion optima){
		for(Jugador j: optima.getJugadores()){
			if(j.mismaPosicion(Posicion.Arquero)){
				jugadoresSolucion.add(j);
			}
		}
		for(Jugador j: optima.getJugadores()){
			if(j.mismaPosicion(Posicion.Defensor)){
				jugadoresSolucion.add(j);
		}}
		for(Jugador j: optima.getJugadores()){
			if(j.mismaPosicion(Posicion.Mediocampista)){
				jugadoresSolucion.add(j);
		}}
		for(Jugador j: optima.getJugadores()){
			if(j.mismaPosicion(Posicion.Delantero)){
				jugadoresSolucion.add(j);
		}}
		return jugadoresSolucion;
	}	
}