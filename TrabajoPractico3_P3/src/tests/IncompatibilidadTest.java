package tests;

import static org.junit.Assert.*;
import inteligencia.Incompatibilidad;
import inteligencia.Jugador;
import inteligencia.PosicionJuego.Posicion;
import org.junit.Test;

public class IncompatibilidadTest
{
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
}
