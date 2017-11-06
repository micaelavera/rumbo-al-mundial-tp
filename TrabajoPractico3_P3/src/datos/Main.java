package datos;

import java.util.Random;

import inteligencia.Jugador;
import inteligencia.PosicionJuego.Posicion;

public class Main {

	public static void main(String[] args) {
		JugadoresJson jugadores = new JugadoresJson() ;
	

		jugadores.agregarJugador(new Jugador("Romero",Posicion.Arquero,4,"Jugador 1"));
		jugadores.agregarJugador(new Jugador("Marchesin",Posicion.Arquero,5,"Jugador 3"));
		jugadores.agregarJugador(new Jugador("Guzman",Posicion.Arquero,7,"Jugador2"));
		
		jugadores.agregarJugador(new Jugador("Mascherano",Posicion.Defensor,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Fazio",Posicion.Defensor,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Mercado",Posicion.Defensor,7,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Otamendi",Posicion.Defensor,6,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Pezzela",Posicion.Defensor,5,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Insua",Posicion.Defensor,3,"Jugador2"));
		
		jugadores.agregarJugador(new Jugador("Salvio",Posicion.Mediocampista,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Banega",Posicion.Mediocampista,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Acuña",Posicion.Mediocampista,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Paredes",Posicion.Mediocampista,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Rigoni",Posicion.Mediocampista,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Kranevitter",Posicion.Mediocampista,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Perotti",Posicion.Mediocampista,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Belluschi",Posicion.Mediocampista,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Perez",Posicion.Mediocampista,2,"Jugador2"));
		
		jugadores.agregarJugador(new Jugador("Messi",Posicion.Delantero,5,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Icardi",Posicion.Delantero,6,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Di Maria",Posicion.Delantero,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Dybala",Posicion.Delantero,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Benedetto",Posicion.Delantero,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Pavon",Posicion.Delantero,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Aguero",Posicion.Delantero,2,"Jugador2"));
		
		jugadores.generarGSON("jugadores.JSON");
		
//		JugadoresJson leidas = JugadoresJson.leerGSON("jugadores.JSON");
//		for(int i=0; i<leidas.cantidadDeJugadores(); ++i){
//			Jugador jugador = leidas.obtenerJugador(i);	
//			System.out.println(jugador.nombre() +" "+ jugador.posicion() + " " + jugador.nivelJuego()+ " " + jugador.incompatible());
//		}
	}
	
	
	

}