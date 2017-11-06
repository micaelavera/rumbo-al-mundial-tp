package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import imagenes.Fondo;
import inteligencia.Jugadores;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.SwingConstants;


public class VentanaPrincipal {

	private JFrame frame;
	private JTextField textField;
	JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Rumbo al mundial");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagenes/pelota.png")));
		frame.setBounds(250, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		Fondo fondo = new Fondo();
		fondo.setBackground(Color.BLACK);
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(fondo);
		fondo.setLayout(null);
		
		table = new JTable();
//		scrollPane.setViewportView(table);
		
		JButton cargarJugador = new JButton("Cargar archivo");
		cargarJugador.setFont(new Font("Consolas", Font.PLAIN, 12));
		cargarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser _buscador=new JFileChooser();
				_buscador.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				_buscador.showOpenDialog(_buscador);
			
				File archivo = _buscador.getSelectedFile(); 
				textField.setText(archivo.getAbsolutePath());
			;			
			}
		});
		cargarJugador.setBounds(247, 269, 316, 23);
		fondo.add(cargarJugador);
		
		textField = new JTextField();
		textField.setBounds(222, 322, 377, 20);
		fondo.add(textField);
		textField.setColumns(10);
		
		JLabel lblCargueElArchivo = new JLabel("Cargue el archivo correspondiente");
		lblCargueElArchivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargueElArchivo.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblCargueElArchivo.setForeground(Color.WHITE);
		lblCargueElArchivo.setBounds(237, 244, 308, 14);
		fondo.add(lblCargueElArchivo);
			 
	
	}
}
