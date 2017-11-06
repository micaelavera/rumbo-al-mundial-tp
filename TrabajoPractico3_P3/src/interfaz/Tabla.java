package interfaz;

import java.util.ArrayList;

import inteligencia.Jugador;
import inteligencia.Jugadores;

import javax.swing.table.AbstractTableModel;

public class Tabla extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private String[] columnas = new String[]{"Nombre","Posicion","Nivel de juego","Jugador incompatible"};; 
	ArrayList<Jugador>jugadores;
	@SuppressWarnings("rawtypes")
	private Class[] tipoColumnas = new Class[] {Object.class, Object.class, Object.class, Object.class};;
	
	public Tabla(ArrayList<Jugador> arrayList){
		jugadores=arrayList;
	}
	
	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int columnIndex) {
			return tipoColumnas[columnIndex];
	}
	@Override
	public Object getValueAt(int fila, int columna) 
	{
		switch (columna)														//se cargan los datos dependiendo de su columna y fila
		{
			case 0:return jugadores.get(fila).nombre();
			case 1:return jugadores.get(fila).posicion();
			case 2:return jugadores.get(fila).nivelJuego();
			case 3:return jugadores.get(fila).incompatible();
			default:return null;
		}
	}

	
}
