package interfaz;

import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
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
		frame.setBounds(320, 150, 400,300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JLabel lblBienvenida = new JLabel("\u00A1Bienvenido director t\u00E9cnico!");
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblBienvenida.setBounds(23, 34, 361, 14);
		frame.getContentPane().add(lblBienvenida);
		
		JLabel usuario = new JLabel("Usuario:");
		usuario.setFont(new Font("Consolas", Font.PLAIN, 14));
		usuario.setHorizontalAlignment(SwingConstants.CENTER);
		usuario.setBounds(23, 92, 77, 14);
		frame.getContentPane().add(usuario);
		
		JLabel contraseña = new JLabel("Contrase\u00F1a:");
		contraseña.setFont(new Font("Consolas", Font.PLAIN, 15));
		contraseña.setBounds(23, 136, 88, 14);
		frame.getContentPane().add(contraseña);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Consolas", Font.PLAIN, 15));
		txtUsuario.setBounds(120, 89, 264, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		contrasenia = new JPasswordField();
		contrasenia.setFont(new Font("Consolas", Font.PLAIN, 15));
		contrasenia.setBounds(120, 133, 264, 20);
		frame.getContentPane().add(contrasenia);
		
		JButton cargarDatos = new JButton("Cargar datos");
		cargarDatos.setFont(new Font("Consolas", Font.PLAIN, 15));
		cargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password=new String(contrasenia.getPassword());
				if(chequearDatos(password)){
					CargaJugadores p=new CargaJugadores();
					p.setVisible(true);
					frame.dispose();
					JOptionPane.showMessageDialog(null,"Debe cargar el archivo de los jugadores convocados","Mensaje",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null,"Debe cargar los datos correspondientes","Mensaje",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cargarDatos.setBounds(82, 189, 253, 23);
		frame.getContentPane().add(cargarDatos);
	}
	
	
	private boolean chequearDatos(String password) {
		return txtUsuario.getText().equals("JavierMarenco")&& password.equals("jmarenco") ||
				txtUsuario.getText().equals("PatriciaBagnes") && password.equals("pbagnes");
	}
}
