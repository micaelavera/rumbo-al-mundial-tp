package inteligencia;

import inteligencia.PosicionJuego.Posicion;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
//
//import datos.JugadoresJson;
import inteligencia.Incompatibles;

public class Solver{

	private ArrayList<Jugador> _jugadores;
	private Jugadores _instancia;
	private Solucion _solucion;
	private Solucion _incumbente;
	public enum Algoritmo{BacktrackingOrdenado,FuerzaBruta};
	private Algoritmo _algoritmo;
	
	
//	ArrayList<TuplaIncompatibles<Jugador, Jugador>> ParesIncompatibles;
	
	public Solver(Jugadores instancia,Algoritmo algoritmo){
		_instancia=instancia;
		_algoritmo=algoritmo;
		_jugadores=_instancia.getJugadores();
		
//		ParesIncompatibles= new ArrayList<TuplaIncompatibles<Jugador,Jugador>>();
		
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
			// Caso base de la recursi�n
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
		for(Jugador jugador: jugadores.getJugadores()){
			puntaje+=jugador.nivelJuego();
		}
		return puntaje;
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
	
	private boolean esFactible(Solucion solucion)
	{
		return solucion.cantidadDeJugadores()<= _instancia.getCantidadDeJugadores(); 
	}
	
	
	private boolean esMejor(Solucion solucion, Solucion otra)
	{
		return solucion.nivelJuego() > otra.nivelJuego();
	}
	//Lizz estuvo aqui
	// Prestar atencion. aca serviria preguntatar en ParesIncompatibles o directamente ej jugadores?
	
	public boolean pertenece(Jugador j1) 
	{
		return _jugadores.contains(j1);
	}
	//Lizz estuvo aqui
	//Me sirve para utilizar si pertenece el par de incompatibles de forma simetrica
	
//	private boolean pertenecePar(Jugador j1, Jugador j2)
//	{
//				//Ver si se hace un pertenece para que la guarda no sea larga
//				if(ParesIncompatibles.contains(new TuplaIncompatibles<Jugador, Jugador>(j1, null) ) )
//				{
//					for(TuplaIncompatibles<Jugador, Jugador> TI: ParesIncompatibles)
//						if(TI.jugador2.equals(j2) )
//							return true;
//				}else{
//						if(ParesIncompatibles.contains(new TuplaIncompatibles<Jugador, Jugador>(j1, null) ) )
//						{
//						for(TuplaIncompatibles<Jugador, Jugador> TI: ParesIncompatibles)
//							if(TI.jugador1.equals(j1) )
//								return true;
//						}
//					}
//				return false;
//			
//	}
//	//Lizz estuvo aqui
//	public void agregarPar(Jugador j1, Jugador j2)
//	{
//		if(!pertenecePar(j1, j2))
//			ParesIncompatibles.add(new TuplaIncompatibles<Jugador, Jugador>(j1, j2) );
//	}
//	
//	//Lizz estuvo aqui revisar si esto sirve porque quizas no serviria la condicion de preguntar el incompatible de j1  es j2
//	private boolean esIncompatible(Jugador j1,Jugador j2)
//	{
//		if (pertenecePar(j1, j2) )
//		{	if(j1.incompatible.equals(j2))
//				return true;
//		}else{ 
//				if (pertenecePar(j1, j2) ) //Realmente es necesario el 2do if? ya que en pertenece par se fija en los dos j1, j2 
//				{	if(j2.incompatible.equals(j1))// yo creo que si: Liz.
//						return true;
//				}
//			
//			}
//		return false;
//	}
//	//Liz 
//	private void  entraUnodelPar()
//	{
//		for(TuplaIncompatibles<Jugador, Jugador> TI: ParesIncompatibles)
//			if (pertenece(TI.jugador1) &&  TI.jugador1.nivelJuego()>= TI.jugador2.nivelJuego() ) 
//			{
//				_jugadores.add(TI.jugador1);
//			
//				_jugadores.remove(TI.jugador2);
//			}
//			else
//			{
//					_jugadores.add(TI.jugador2);
//				
//					_jugadores.remove(TI.jugador1);
//				
//			}
//			
//	}
	
	

}
