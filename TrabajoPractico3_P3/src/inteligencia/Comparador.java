package inteligencia;

import java.util.Comparator;

public class Comparador {

	public static Comparator<Jugador> porNivelDeJuego(){
		return (j1, j2) -> j1.nivelJuego()-j2.nivelJuego(); 
	}
}
