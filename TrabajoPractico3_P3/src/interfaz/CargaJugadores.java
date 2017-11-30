package interfaz;

import imagenes.Fondo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CargaJugadores extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTextField buscadorJugadores;
	private static JTextField buscadorIncompatibles;
	
	public static void main(String[] args) {
		try {
			CargaJugadores dialog = new CargaJugadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CargaJugadores() {
		setBounds(250, 100, 800, 550);
		setTitle("Carga de jugadores");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Fondo fondo = new Fondo("/imagenes/mascota.jpg");
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(fondo);
		fondo.setLayout(null);
	
		JButton buscarArchivoJugadores = new JButton("Buscar archivo correspondiente");
		buscarArchivoJugadores.setFont(new Font("Consolas", Font.PLAIN, 14));
		buscarArchivoJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File archivo = buscador(); 
				buscadorJugadores.setText(archivo.getAbsolutePath());		
				}
		});
		buscarArchivoJugadores.setBounds(65, 170, 316, 23);
		fondo.add(buscarArchivoJugadores);
		
		buscadorJugadores = new JTextField();
		buscadorJugadores.setEditable(false);
		buscadorJugadores.setBounds(65, 140, 380, 20);
		fondo.add(buscadorJugadores);
		buscadorJugadores.setColumns(10);
		
		JLabel direccionArchivo = new JLabel("Direccion de archivo de los jugadores:");
		direccionArchivo.setBackground(Color.BLACK);
		direccionArchivo.setForeground(Color.BLACK);
		direccionArchivo.setFont(new Font("Consolas", Font.PLAIN, 15));
		direccionArchivo.setBounds(65, 115, 431, 14);
		fondo.add(direccionArchivo);
		
		JButton cargarArchivo = new JButton("Cargar archivos");
		cargarArchivo.setFont(new Font("Consolas", Font.PLAIN, 14));
		cargarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buscadorJugadores.getText().isEmpty() || !buscadorJugadores.getText().contains("jugadores.JSON")|| 
					buscadorIncompatibles.getText().isEmpty() || !buscadorIncompatibles.getText().contains("incompatibles.JSON")){
					JOptionPane.showMessageDialog(null, "Debe buscar los archivos correspondientes", "Mensaje", JOptionPane.ERROR_MESSAGE);
				}else{
					Equipo equipo=new Equipo();
					equipo.setVisible(true);
					dispose();
				}
			}});

		cargarArchivo.setBounds(65, 457, 357, 23);
		fondo.add(cargarArchivo);
		
		JLabel direccionArchivoIncompatibles = new JLabel("Direccion de archivo de los jugadores incompatibles:");
		direccionArchivoIncompatibles.setForeground(Color.BLACK);
		direccionArchivoIncompatibles.setFont(new Font("Consolas", Font.PLAIN, 15));
		direccionArchivoIncompatibles.setBounds(65, 335, 431, 14);
		fondo.add(direccionArchivoIncompatibles);
		
		buscadorIncompatibles = new JTextField();
		buscadorIncompatibles.setEditable(false);
		buscadorIncompatibles.setBounds(65, 360, 371, 20);
		fondo.add(buscadorIncompatibles);
		buscadorIncompatibles.setColumns(10);
		
		JButton buscarArchivoIncompatibles = new JButton("Buscar archivo correspondiente");
		buscarArchivoIncompatibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File archivo = buscador(); 
				buscadorIncompatibles.setText(archivo.getAbsolutePath());
			}
		});
		buscarArchivoIncompatibles.setFont(new Font("Consolas", Font.PLAIN, 15));
		buscarArchivoIncompatibles.setBounds(65, 391, 316, 23);
		fondo.add(buscarArchivoIncompatibles);
	}
	
	private File buscador() {
		JFileChooser direccionArchivo=new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.JSON","JSON");
		direccionArchivo.setFileFilter(filter);

		direccionArchivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		direccionArchivo.showOpenDialog(direccionArchivo);
	
		File archivo = direccionArchivo.getSelectedFile();
		return archivo;
	}
	
	public static JTextField buscadorJugadores() {
		return buscadorJugadores;
	}
	
	public static JTextField buscadorIncompatibles() {
		return buscadorIncompatibles;
	}
}
