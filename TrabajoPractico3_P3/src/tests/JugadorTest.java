package tests;

import static org.junit.Assert.*;
import inteligencia.Jugador;
import inteligencia.Jugador.Posicion;
import org.junit.Test;

public class JugadorTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void nullTest(){
		@SuppressWarnings("unused")
		Jugador jugador=new Jugador(null,null,0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nivelDeJuegoNegativoTest() {
		@SuppressWarnings("unused")
		Jugador jugador=new Jugador("Romero",Posicion.Arquero,-2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nivelDeJuegoPasadoDeRangoTest() {
		@SuppressWarnings("unused")
		Jugador jugador=new Jugador("Romero",Posicion.Arquero,11);
	}

	@Test
	public void verificarNombre(){
		Jugador jugador=new Jugador("Romero",Posicion.Arquero,10);
		assertEquals("Romero",jugador.nombre());
	}
	
	@Test
	public void verificarPosicion(){
		Jugador jugador=new Jugador("Romero",Posicion.Arquero,10);
		assertEquals(Posicion.Arquero,jugador.posicion());
	}
	
	@Test
	public void verificarNivelDeJuego(){
		Jugador jugador=new Jugador("Romero",Posicion.Arquero,10);
		assertEquals(10,jugador.nivelJuego());
	}
}