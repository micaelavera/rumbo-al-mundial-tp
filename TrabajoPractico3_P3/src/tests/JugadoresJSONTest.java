package tests;

import static org.junit.Assert.*;
import inteligencia.Jugador;
import inteligencia.Jugadores;
import inteligencia.Jugador.Posicion;

import org.junit.Test;

import datos.JugadoresJSON;

public class JugadoresJSONTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void archivoJsonInvalidoTest() {
		JugadoresJSON json = new JugadoresJSON();
		json.agregarJugador(new Jugador("Romero",Posicion.Arquero,10));
		json.generarGSON("jugadoresTest.JSON");
		
		Jugadores jugadores=new Jugadores();
		jugadores.cargarJugadores("jugadoresT.JSON");
	}
	
//	@Test
//	public void cargaJugadoTest() {
//		JugadoresJson json = new JugadoresJson();
//		json.agregarJugador(new Jugador("Romero",Posicion.Arquero,10));
//		json.generarGSON("jugadoresTest.JSON");
//		
//		assertEquals(1,JugadoresJson.leerGSON("jugadoresTest.JSON").cantidadDeJugadores());
//	}
//	
	//FIXME: FIJARSE
//	@Test
//	public void cargaJugadoresTest() {
//		JugadoresJson json = new JugadoresJson();
//		json.agregarJugador(new Jugador("Romero",Posicion.Arquero,10));
//		json.generarGSON("jugadoresTest.JSON");
//		
//		Jugadores jugadores=new Jugadores();
//		jugadores.cargarJugadores("jugadoresTest.JSON");
//		
//		assertEquals(1,jugadores.cantidadDeJugadores());
//	}
	
//	@Test
//	public void cargandoJugadoresTest() {
//		JugadoresJson json = new JugadoresJson();
//		json.agregarJugador(new Jugador("Romero",Posicion.Arquero,10));
//		json.generarGSON("jugadoresTest.JSON");
//		
//		Jugadores jugadores=new Jugadores();
//		jugadores.cargarJugadores("jugadoresTest.JSON");
//		
//		
//		assertEquals(new Jugador("Romero",Posicion.Arquero,10), jugadores.getJugador(0));
//	
//	}
	

}
