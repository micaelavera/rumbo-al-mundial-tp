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
//	_jugadores=new ArrayList<Jugador>();
		_algoritmo=algoritmo;
		_jugadores=instancia.getJugadores();
}
//	
//	public void cargarJugadores(String archivo){
//		try{
//			JugadoresJson jugadoresJson= JugadoresJson.leerGSON(archivo);
//			_jugadores=jugadoresJson.getJugadores();
//			
//		}catch(IllegalArgumentException e){
//			throw new IllegalArgumentException("No se encuentra el listado de materias con nombre: "+ archivo);
//		}
//	}

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
	
	public void generarDesde(int i)
	{
		if( i == _instancia.cantidadDeJugadores() )
		{
			// Caso base de la recursión
			if( esFactible(_solucion) && esMejor(_solucion, _incumbente))
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
//		else
//		{
//			_podas++;
//		}
//		
//		_nodos++;
	}
	
	
	private static boolean verificarFormacionPedida(Jugadores jugadores){
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
		return solucion.cantidadDeJugadores() <= _instancia.getCantidadDeJugadores(); 
	}
	
	
	private boolean esMejor(Solucion solucion, Solucion otra)
	{
		return solucion.nivelJuego() > otra.nivelJuego();
	}

}
