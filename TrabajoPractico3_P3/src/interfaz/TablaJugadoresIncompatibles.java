package interfaz;

import java.util.ArrayList;

import inteligencia.Incompatibles;
import inteligencia.TuplaIncompatibles;

import javax.swing.table.AbstractTableModel;
import inteligencia.Jugador;

public class TablaJugadoresIncompatibles extends AbstractTableModel{
		
	private static final long serialVersionUID = 1L;
	private String[] columnas; 
	private ArrayList<TuplaIncompatibles<Jugador,Jugador>>inc;


	public TablaJugadoresIncompatibles(ArrayList<TuplaIncompatibles<Jugador,Jugador>>in){
		inc=in;
		columnas=new String[]{"Nombre del jugador","Nivel de juego","Posicion","Jugador incompatible","Nivel de juego","Posicion"};
		}
		
		@Override
		public int getColumnCount(){
			return columnas.length;
		}

		@Override
		public int getRowCount(){
			return inc.size();
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
				case 0:return inc.get(fila).getJugador1().nombre();
				case 1: return inc.get(fila).getJugador1().nivelJuego();
				case 2:return inc.get(fila).getJugador1().posicion();
				case 3:return inc.get(fila).getJugador2().nombre();
				case 4: return inc.get(fila).getJugador2().nivelJuego();
				case 5: return inc.get(fila).getJugador2().posicion();
//				case 2:return jugadores.get(fila).nivelJuego();
				default:return null;
			}
		}
			
	
}
