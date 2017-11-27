package inteligencia;

import java.util.ArrayList;

import datos.IncompatiblesJSON;

public class Incompatibilidad {

	private ArrayList<TuplaIncompatibles<Jugador, Jugador>> paresIncompatibles;
	
	public Incompatibilidad(){
		paresIncompatibles=new ArrayList<TuplaIncompatibles<Jugador,Jugador>>();
	}
	
	public void agregarPar(Jugador j1, Jugador j2){
		paresIncompatibles.add(new TuplaIncompatibles<Jugador, Jugador>(j1, j2));	
	}
	
	public void cargarJugadores(String archivo){
		try{
			IncompatiblesJSON incompatiblesJSON=IncompatiblesJSON.leerGSON(archivo);
			paresIncompatibles=incompatiblesJSON.getParesIncompatibles();
			
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("No se encuentra el listado de jugadores incompatibles: "+ archivo);
		}
	}
	
	public void entraUnodelPar(Jugadores jugadores){
		for(TuplaIncompatibles<Jugador, Jugador> TI: paresIncompatibles)
			if ( TI.jugador1.nivelJuego()> TI.jugador2.nivelJuego()) {
				jugadores.eliminarJugador(TI.jugador2);
			}else{
				jugadores.eliminarJugador(TI.jugador1);
			}
	}
	
	public boolean pertenecePar(Jugador j1, Jugador j2){
		for(TuplaIncompatibles<Jugador, Jugador> TI: paresIncompatibles)
			if(TI.jugador1.equals(j1) && TI.jugador2.equals(j2)  )
				return true;
			else{
					for(TuplaIncompatibles<Jugador, Jugador> Ti: paresIncompatibles)
						if(TI.jugador1.equals(j2) && TI.jugador2.equals(j1)  )
							return true;
				}
		return false;
			
	}

		public boolean esIncompatible(Jugador j1,Jugador j2)
		{
			if (pertenecePar(j1, j2) ) return true;
		return false;
		}

	public
 ArrayList<TuplaIncompatibles<Jugador, Jugador>> getParesIncompatibles() {
		return paresIncompatibles;
	}
	
	@Override
	public String toString(){
		String ret="";
		for(TuplaIncompatibles<Jugador, Jugador> TI: paresIncompatibles){
			ret+="\n"+TI.jugador1.nombre()+" "+TI.jugador1.nivelJuego()+" "+TI.jugador2.nombre()+" " +TI.jugador2.nivelJuego();
		}
		return ret;
	}
	
	
}
