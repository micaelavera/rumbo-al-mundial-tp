package inteligencia;

import java.util.ArrayList;
import datos.IncompatiblesJSON;

public class Incompatibles {

	private ArrayList<TuplaIncompatibles<Jugador, Jugador>> ParesIncompatibles;
	
	public Incompatibles(){
		ParesIncompatibles=new ArrayList<TuplaIncompatibles<Jugador,Jugador>>();
	}
	
	public void agregarPar(Jugador j1, Jugador j2){
		ParesIncompatibles.add(new TuplaIncompatibles<Jugador, Jugador>(j1, j2) );	
	}
	
	public void cargarJugadores(String archivo){
		try{
			IncompatiblesJSON incompatiblesJSON= IncompatiblesJSON.leerGSON(archivo);
			ParesIncompatibles=incompatiblesJSON.getParesIncompatibles();
			
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("No se encuentra el listado de materias con nombre: "+ archivo);
		}
	}
	
	public void entraUnodelPar(Jugadores jugadores){
		for(TuplaIncompatibles<Jugador, Jugador> TI: ParesIncompatibles)
			if ( TI.jugador1.nivelJuego()> TI.jugador2.nivelJuego() ) 
			{
				jugadores.eliminarJugador(TI.jugador2);
			}else{
				jugadores.eliminarJugador(TI.jugador1);
			}
	}

	public ArrayList<TuplaIncompatibles<Jugador, Jugador>> getParesIncompatibles() {
		return ParesIncompatibles;
	}
	
	@Override
	public String toString() 
	{
		String ret="\nPares de Incompatibles: ";
		for(TuplaIncompatibles<Jugador, Jugador> TI: ParesIncompatibles){
			ret+="\n"+TI.jugador1.nombre()+" "+TI.jugador1.nivelJuego()+" "+TI.jugador2.nombre()+" ";
		}
		return ret;
	}
	
	
}
