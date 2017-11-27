package interfaz;

import imagenes.Fondo;
import inteligencia.Incompatibilidad;
import inteligencia.Jugador;
import inteligencia.Jugadores;
import inteligencia.Solucion;
import inteligencia.Solver;
import inteligencia.Solver.Algoritmo;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JDialog;

import java.util.ArrayList;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class EquipoIdeal extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private Fondo cancha;
	private Solver solver;
	private Jugadores jugadores;
	private Incompatibilidad incompatibles;
	
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
		incompatibles=new Incompatibilidad();
		jugadores.cargarJugadores("jugadores.JSON");
		incompatibles.cargarJugadores("incompatibles.JSON");
//		jugadores.cargarJugadores(CargaJugadores.buscadorJugadores().getText())
//		incompatibles.cargarJugadores(CargaJugadores.buscadorIncompatibles().getText());
		incompatibles.entraUnodelPar(jugadores);
	
		
//		resolver(jugadores,Solver.Algoritmo.BacktrackingOrdenado);
		Solver solver = new Solver(jugadores, Solver.Algoritmo.BacktrackingOrdenado);
		Solucion optima = solver.resolver();

		ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
		jugadores=solver.ListasDePosiciones(optima);
		
		cancha= new Fondo("/imagenes/cancha.jpg");
		cancha.setBackground(Color.BLACK);
		setContentPane(cancha);
		cancha.setLayout(null);
		
		JTextField arquero = new JTextField(jugadores.get(0).nombre());
		arquero.setBounds(41, 232, 86, 20);
		agregar(arquero);
		
		JTextField defensor1 = new JTextField(jugadores.get(1).nombre());
		defensor1.setBounds(209, 52, 86, 20);
		agregar(defensor1);
	
		JTextField defensor2 = new JTextField(jugadores.get(2).nombre());
		defensor2.setBounds(209, 159, 86, 20);
		agregar(defensor2);
		
		JTextField defensor3 = new JTextField(jugadores.get(3).nombre());
		defensor3.setBounds(209, 280, 86, 20);
		agregar(defensor3);
		
		JTextField defensor4 = new JTextField(jugadores.get(4).nombre());
		defensor4.setBounds(209, 385, 86, 20);
		agregar(defensor4);
	
		JTextField mediocampista1 = new JTextField(jugadores.get(5).nombre());
		mediocampista1.setBounds(376, 99, 86, 20);
		agregar(mediocampista1);
		
		JTextField mediocampista2 = new JTextField(jugadores.get(6).nombre());
		mediocampista2.setBounds(376, 232, 86, 20);
		agregar(mediocampista2);

		JTextField mediocampista3 = new JTextField(jugadores.get(7).nombre());
		mediocampista3.setBounds(376, 348, 86, 20);
		agregar(mediocampista3);
		
		JTextField delantero1 = new JTextField(jugadores.get(8).nombre());
		delantero1.setBounds(527, 52, 86, 20);
		agregar(delantero1);

		JTextField delantero2 = new JTextField(jugadores.get(9).nombre());
		delantero2.setBounds(527, 183, 86, 20);
		agregar(delantero2);

		JTextField delantero3 = new JTextField(jugadores.get(10).nombre());
		delantero3.setBounds(527, 324, 86, 20);
		agregar(delantero3);
	
		JLabel lblNivelDeJuego = new JLabel("Nivel de juego total:");
		lblNivelDeJuego.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNivelDeJuego.setForeground(Color.WHITE);
		lblNivelDeJuego.setBackground(new Color(0, 100, 0));
		lblNivelDeJuego.setBounds(236, 453, 181, 28);
		cancha.add(lblNivelDeJuego);
		
		JTextField nivelDeJuegoTotal = new JTextField(""+optima.nivelJuego());
		nivelDeJuegoTotal.setHorizontalAlignment(SwingConstants.CENTER);
		nivelDeJuegoTotal.setEditable(false);
		nivelDeJuegoTotal.setBackground(Color.BLUE);
		nivelDeJuegoTotal.setFont(new Font("Consolas", Font.PLAIN, 15));
		nivelDeJuegoTotal.setForeground(Color.WHITE);
		nivelDeJuegoTotal.setBounds(426, 452, 43, 31);
		nivelDeJuegoTotal.setColumns(10);
		cancha.add(nivelDeJuegoTotal);
	}

	private static void resolver(Jugadores jugadores,Solver.Algoritmo algoritmo) {
		Solver solver = new Solver(jugadores, algoritmo);
		Solucion optima = solver.resolver();
		System.out.println(optima);
	}

	private void agregar(JTextField jugador) {
		jugador.setEditable(false);
		jugador.setHorizontalAlignment(SwingConstants.CENTER);
		jugador.setBackground(new Color(0, 100, 0));
		jugador.setForeground(new Color(255, 255, 255));
		jugador.setColumns(10);
		cancha.add(jugador);
	}
}