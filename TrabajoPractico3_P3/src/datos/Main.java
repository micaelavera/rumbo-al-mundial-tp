package datos;

import java.util.Random;

import inteligencia.Jugador;
import inteligencia.Jugadores;
import inteligencia.PosicionJuego.Posicion;
import inteligencia.Solucion;
import inteligencia.Solver;

public class Main {

	public static void main(String[] args) {
//		JugadoresJson jugadores = new JugadoresJson() ;
	
		//FIXME: Pasar los jugadores del archivo JSON
		
		//URGENTE! 
		Jugadores jugadores=new Jugadores();
		jugadores.agregarJugador(new Jugador("Romero",Posicion.Arquero,10,"Mascherano"));
		jugadores.agregarJugador(new Jugador("Marchesin",Posicion.Arquero,5,"Otamendi"));
		jugadores.agregarJugador(new Jugador("Guzman",Posicion.Arquero,7,"Jugador2"));
		
		jugadores.agregarJugador(new Jugador("Mascherano",Posicion.Defensor,5,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Fazio",Posicion.Defensor,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Mercado",Posicion.Defensor,7,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Otamendi",Posicion.Defensor,6,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Pezzela",Posicion.Defensor,5,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Insua",Posicion.Defensor,3,"Jugador2"));
		
		jugadores.agregarJugador(new Jugador("Salvio",Posicion.Mediocampista,4,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Banega",Posicion.Mediocampista,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Acuña",Posicion.Mediocampista,8,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Paredes",Posicion.Mediocampista,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Rigoni",Posicion.Mediocampista,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Kranevitter",Posicion.Mediocampista,9,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Perotti",Posicion.Mediocampista,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Belluschi",Posicion.Mediocampista,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Perez",Posicion.Mediocampista,6,"Jugador2"));
		
		jugadores.agregarJugador(new Jugador("Messi",Posicion.Delantero,5,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Icardi",Posicion.Delantero,6,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Di Maria",Posicion.Delantero,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Dybala",Posicion.Delantero,4,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Benedetto",Posicion.Delantero,6,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Pavon",Posicion.Delantero,2,"Jugador2"));
		jugadores.agregarJugador(new Jugador("Aguero",Posicion.Delantero,2,"Jugador2"));
		
//		jugadores.generarGSON("jugadores.JSON");
		
		
		
//		JugadoresJson leidas = JugadoresJson.leerGSON("jugadores.JSON");
//		for(int i=0; i<leidas.cantidadDeJugadores(); ++i){
//			Jugador jugador = leidas.obtenerJugador(i);	
//			System.out.println(jugador.nombre() +" "+ jugador.posicion() + " " + jugador.nivelJuego()+ " " + jugador.incompatible());
//		}
		
//		Solver solver = new Solver(jugadores,algoritmo);
//		Solucion optima = solver.resolver();
//		System.out.println(optima);
		resolver(jugadores, Solver.Algoritmo.FuerzaBruta);
		resolver(jugadores, Solver.Algoritmo.BacktrackingOrdenado);
		
//		System.out.println();
//	}
}

private static void resolver(Jugadores instancia, Solver.Algoritmo algoritmo)
{
	Solver solver = new Solver(instancia, algoritmo);
	Solucion optima = solver.resolver();
	
	System.out.print(algoritmo);
	System.out.println(optima);
	System.out.println();
	}
}









