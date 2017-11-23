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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CargaJugadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField buscador;
	
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
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Fondo fondo = new Fondo();
		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(fondo);
		fondo.setLayout(null);
	
		JButton buscarArchivo = new JButton("Buscar archivo");
		buscarArchivo.setFont(new Font("Consolas", Font.PLAIN, 14));
		buscarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser direccionArchivo=new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.JSON","JSON");
				direccionArchivo.setFileFilter(filter);

				direccionArchivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				direccionArchivo.showOpenDialog(direccionArchivo);
			
				File archivo = direccionArchivo.getSelectedFile(); 
				buscador.setText(archivo.getAbsolutePath());		
				}
		});
		buscarArchivo.setBounds(237, 269, 316, 23);
		fondo.add(buscarArchivo);
		
		buscador = new JTextField();
		buscador.setEditable(false);
		buscador.setBounds(211, 215, 377, 20);
		fondo.add(buscador);
		buscador.setColumns(10);
		
		JLabel lblCargarArchivo = new JLabel("Busque el archivo correspondiente");
		lblCargarArchivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargarArchivo.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblCargarArchivo.setForeground(Color.WHITE);
		lblCargarArchivo.setBounds(237, 244, 308, 14);
		fondo.add(lblCargarArchivo);
		
		JLabel direccionArchivo = new JLabel("Direccion de archivo:");
		direccionArchivo.setForeground(Color.WHITE);
		direccionArchivo.setFont(new Font("Consolas", Font.PLAIN, 15));
		direccionArchivo.setBounds(211, 193, 266, 14);
		fondo.add(direccionArchivo);
		
		JButton cargarArchivo = new JButton("Cargar archivo");
		cargarArchivo.setFont(new Font("Consolas", Font.PLAIN, 14));
		cargarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buscador.getText().isEmpty() || !buscador.getText().contains("jugadores.JSON")){
					JOptionPane.showMessageDialog(null, "Debe buscar el archivo correspondiente", "Mensaje", JOptionPane.ERROR_MESSAGE);
				}else{
					Equipo equipo=new Equipo();
					equipo.setVisible(true);
					dispose();
				}
			}});
		cargarArchivo.setBounds(237, 316, 316, 23);
		fondo.add(cargarArchivo);
			 
	}

	public static JTextField getBuscador() {
		return buscador;
	}

}
