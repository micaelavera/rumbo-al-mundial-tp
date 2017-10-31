package inteligencia;

public class Jugador {

	private String nombre;
	private String posicion;
	private int nivelJuego;
	private String incompatible;
	
	public Jugador(String nombre,String posicion,int nivelJuego,String incompatible){
		this.nombre=nombre;
		this.posicion=posicion;
		this.nivelJuego=nivelJuego;
		this.incompatible=incompatible;
	}

	public String nombre(){
		return nombre;
	}

	public String posicion(){
		return posicion;
	}

	public int nivelJuego(){
		return nivelJuego;
	}

	public String incompatible(){
		return incompatible;
	}
	
}