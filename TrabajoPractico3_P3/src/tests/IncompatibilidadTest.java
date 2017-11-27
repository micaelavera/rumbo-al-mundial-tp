package tests;

import static org.junit.Assert.*;
import inteligencia.Incompatibilidad;
import inteligencia.Jugador;
import inteligencia.Jugadores;
import inteligencia.PosicionJuego.Posicion;

import org.junit.Test;

public class IncompatibilidadTest{
	@Test 
	public void verificarIncompatibleTest(){
		Incompatibilidad jugadores=new  Incompatibilidad();
		Jugador jugador1=new Jugador("Romero",Posicion.Arquero,10);
		Jugador jugador2=new Jugador("Mascherano",Posicion.Defensor,5);
		Jugador jugador3=new Jugador("mica",Posicion.Defensor,5);
		jugadores.agregarPar(jugador1, jugador2);
		jugadores.agregarPar(jugador1, jugador3);
		assertEquals(true,jugadores.esIncompatible(jugador1,jugador2));
		assertEquals(false,jugadores.esIncompatible(jugador3,jugador2));
		
	}
	
//	
	@Test
	public void eliminarJugadoresTest(){
		Jugadores jugadores = instancia();
		Incompatibilidad incompatibles=new Incompatibilidad();
		incompatibles.agregarPar(jugadores.getJugador(0), jugadores.getJugador(3));
		
		assertEquals(7,jugadores.cantidadDeJugadores());
		
	}

private Jugadores instancia() {
	Jugadores jugadores=new Jugadores();
	jugadores.agregarJugador(new Jugador("Romero",Posicion.Arquero,10));
	jugadores.agregarJugador(new Jugador("Mascherano",Posicion.Defensor,5)); //posicion 3
	jugadores.agregarJugador(new Jugador("Fazio",Posicion.Defensor,2)); //posicion 4
	jugadores.agregarJugador(new Jugador("Mercado",Posicion.Defensor,7));
	jugadores.agregarJugador(new Jugador("Messi",Posicion.Delantero,9)); //posicion 18
	jugadores.agregarJugador(new Jugador("Icardi",Posicion.Delantero,6)); //posicion 19
	jugadores.agregarJugador(new Jugador("Di Maria",Posicion.Delantero,5));
	return jugadores;
}
}
