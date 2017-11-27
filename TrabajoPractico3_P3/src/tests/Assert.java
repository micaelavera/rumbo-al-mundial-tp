package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import inteligencia.Jugador;
import inteligencia.Solucion;

import java.util.Set;

class Assert
{
	public static void iguales(String[] esperados, Solucion solucion)
	{
		Set<Jugador> objetos = solucion.getJugadores();
		assertEquals(esperados.length, objetos.size());
		
		for(String nombre: esperados)
			assertTrue(contiene(objetos, nombre));
	}
	
	private static boolean contiene(Set<Jugador> objetos, String nombre)
	{
		for(Jugador obj: objetos)
		{
			if( obj.nombre().equals(nombre) )
				return true;
		}
		
		return false;
	}
}
