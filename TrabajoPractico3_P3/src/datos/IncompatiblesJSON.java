package datos;

import inteligencia.Jugador;
import inteligencia.TuplaIncompatibles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class IncompatiblesJSON {

	private ArrayList<TuplaIncompatibles<Jugador, Jugador>> paresIncompatibles;

	public IncompatiblesJSON(){
		paresIncompatibles=new ArrayList<TuplaIncompatibles<Jugador,Jugador>>();
	}
	
	public void agregarPar(Jugador j1,Jugador j2){
		paresIncompatibles.add(new TuplaIncompatibles<Jugador, Jugador>(j1, j2) );
	}

	public ArrayList<TuplaIncompatibles<Jugador, Jugador>> getParesIncompatibles() {
		return paresIncompatibles;
	}
	
	public void generarIncompatiblesGSON(String archivo){
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
	
	public static IncompatiblesJSON leerGSON(String archivo){
		Gson gson = new Gson();
		IncompatiblesJSON ret = null;
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, IncompatiblesJSON.class);
		}
		catch(IOException e){
			throw new IllegalArgumentException("El sistema no puede encontrar el archivo especificado");
		}
		catch(JsonSyntaxException e){
			throw new IllegalArgumentException("El tipo de archivo no corresponde al formato JSON");
		}
		return ret;
	}
}