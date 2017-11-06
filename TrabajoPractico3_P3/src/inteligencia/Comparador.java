package inteligencia;

import java.util.Comparator;

public class Comparador {

	public static Comparator<Jugador> porNivelDeJuego(){
		return (uno, otro) -> uno.nivelJuego()-otro.nivelJuego(); 
	}
}
