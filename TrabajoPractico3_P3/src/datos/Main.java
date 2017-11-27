package datos;

import inteligencia.Incompatibilidad;
import inteligencia.Jugador;
import inteligencia.Jugadores;
import inteligencia.PosicionJuego.Posicion;

public class Main {

	public static void main(String[] args) {
//		JugadoresJson jugadores= new JugadoresJson();
		Jugadores jugadores=new Jugadores();
		jugadores.agregarJugador(new Jugador("Romero",Posicion.Arquero,10)); //posicion 0
		jugadores.agregarJugador(new Jugador("Marchesin",Posicion.Arquero,5)); //posicion 1
		jugadores.agregarJugador(new Jugador("Guzman",Posicion.Arquero,7)); //posicion 2
		
		jugadores.agregarJugador(new Jugador("Mascherano",Posicion.Defensor,5)); //posicion 3
		jugadores.agregarJugador(new Jugador("Fazio",Posicion.Defensor,2)); //posicion 4
		jugadores.agregarJugador(new Jugador("Mercado",Posicion.Defensor,7)); //posicion 5
		jugadores.agregarJugador(new Jugador("Otamendi",Posicion.Defensor,6)); //posicion 6
		jugadores.agregarJugador(new Jugador("Pezzela",Posicion.Defensor,8)); //posicion 7
		jugadores.agregarJugador(new Jugador("Insua",Posicion.Defensor,3)); //posicion 8
		
		jugadores.agregarJugador(new Jugador("Salvio",Posicion.Mediocampista,4)); //posicion 9
		jugadores.agregarJugador(new Jugador("Banega",Posicion.Mediocampista,2)); //posicion 10
		jugadores.agregarJugador(new Jugador("Acuna",Posicion.Mediocampista,8)); //posicion 11
		jugadores.agregarJugador(new Jugador("Paredes",Posicion.Mediocampista,2)); //posicion 12
		jugadores.agregarJugador(new Jugador("Rigoni",Posicion.Mediocampista,2)); //posicion 13
		jugadores.agregarJugador(new Jugador("Kranevitter",Posicion.Mediocampista,9)); //posicion 14
		jugadores.agregarJugador(new Jugador("Perotti",Posicion.Mediocampista,5)); //posicion 15
		jugadores.agregarJugador(new Jugador("Belluschi",Posicion.Mediocampista,5)); //posicion 16
		jugadores.agregarJugador(new Jugador("Perez",Posicion.Mediocampista,6)); //posicion 17
		
		jugadores.agregarJugador(new Jugador("Messi",Posicion.Delantero,9)); //posicion 18
		jugadores.agregarJugador(new Jugador("Icardi",Posicion.Delantero,6)); //posicion 19
		jugadores.agregarJugador(new Jugador("Di Maria",Posicion.Delantero,5)); //posicion 20
		jugadores.agregarJugador(new Jugador("Dybala",Posicion.Delantero,4)); //posicion 21
		jugadores.agregarJugador(new Jugador("Benedetto",Posicion.Delantero,3)); //posicion 22
		jugadores.agregarJugador(new Jugador("Pavon",Posicion.Delantero,7)); //posicion 23
		jugadores.agregarJugador(new Jugador("Aguero",Posicion.Delantero,5)); //posicion 24
		
//		jugadores.generarGSON("jugadores.JSON");
		
		System.out.println(jugadores.toString());
		
		System.out.println();
//		IncompatiblesJSON incompatibles=new IncompatiblesJSON();
		Incompatibilidad incompatibles=new Incompatibilidad();
//		//Arqueros y sus incompatibles
		incompatibles.agregarPar(jugadores.getJugador(0), jugadores.getJugador(3)); // Romero incompatible a Mascherano
		incompatibles.agregarPar(jugadores.getJugador(1), jugadores.getJugador(2)); //  Marchesin incompatible a  Otamendi
		incompatibles.agregarPar(jugadores.getJugador(2), jugadores.getJugador(17)); // Guzman incompatible a Perez
		
//		//Defensores y sus incompatibles
		incompatibles.agregarPar(jugadores.getJugador(3), jugadores.getJugador(9)); // Mascherano incompatible a Silvio
		incompatibles.agregarPar(jugadores.getJugador(4), jugadores.getJugador(13)); //  Fazio incompatible a Rigoni
		incompatibles.agregarPar(jugadores.getJugador(6), jugadores.getJugador(2)); // Otamendi incompatible a Guzman
//		
//		//Mediocampistas y sus incompatibles
		incompatibles.agregarPar(jugadores.getJugador(9), jugadores.getJugador(19)); // Salvio incompatible a Icardi
//		i.agregarPar(jugadores.getJugador(10), jugadores.getJugador(18)); // Banega incompatible a  Messi
		incompatibles.agregarPar(jugadores.getJugador(2), jugadores.getJugador(17)); // Guzman incompatible a Perez
		
//		//Delanteros y sus incompatibles
//		i.agregarPar(jugadores.getJugador(18), jugadores.getJugador(19)); // Messi incompatible a Icardi
//		i.agregarPar(jugadores.getJugador(21), jugadores.getJugador(17)); // Dybala incompatible a Perez
//		i.agregarPar(jugadores.getJugador(22), jugadores.getJugador(23)); // Benedetto incompatible a Pavon
////		i.agregarPar(jugadores.getJugador(23), jugadores.getJugador(24)); // Pavon incompatible a Aguero
////		i.agregarPar(jugadores.getJugador(24), jugadores.getJugador(22)); // Aguero incompatible a Di Maria
//		
		System.out.println(incompatibles.toString());
		incompatibles.entraUnodelPar(jugadores);
		System.out.println();
System.out.println(jugadores.toString());
//		incompatibles.generarIncompatiblesGSON("incompatibles.JSON");
		
////		Solver solver= new Solver (jugadores,algoritmo);
////		Solucion optima=solver.resolver();
//		resolver(jugadores,Solver.Algoritmo.BacktrackingOrdenado);
//
//	}
//	private static void resolver(Jugadores instancia, Solver.Algoritmo algoritmo){
//		Solver solver = new Solver(instancia, algoritmo);
//		Solucion optima = solver.resolver();
//		
//		
//		System.out.print("\n"+algoritmo+"\n"+"\n");
//		System.out.println(optima);
//		System.out.println();
	}
}



