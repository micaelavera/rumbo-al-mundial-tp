package inteligencia;
//
import java.util.ArrayList;
import java.util.Collections;

import datos.JugadoresJson;

public class Solver{

	private ArrayList<Jugador> _jugadores;
	private enum Algoritmo{BacktrackingOrdenado,FuerzBruta};
	
	
	public Solver(){
	_jugadores=new ArrayList<Jugador>();
}
	
	public void cargarJugadores(String archivo){
		try{
			JugadoresJson jugadoresJson= JugadoresJson.leerGSON(archivo);
			_jugadores=jugadoresJson.getJugadores();
			
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("No se encuentra el listado de materias con nombre: "+ archivo);
		}
	}

	public void ordenarJugadores(){
		Collections.sort(_jugadores, Comparador.porNivelDeJuego());
		Collections.reverse(_jugadores);
	}
	
	
	public ArrayList<Jugador> get_jugadores() {
		return _jugadores;
	}
}

//	public Jugadores resolver()
//	{
//		
//		if( _algoritmo == Algoritmo.BacktrackingOrdenado )
//			ordenarObjetos(); // De mayor a menor peso
//		
//		_solucion = new Solucion();
//		_incumbente = new Solucion();
//		generarDesde(0);
//
//		finalizarEstadisticas();
//		return _incumbente;
//	}
//}
