package interfaz;

import java.util.ArrayList;
import inteligencia.TuplaIncompatibles;
import javax.swing.table.AbstractTableModel;
import inteligencia.Jugador;

public class TablaJugadoresIncompatibles extends AbstractTableModel{
		
	private static final long serialVersionUID = 1L;
	private String[] columnas; 
	private ArrayList<TuplaIncompatibles<Jugador,Jugador>>incompatibles;


	public TablaJugadoresIncompatibles(ArrayList<TuplaIncompatibles<Jugador,Jugador>>incompatibles){
		this.incompatibles=incompatibles;
		columnas=new String[]{"Nombre del jugador","Nivel de juego","Posicion","Jugador incompatible","Nivel de juego","Posicion"};
		}
		
		@Override
		public int getColumnCount(){
			return columnas.length;
		}

		@Override
		public int getRowCount(){
			return incompatibles.size();
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
				case 0:return incompatibles.get(fila).jugador1().nombre();
				case 1: return incompatibles.get(fila).jugador1().nivelJuego();
				case 2:return incompatibles.get(fila).jugador1().posicion();
				case 3:return incompatibles.get(fila).jugador2().nombre();
				case 4: return incompatibles.get(fila).jugador2().nivelJuego();
				case 5: return incompatibles.get(fila).jugador2().posicion();
				default:return null;
			}
		}
			
	
}
