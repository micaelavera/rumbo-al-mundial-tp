package tests;

import static org.junit.Assert.*;
import inteligencia.Jugador;
import inteligencia.Jugadores;
import inteligencia.PosicionJuego.Posicion;

import org.junit.Test;

public class JugadoresTest {

	@Test
	public void agregarJugadorTest() {
		Jugadores jugadores=new Jugadores();
		Jugador j1=new Jugador("Romero",Posicion.Arquero,10);
		jugadores.agregarJugador(j1);
		assertTrue(jugadores.existeJugador(j1));
	}
	


}
