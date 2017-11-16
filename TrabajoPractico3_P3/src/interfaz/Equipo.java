//package interfaz;
//
//import inteligencia.Jugadores;
//
//import java.awt.Toolkit;
//
//import javax.swing.JDialog;
//
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTabbedPane;
//import javax.swing.JTable;
//import javax.swing.UIManager;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
//public class Equipo extends JDialog {
//	private static final long serialVersionUID = 1L;
//	VentanaPrincipal v;
//	Jugadores jugadores;
//
//	public static void main(String[] args) {
//		try {
//			Equipo dialog = new Equipo();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//			setDefaultLookAndFeelDecorated(true);
//		    JDialog.setDefaultLookAndFeelDecorated(true);
//			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public Equipo() {
//		setTitle("Rumbo al mundial");
//		setIconImage(Toolkit.getDefaultToolkit().getImage(Equipo.class.getResource("/imagenes/pelota.png")));
//		setBounds(250, 100, 800, 550);
//		getContentPane().setLayout(null);
//		jugadores=new Jugadores();
//		//TODO: cargar jugadores sea generico
//		jugadores.cargarJugadores("jugadores.JSON");
//		
//		JTabbedPane pestañas = new JTabbedPane(JTabbedPane.TOP);
//		pestañas.setBounds(10, 20, 750, 469);
//		getContentPane().add(pestañas);
//		
//		JPanel panelJugadores=new JPanel();
//		pestañas.addTab("Jugadores", panelJugadores);
//		panelJugadores.setLayout(null);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(6, 6, 530, 445);
//		panelJugadores.add(scrollPane);	
//		
//		JTable tabla=new JTable();
//		scrollPane.setViewportView(tabla);
//		tabla.setModel(new Tabla(jugadores.getJugadores()));
//		
//		JButton btnGenerarEquipo = new JButton("Generar equipo ");
//		btnGenerarEquipo.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				EquipoIdeal equipo=new EquipoIdeal();
//				equipo.setVisible(true);
//				
//			}
//		});
//		btnGenerarEquipo.setBounds(574, 405, 155, 28);
//		panelJugadores.add(btnGenerarEquipo);
//		
//	
//		
//		
//	}
//}
