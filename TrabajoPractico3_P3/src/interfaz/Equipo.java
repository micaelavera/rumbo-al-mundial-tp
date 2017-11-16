package interfaz;

import inteligencia.Incompatibles;
import inteligencia.Jugadores;

import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Equipo extends JDialog {
	private static final long serialVersionUID = 1L;
	private Jugadores jugadores;

	public static void main(String[] args) {
		try {
			Equipo dialog = new Equipo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			setDefaultLookAndFeelDecorated(true);
		    JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Equipo() {
		setTitle("Rumbo al mundial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Equipo.class.getResource("/imagenes/pelota.png")));
		setBounds(250, 100, 800, 550);
		getContentPane().setLayout(null);
		jugadores=new Jugadores();
		//TODO: cargar jugadores sea generico
		jugadores.cargarJugadores("jugadores.JSON");
		
		Incompatibles inc=new Incompatibles();
		inc.cargarJugadores("incompatibles.JSON");
		
		JTabbedPane pestania= new JTabbedPane(JTabbedPane.TOP);
		pestania.setBounds(10, 20, 750, 469);
		getContentPane().add(pestania);
		
		JPanel panelJugadores=new JPanel();
		pestania.addTab("Jugadores", panelJugadores);
		panelJugadores.setLayout(null);
		
		JPanel panelIncompatibles=new JPanel();
		pestania.addTab("Jugadores incompatibles",panelIncompatibles);
		panelIncompatibles.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 602, 445);
		panelJugadores.add(scrollPane);	
		
		JTable tablaJugadores=new JTable();
		scrollPane.setViewportView(tablaJugadores);
		tablaJugadores.setModel(new TablaJugadores(jugadores.getJugadores()));
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(6, 6, 738, 445);
		panelIncompatibles.add(scrollPane2);	
		JTable tablaIncompatibles=new JTable();
		scrollPane2.setViewportView(tablaIncompatibles);
		tablaIncompatibles.setModel(new TablaJugadoresIncompatibles(inc.getParesIncompatibles()));
		
		
		JButton btnGenerarEquipo = new JButton("Generar equipo ");
		btnGenerarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EquipoIdeal equipo=new EquipoIdeal();
				equipo.setVisible(true);
//				dispose();
			}
		});
		btnGenerarEquipo.setBounds(609, 405, 155, 28);
		panelJugadores.add(btnGenerarEquipo);
		
	
		
		
	}
}
