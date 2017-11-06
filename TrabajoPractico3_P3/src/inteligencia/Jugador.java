package inteligencia;

import java.io.Serializable;
import java.util.ArrayList;

import inteligencia.PosicionJuego.Posicion;

public class Jugador implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private Posicion posicion;
	private int nivelJuego;
	private String incompatible;
	
	public Jugador(String nombre,Posicion posicion,int nivelJuego,String incompatible){
		verificarNivelDeJuego(nivelJuego);
		
		this.nombre=nombre;
		this.posicion=posicion;
		this.nivelJuego=nivelJuego;
		this.incompatible=incompatible;
	}

	public void verificarNivelDeJuego(int nivelDeJuego) {
		if(nivelDeJuego < 0 || nivelDeJuego > 10 )
			throw new IllegalArgumentException("Se intentó agregar un jugador con un nivel de juego fuera de rango.");
	}
	
	public boolean mismaPosicion(Posicion pos){
		if (posicion != null){	
			return posicion==pos;
		}
		return false;
	}
	
	
	public String nombre(){
		return nombre;
	}

	public Posicion posicion(){
		return posicion;
	}

	public int nivelJuego(){
		return nivelJuego;
	}

	public String incompatible(){
		return incompatible;
	}
	
}