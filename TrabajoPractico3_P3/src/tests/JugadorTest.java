package tests;

import static org.junit.Assert.*;
import inteligencia.Jugador;
import inteligencia.PosicionJuego.Posicion;

import org.junit.Test;

public class JugadorTest {
	
	//TODO: verificar las incompatibilidades

	@Test(expected=IllegalArgumentException.class)
	public void nivelDeJuegoNegativoTest() {
		@SuppressWarnings("unused")
		Jugador jugador=new Jugador("Romero",Posicion.Arquero,-2,"Jugador 2");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nivelDeJuegoPasadoDeRangoTest() {
		@SuppressWarnings("unused")
		Jugador jugador=new Jugador("Romero",Posicion.Arquero,11,"Jugador 2");
	}

	@Test
	public void verificarNombre(){
		Jugador jugador=new Jugador("Romero",Posicion.Arquero,10,"Jugador 2");
		assertEquals("Romero",jugador.nombre());
	}
	
	@Test
	public void verificarPosicion(){
		Jugador jugador=new Jugador("Romero",Posicion.Arquero,10,"Jugador 2");
		assertEquals(Posicion.Arquero,jugador.posicion());
	}
	
	

	

}