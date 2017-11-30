package inteligencia;

import java.io.Serializable;

public class Jugador implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	public enum Posicion {Arquero, Defensor, Delantero, Mediocampista};
	private Posicion posicion;
	private int nivelJuego;

	public Jugador(String nombre,Posicion posicion, int nivelJuego){
		if(verificarDatos(nombre, posicion,nivelJuego)){
			this.nombre=nombre;
			this.posicion=posicion;
			this.nivelJuego=nivelJuego;
		}else{
			throw new IllegalArgumentException("Se intento agregar un jugador con datos inválidos");
		}
	}
	
	private boolean verificarDatos(String nombre,Posicion posicion,int nivel){
		if(nombre == null || nombre.length() == 0)	
			return false;
		
		if(posicion == null)
			return false;
		
		if(nivel<1|| nivel>10)
			return false;
		
		return true;
	}
	
	public boolean mismaPosicion(Posicion posicion){
		return this.posicion.equals(posicion);
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
	
	@Override
	public Jugador clone(){
		return new Jugador(nombre, posicion,nivelJuego());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || obj.getClass() != this.getClass()) 
			return false;
		if(this == obj) 
			return true;
		Jugador otro = (Jugador) obj;
		if(this.nombre().equals(otro.nombre()) && this.nivelJuego() == otro.nivelJuego() && this.posicion().equals(otro.posicion())) 
			return true;
		return false;
	}
}