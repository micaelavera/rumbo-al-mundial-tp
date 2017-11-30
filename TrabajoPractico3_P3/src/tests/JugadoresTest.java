//package tests;
//
//import static org.junit.Assert.*;
//import inteligencia.Jugador;
//import inteligencia.Jugador.Posicion;
//import inteligencia.Jugadores;
//import org.junit.Test;
//import datos.IncompatiblesJSON;
//import datos.JugadoresJSON;
//
//public class JugadoresTest {
//
//	@Test(expected = IllegalArgumentException.class)
//	public void nivelDeJuegoNegativoTest(){
//		Jugadores jugadores=new Jugadores();
//		Jugador j1=new Jugador("Romero",Posicion.Arquero,-10);
//		jugadores.agregarJugador(j1);
//	}
//	
//	@Test(expected = IllegalArgumentException.class)
//	public void nivelDeJuegoExcedidoTest(){
//		Jugadores jugadores=new Jugadores();
//		Jugador j1=new Jugador("Romero",Posicion.Arquero,12);
//		jugadores.agregarJugador(j1);
//	}
//	
//	@Test
//	public void jugadorExistenteTest() {
//		Jugadores jugadores=new Jugadores();
//		Jugador j1=new Jugador("Romero",Posicion.Arquero,10);
//		jugadores.agregarJugador(j1);
//		assertTrue(jugadores.existeJugador(j1));
//	}
//	
//	@Test
//	public void jugadorInexistenteTest(){
//		Jugadores jugadores=new Jugadores();
//		Jugador j1=new Jugador("Romero",Posicion.Arquero,10);
//		jugadores.agregarJugador(j1);
//		assertFalse(jugadores.existeJugador(new Jugador("Messi",Posicion.Delantero,7)));
//	}
//	
//	@Test
//	public void eliminarJugadorExistenteTest(){
//		Jugadores jugadores=new Jugadores();
//		Jugador j1=new Jugador("Romero",Posicion.Arquero,10);
//		jugadores.agregarJugador(j1);
//		jugadores.eliminarJugador(j1);
//		assertFalse(jugadores.existeJugador(j1));
//	}
//	
//	@Test
//	public void eliminarJugadorTest(){
//		Jugadores jugadores=new Jugadores();
//		Jugador j1=new Jugador("Romero",Posicion.Arquero,10);
//		jugadores.agregarJugador(j1);
//		jugadores.eliminarJugador(j1);
//		assertEquals(0,jugadores.cantidadDeJugadores());
//	}
//	
//	@Test
//	public void verificarNivelDeJuegoTest(){
//		Jugadores jugadores=new Jugadores();
//		Jugador j1=new Jugador("Romero",Posicion.Arquero,10);
//		Jugador j2=new Jugador("Messi",Posicion.Delantero,10);
//		jugadores.agregarJugador(j1);
//		jugadores.agregarJugador(j2);
//		assertEquals(20,jugadores.getNivelJuegoTotal());
//	}
//	
//	
//	//FIXME: ver mas tests
////	@Test(expected = IllegalArgumentException.class)
////	public void eliminarJugadorConNivelDeJuegoNegativoTest(){
////		Jugadores jugadores=new Jugadores();
////		Jugador j1=new Jugador("Romero",Posicion.Arquero,-1);
////		jugadores.eliminarJugador(j1);
////	}
//	
////	@Test(expected = IllegalArgumentException.class)
////	public void eliminarJugadorConNivelDeJuegoExcedidoTest(){
////		Jugadores jugadores=new Jugadores();
////		Jugador j1=new Jugador("Romero",Posicion.Arquero,11);
////		jugadores.agregarJugador(j1);
////	}
////	
//
//}
