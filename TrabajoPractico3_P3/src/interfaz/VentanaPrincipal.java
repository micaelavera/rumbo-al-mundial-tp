package interfaz;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.print.DocFlavor.URL;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.SwingConstants;


public class VentanaPrincipal {
	
	private JFrame frame;
	private JPasswordField contrasenia;
	private JTextField txtUsuario;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("Rumbo al mundial");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagenes/pelota.png")));
		frame.setBounds(320, 150, 488,351);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JLabel lblBienvenida = new JLabel("\u00A1Bienvenido director t\u00E9cnico!");
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblBienvenida.setBounds(147, 68, 310, 14);
		frame.getContentPane().add(lblBienvenida);
		
		JLabel usuario = new JLabel("Usuario:");
		usuario.setFont(new Font("Consolas", Font.PLAIN, 14));
		usuario.setHorizontalAlignment(SwingConstants.CENTER);
		usuario.setBounds(54, 155, 77, 14);
		frame.getContentPane().add(usuario);
		
		JLabel contrasena = new JLabel("Contrase\u00F1a:");
		contrasena.setFont(new Font("Consolas", Font.PLAIN, 15));
		contrasena.setBounds(54, 199, 88, 14);
		frame.getContentPane().add(contrasena);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Consolas", Font.PLAIN, 15));
		txtUsuario.setBounds(173, 152, 264, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		contrasenia = new JPasswordField();
		contrasenia.setFont(new Font("Consolas", Font.PLAIN, 15));
		contrasenia.setBounds(173, 196, 264, 20);
		frame.getContentPane().add(contrasenia);
		
		JButton cargarDatos = new JButton("Cargar datos");
		cargarDatos.setFont(new Font("Consolas", Font.PLAIN, 15));
		cargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass=new String(contrasenia.getPassword());
				if(chequearDatos(pass)){
					CargaJugadores jugadores=new CargaJugadores();
					jugadores.setVisible(true);
					frame.dispose();
					JOptionPane.showMessageDialog(null,"Debe cargar el archivo de los jugadores convocados y los incompatibles","Mensaje",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null,"Debe cargar los datos correspondientes","Mensaje",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cargarDatos.setBounds(133, 258, 253, 23);
		frame.getContentPane().add(cargarDatos);
		
		JLabel label = new JLabel();
		label.setOpaque(false);
		label.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/logo_afa.png")));
		label.setBounds(49, 11, 99, 140);
		frame.getContentPane().add(label);
	}
	
	private boolean chequearDatos(String contrasenia) {
		return txtUsuario.getText().equals("JavierMarenco")&& contrasenia.equals("jmarenco") ||
				txtUsuario.getText().equals("PatriciaBagnes") && contrasenia.equals("pbagnes");
	}
}
