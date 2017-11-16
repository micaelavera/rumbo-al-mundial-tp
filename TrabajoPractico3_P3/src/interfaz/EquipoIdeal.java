package interfaz;

import imagenes.Fondo;
import inteligencia.Jugadores;
import inteligencia.Solucion;
import inteligencia.Solver;
import inteligencia.Solver.Algoritmo;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class EquipoIdeal extends JDialog {

	private Solver solver;
	private Jugadores jugadores;
	Jugadores inst;
	private Fondo fondo_1;
	
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

		
		Fondo fondo=new Fondo();
		fondo = new Fondo();
		fondo.setBackground(Color.BLACK);
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(fondo);
		fondo.setLayout(null);
		

	
		
		
		jugadores=new Jugadores();
		jugadores.cargarJugadores("jugadores.JSON");
//		resolver(jugadores,Algoritmo.BacktrackingOrdenado);
		
		Solver solver = new Solver(jugadores, Algoritmo.BacktrackingOrdenado);
		Solucion optima = solver.resolver();
//		JLabel arquero = new JLabel(optima.getJugadores());
//		arquero.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		arquero.setForeground(Color.YELLOW);
//		arquero.setBounds(46, 225, 109, 14);
//		fondo.add(arquero);
//	

		
	}
	
	private static void resolver(Jugadores instancia, Solver.Algoritmo algoritmo){
		Solver solver = new Solver(instancia, algoritmo);
		Solucion optima = solver.resolver();
		
		
//		System.out.print("\n"+algoritmo+"\n"+"\n");
		System.out.println(optima);
//		System.out.println();
	
	}
}
