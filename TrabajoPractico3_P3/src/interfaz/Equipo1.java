package interfaz;

import inteligencia.Jugadores;
import inteligencia.Solver;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;



import java.awt.Font;


public class Equipo1 extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Equipo1 dialog = new Equipo1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Equipo1() {
		setTitle("Rumbo al mundial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Equipo1.class.getResource("/imagenes/pelota.png")));
		setBounds(250, 100, 800, 550);
		getContentPane().setLayout(null);
		
		JTabbedPane pestaña = new JTabbedPane(JTabbedPane.TOP);
		pestaña.setBounds(10, 20, 750, 450);
		getContentPane().add(pestaña);
		
		JPanel panel1=new JPanel();
		pestaña.addTab("Jugadores", panel1);
		
		Solver jugadores=new Solver();
		jugadores.cargarJugadores("jugadores.JSON");
		panel1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 517, 427);
		panel1.add(scrollPane);
		
		JTable tabla=new JTable();
		scrollPane.setViewportView(tabla);
		tabla.setModel(new Tabla(jugadores.get_jugadores()));
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(239, 56, 680, 263);
//		getContentPane().add(scrollPane);
		
		

//		
		
//		tabla.setFont(new Font("Consolas", Font.PLAIN, 15));
	
		
		
//	
//		JPanel panel2=new JPanel();
//		JTable tabla2=new JTable();
//		scrollPane.setViewportView(tabla);
//		tabla.setModel(new Tabla(jugadores));
//		
//		pestaña.addTab("Incompatibles",panel2);
		
		
	}
}
