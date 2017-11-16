package inteligencia;

import java.io.Serializable;


import inteligencia.PosicionJuego.Posicion;

public class Jugador implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private Posicion posicion;
	private int nivelJuego;
//	private String incompatible;
	public Jugador incompatible;  //Lizz estuvo aqui
	
	
	
//	public Jugador(String nombre,Posicion posicion,int nivelJuego,String incompatible){
//		verificarNivelDeJuego(nivelJuego);
//		
//		this.nombre=nombre;
//		this.posicion=posicion;
//		this.nivelJuego=nivelJuego;
//		this.incompatible=incompatible;
//		
//		
//	}
	
	
	//Lizz estuvo aqui
//	public Jugador(String nombre,Posicion posicion,int nivelJuego, Jugador incompatible)
//	{
//		verificarNivelDeJuego(nivelJuego);
//		this.nombre=nombre;
//		this.posicion=posicion;
//		this.nivelJuego=nivelJuego;
//		this.incompatible=incompatible;
//		
//	}
	//pruebas
	
	//Lizz estuvo aqui
	public Jugador(String nombre,Posicion posicion, int nivelJuego)
	{
		this.nombre=nombre;
		this.posicion=posicion;
		this.nivelJuego=nivelJuego;
	
		
	}
	
	

	public void verificarNivelDeJuego(int nivelDeJuego) {
		if(nivelDeJuego < 0 || nivelDeJuego > 10 )
			throw new IllegalArgumentException("Se intento agregar un jugador con un nivel de juego fuera de rango.");
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

//	public String incompatible(){
//		return incompatible;
//	}
	
//	public String incompatible() //Liz estuvo aqui
//	{
//	return incompatible.nombre;
//}
}