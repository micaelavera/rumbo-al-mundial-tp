package inteligencia;

import inteligencia.PosicionJuego.Posicion;


public class Formacion {
	
	
	
	
	
	
//	public boolean verificar(Jugadores jugadores){
//		boolean ret=false;
//		if(!verificarFormacionPedida(jugadores)){
//			ret=true;
//		}
//		return ret;
//	}
//	
	
	
	
	
	

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

	private int nivelDeJuegoTotal(Jugadores jugadores){
		int puntaje=0;
		for(Jugador jugador: jugadores.getJugadores()){
			puntaje+=jugador.nivelJuego();
		}
		return puntaje;
	}

//	public boolean verificarIncompatibilidades(Jugadores jugadores){
//		for(Jugador jugador :jugadores.getJugadores()){
//			if(jugador.incompatible con )
//		}
//	}
	}
