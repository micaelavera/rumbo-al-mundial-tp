package datos;

import inteligencia.Jugador;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		JugadoresJson jugadores = new JugadoresJson() ;
		jugadores.agregarJugador(new Jugador("Jugador 0","delantero",4,"Jugador 1"));
		jugadores.agregarJugador(new Jugador("Jugador 1","delantero",4,"Jugador 3"));
		jugadores.agregarJugador(new Jugador("Messi","defensor",5,"Liz"));

		jugadores.generarGSON("jugadores.JSON");
		
		JugadoresJson leidas = JugadoresJson.leerGSON("jugadores.JSON");
		
		for(int i=0; i<leidas.cantidadDeJugadores(); ++i)
		{
			Jugador jugador = leidas.obtenerJugador(i);
			
			System.out.println(jugador.nombre() +" "+ jugador.posicion() + " " + jugador.nivelJuego()+ " " + jugador.incompatible());
		}
	}

	}


