package interfaz;

import java.util.ArrayList;
import inteligencia.Jugador;
import javax.swing.table.AbstractTableModel;

public class TablaJugadores extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private String[] columnas; 
	private ArrayList<Jugador> jugadores;

	public TablaJugadores(ArrayList<Jugador> jugadores){
		this.jugadores=jugadores;
		columnas=new String[]{"Nombre","Posicion","Nivel de juego"};
	}
	
	@Override
	public int getColumnCount(){
		return columnas.length;
	}

	@Override
	public int getRowCount(){
		return jugadores.size();
	}
	
	@Override
	public String getColumnName(int columna){
		return columnas[columna];
	}
	
	@Override
	public boolean isCellEditable(int fila,int columna){
		return false;
	}
	
	@Override
	public Object getValueAt(int fila, int columna){
		switch (columna){											
			case 0:return jugadores.get(fila).nombre();
			case 1:return jugadores.get(fila).posicion();
			case 2:return jugadores.get(fila).nivelJuego();
			default:return null;
		}
	}
		
}
