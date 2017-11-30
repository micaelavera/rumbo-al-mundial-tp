//package tests;
//
//import static org.junit.Assert.*;
//import java.util.ArrayList;
//import inteligencia.Incompatibilidad;
//import inteligencia.Jugador;
//import inteligencia.Jugador.Posicion;
//import inteligencia.Jugadores;
//import org.junit.Test;
//
//public class IncompatibilidadTest{
//	
//	@Test(expected=IllegalArgumentException.class)
//	public void incompatibilidadesNullTest(){
//		Incompatibilidad incompatibilidades=new Incompatibilidad();
//		incompatibilidades.agregarPar(null, null);
//	}
//	
//	@Test(expected=IllegalArgumentException.class)
//	//FIXME: VER NOMBRE DEL METODO
//		public void incompatiblesTest(){
//		Incompatibilidad incompatibilidades=new Incompatibilidad();
//		Jugador Romero=new Jugador("Romero",Posicion.Arquero,10);
//		incompatibilidades.agregarPar(Romero, Romero);
//	}
//	
//	@Test 
//	public void verificarIncompatibleTest(){
//		Incompatibilidad jugadores=new  Incompatibilidad();
//		Jugador Romero=new Jugador("Romero",Posicion.Arquero,10);
//		Jugador Mascherano=new Jugador("Mascherano",Posicion.Defensor,5);
//		
//		jugadores.agregarPar(Romero, Mascherano);
//		assertTrue(jugadores.sonIncompatibles(Romero,Mascherano));
//	}
//	
//	@Test 
//	public void verificarCompatiblesTest(){
//		Incompatibilidad jugadores=new  Incompatibilidad();
//		Jugador Romero=new Jugador("Romero",Posicion.Arquero,10);
//		Jugador Mascherano=new Jugador("Mascherano",Posicion.Defensor,5);
//		Jugador Messi=new Jugador("Messi",Posicion.Delantero,7);
//		jugadores.agregarPar(Romero, Mascherano);
//		assertFalse(jugadores.sonIncompatibles(Romero,Messi));
//	}
//	
//	@Test
//	public void verificarIncompatiblesTest(){
//		Incompatibilidad jugadores=new  Incompatibilidad();
//		Jugador Romero=new Jugador("Romero",Posicion.Arquero,10);
//		Jugador Mascherano=new Jugador("Mascherano",Posicion.Defensor,5);
//		Jugador Messi=new Jugador("Messi",Posicion.Delantero,7);
//		jugadores.agregarPar(Romero, Mascherano);
//		jugadores.agregarPar(Messi, Romero);
//
//		Jugadores j=new Jugadores();
//		j.agregarJugador(Mascherano);
//		j.agregarJugador(Messi);
////FIXME: debe dar equals con los jugadores Mascherano y Messi con la cantidad de jugadores incompatibles	
//		iguales(j.getJugadores(),jugadores.jugadoresIncompatibles(Romero));
//	}
//	
//	
//		public static void iguales(ArrayList<Jugador> jugadores, ArrayList<Jugador>incompatibles){
//			assertEquals(jugadores.size(),incompatibles.size());
//			for(Jugador elemento: incompatibles)
//				assertTrue(jugadores.contains(elemento));
//		}
//		
//}
//	
//	
//	
//	
//	
//////	
////	@Test
////	public void eliminarJugadoresTest(){
////		Jugadores jugadores = instancia();
////		Incompatibilidad incompatibles=new Incompatibilidad();
////		incompatibles.agregarPar(jugadores.getJugador(0), jugadores.getJugador(3));
////		
////		assertEquals(7,jugadores.cantidadDeJugadores());
////		
////	}
//
////private Jugadores instancia() {
////	Jugadores jugadores=new Jugadores();
////	jugadores.agregarJugador(new Jugador("Romero",Posicion.Arquero,10));
////	jugadores.agregarJugador(new Jugador("Mascherano",Posicion.Defensor,5)); //posicion 3
////	jugadores.agregarJugador(new Jugador("Fazio",Posicion.Defensor,2)); //posicion 4
////	jugadores.agregarJugador(new Jugador("Mercado",Posicion.Defensor,7));
////	jugadores.agregarJugador(new Jugador("Messi",Posicion.Delantero,9)); //posicion 18
////	jugadores.agregarJugador(new Jugador("Icardi",Posicion.Delantero,6)); //posicion 19
////	jugadores.agregarJugador(new Jugador("Di Maria",Posicion.Delantero,5));
////	return jugadores;
////}
//
