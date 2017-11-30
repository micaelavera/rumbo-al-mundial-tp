package interfaz;

import inteligencia.Incompatibilidad;
import inteligencia.Jugadores;
import inteligencia.Solver.Algoritmo;

import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Equipo extends JDialog {
	private static final long serialVersionUID = 1L;
	private Jugadores jugadores;
	private Incompatibilidad incompatibles;
	

	public static void main(String[] args)
	{
		try {
			Equipo dialog = new Equipo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Equipo() {
		setTitle("Rumbo al mundial - Jugadores");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Equipo.class.getResource("/imagenes/pelota.png")));
		setBounds(250, 100, 800, 550);
		getContentPane().setLayout(null);
		jugadores=new Jugadores();
		incompatibles=new Incompatibilidad();
		
		//TODO: Descomentar lo siguiente
//		jugadores.cargarJugadores(CargaJugadores.buscadorJugadores().getText());
//		incompatibles.cargarJugadores(CargaJugadores.buscadorIncompatibles().getText());
		
		jugadores.cargarJugadores("jugadores.JSON");
		incompatibles.cargarJugadores("incompatibles.JSON");
		
		
		JTabbedPane pestania= new JTabbedPane(JTabbedPane.TOP);
		pestania.setBounds(10, 20, 750, 480);
		getContentPane().add(pestania);
		
		JPanel panelJugadores=new JPanel();
		pestania.addTab("Jugadores", panelJugadores);
		panelJugadores.setLayout(null);
		
		JPanel panelIncompatibles=new JPanel();
		pestania.addTab("Jugadores incompatibles",panelIncompatibles);
		panelIncompatibles.setLayout(null);
		
		JScrollPane scrollPaneJugadores = new JScrollPane();
		scrollPaneJugadores.setBounds(6, 6, 739, 396);
		panelJugadores.add(scrollPaneJugadores);	
		
		JTable tablaJugadores=new JTable();
		scrollPaneJugadores.setViewportView(tablaJugadores);
		tablaJugadores.setModel(new TablaJugadores(jugadores.getJugadores()));
		
		JScrollPane scrollPaneIncompatibles = new JScrollPane();
		scrollPaneIncompatibles.setBounds(6, 6, 738, 445);
		panelIncompatibles.add(scrollPaneIncompatibles);	
		JTable tablaIncompatibles=new JTable();
		scrollPaneIncompatibles.setViewportView(tablaIncompatibles);
		tablaIncompatibles.setModel(new TablaJugadoresIncompatibles(incompatibles.getParesIncompatibles()));
		
		JButton btnGenerarEquipo = new JButton("Generar equipo con Backtracking");
		btnGenerarEquipo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				EquipoIdeal equipo=new EquipoIdeal();
				equipo.setVisible(true);
				equipo.ubicarEnCancha(jugadores, Algoritmo.BacktrackingOrdenado);
				dispose();
			}
		});
		btnGenerarEquipo.setBounds(414, 413, 284, 28);
		panelJugadores.add(btnGenerarEquipo);	
		
		JButton btnFuerzaBruta = new JButton("Generar equipo con Fuerza bruta");
		 btnFuerzaBruta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EquipoIdeal equipo=new EquipoIdeal();
				equipo.setVisible(true);
				equipo.ubicarEnCancha(jugadores, Algoritmo.FuerzaBruta);
				dispose();
			}
		});
		btnFuerzaBruta.setBounds(42, 413, 284, 28);
		panelJugadores.add(btnFuerzaBruta);
	}
}
