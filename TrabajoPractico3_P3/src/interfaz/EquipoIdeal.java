package interfaz;

import imagenes.Fondo;
import inteligencia.Jugador;
import inteligencia.Jugadores;
import inteligencia.PosicionJuego.Posicion;
import inteligencia.Solucion;
import inteligencia.Solver;
import inteligencia.Solver.Algoritmo;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;

public class EquipoIdeal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Fondo fondo_2;
	private Solver solver;
	private Solver jugadoresSolver;
	private Jugadores jugadores;
	Jugadores inst;
	Solucion solucion;
	
	private JTextField arquero;
	private JTextField defensor1;
	private JTextField defensor2;
	private JTextField defensor3;
	private JTextField defensor4;
	private JTextField mediocampista1;
	private JTextField mediocampista2;
	private JTextField mediocampista3;
	private JTextField delantero1;
	private JTextField delantero2;
	private JTextField delantero3;
	
	public static void main(String[] args) {
		try {
			EquipoIdeal dialog = new EquipoIdeal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public EquipoIdeal(){
		setTitle("Rumbo al mundial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Equipo.class.getResource("/imagenes/pelota.png")));
		setBounds(250, 100, 800, 550);
		getContentPane().setLayout(null);

		jugadores=new Jugadores();
		jugadores.cargarJugadores("jugadores.JSON");

		
		 solver = new Solver(jugadores, Algoritmo.BacktrackingOrdenado);
		Solucion optima = solver.resolver();
//		System.out.println(optima);

		ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
		jugadores=solver.ListasDePosiciones(optima);
		
		fondo_2 = new Fondo();
		fondo_2.setBackground(Color.BLACK);
		fondo_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(fondo_2);
		fondo_2.setLayout(null);
		
		arquero = new JTextField(jugadores.get(0).nombre());
		arquero.setBackground(new Color(0, 100, 0));
		arquero.setForeground(new Color(255, 255, 255));
		arquero.setBounds(41, 232, 86, 20);
		fondo_2.add(arquero);
		arquero.setColumns(10);
		
		defensor1 = new JTextField(jugadores.get(1).nombre());
		defensor1.setForeground(Color.WHITE);
		defensor1.setColumns(10);
		defensor1.setBackground(new Color(0, 100, 0));
		defensor1.setBounds(209, 52, 86, 20);
		fondo_2.add(defensor1);
		
		defensor2 = new JTextField(jugadores.get(2).nombre());
		defensor2.setForeground(Color.WHITE);
		defensor2.setColumns(10);
		defensor2.setBackground(new Color(0, 100, 0));
		defensor2.setBounds(209, 159, 86, 20);
		fondo_2.add(defensor2);
		
		defensor3 = new JTextField(jugadores.get(3).nombre());
		defensor3.setForeground(Color.WHITE);
		defensor3.setColumns(10);
		defensor3.setBackground(new Color(0, 100, 0));
		defensor3.setBounds(209, 280, 86, 20);
		fondo_2.add(defensor3);
		
		defensor4 = new JTextField(jugadores.get(4).nombre());
		defensor4.setForeground(Color.WHITE);
		defensor4.setColumns(10);
		defensor4.setBackground(new Color(0, 100, 0));
		defensor4.setBounds(209, 385, 86, 20);
		fondo_2.add(defensor4);
		
		mediocampista1 = new JTextField(jugadores.get(5).nombre());
		mediocampista1.setForeground(Color.WHITE);
		mediocampista1.setColumns(10);
		mediocampista1.setBackground(new Color(0, 100, 0));
		mediocampista1.setBounds(376, 99, 86, 20);
		fondo_2.add(mediocampista1);
		
		mediocampista2 = new JTextField(jugadores.get(6).nombre());
		mediocampista2.setForeground(Color.WHITE);
		mediocampista2.setColumns(10);
		mediocampista2.setBackground(new Color(0, 100, 0));
		mediocampista2.setBounds(376, 232, 86, 20);
		fondo_2.add(mediocampista2);
		
		mediocampista3 = new JTextField(jugadores.get(7).nombre());
		mediocampista3.setForeground(Color.WHITE);
		mediocampista3.setColumns(10);
		mediocampista3.setBackground(new Color(0, 100, 0));
		mediocampista3.setBounds(376, 348, 86, 20);
		fondo_2.add(mediocampista3);
		
		delantero1 = new JTextField(jugadores.get(8).nombre());
		delantero1.setForeground(Color.WHITE);
		delantero1.setColumns(10);
		delantero1.setBackground(new Color(0, 100, 0));
		delantero1.setBounds(527, 52, 86, 20);
		fondo_2.add(delantero1);
		
		delantero2 = new JTextField(jugadores.get(9).nombre());
		delantero2.setForeground(Color.WHITE);
		delantero2.setColumns(10);
		delantero2.setBackground(new Color(0, 100, 0));
		delantero2.setBounds(527, 183, 86, 20);
		fondo_2.add(delantero2);
		
		delantero3 = new JTextField(jugadores.get(10).nombre());
		delantero3.setForeground(Color.WHITE);
		delantero3.setColumns(10);
		delantero3.setBackground(new Color(0, 100, 0));
		delantero3.setBounds(527, 324, 86, 20);
		fondo_2.add(delantero3);
		


		
	}

}
