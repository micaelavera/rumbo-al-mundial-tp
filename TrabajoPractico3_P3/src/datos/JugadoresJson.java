package datos;

import inteligencia.Jugador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JugadoresJson {
	
	ArrayList<Jugador> jugadores;
	
	public JugadoresJson(){
		jugadores=new ArrayList<Jugador>();
	}
	
	public void agregarJugador(Jugador jugador){
		jugadores.add(jugador);
	}
	
	public int cantidadDeJugadores(){
		return jugadores.size();
	}
	
	public Jugador obtenerJugador(int i){
		return jugadores.get(i);
	}

	public ArrayList<Jugador> getJugadores(){
		return jugadores;
	}
	
	public void generarGSON(String archivo){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);
		try{
			FileWriter writer = new FileWriter(archivo);
			writer.write(json);
			writer.close();
		} 
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static JugadoresJson leerGSON(String archivo){
		Gson gson = new Gson();
		JugadoresJson ret = null;
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, JugadoresJson.class);
		}
		catch(IOException e){
			throw new IllegalArgumentException("El sistema no puede encontrar el archivo especificado");
		}
		return ret;
	}
}