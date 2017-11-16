//package interfaz;
//
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.Toolkit;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.border.EmptyBorder;
//import javax.swing.filechooser.FileNameExtensionFilter;
//import imagenes.Fondo;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.io.File;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//import javax.swing.JLabel;
//import java.awt.Font;
//import javax.swing.SwingConstants;
//
//public class VentanaPrincipal {
//
//	private JFrame frame;
//	private Fondo fondo;
//	private JTextField buscador;
//	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaPrincipal window = new VentanaPrincipal();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	public VentanaPrincipal() {
//		initialize();
//	}
//	
//	private void initialize() {
//		frame = new JFrame("Rumbo al mundial");
//		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagenes/pelota.png")));
//		frame.setBounds(250, 100, 800, 550);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//	
//	
//		fondo = new Fondo();
//		fondo.setBackground(Color.BLACK);
//		fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
//		frame.setContentPane(fondo);
//		fondo.setLayout(null);
//	
//		
//		JButton buscarArchivo = new JButton("Buscar archivo");
//		buscarArchivo.setFont(new Font("Consolas", Font.PLAIN, 14));
//		buscarArchivo.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				JFileChooser direccionArchivo=new JFileChooser();
//				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.JSON","JSON");
//				direccionArchivo.setFileFilter(filter);
//
//				direccionArchivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//				direccionArchivo.showOpenDialog(direccionArchivo);
//			
//				File archivo = direccionArchivo.getSelectedFile(); 
//				buscador.setText(archivo.getAbsolutePath());		
//				}
//		});
//		buscarArchivo.setBounds(237, 269, 316, 23);
//		fondo.add(buscarArchivo);
//		
//		buscador = new JTextField();
//		buscador.setEditable(false);
//		buscador.setBounds(211, 215, 377, 20);
//		fondo.add(buscador);
//		buscador.setColumns(10);
//		
//		JLabel lblCargarArchivo = new JLabel("Busque el archivo correspondiente");
//		lblCargarArchivo.setHorizontalAlignment(SwingConstants.CENTER);
//		lblCargarArchivo.setFont(new Font("Consolas", Font.PLAIN, 16));
//		lblCargarArchivo.setForeground(Color.WHITE);
//		lblCargarArchivo.setBounds(237, 244, 308, 14);
//		fondo.add(lblCargarArchivo);
//		
//		JLabel direccionArchivo = new JLabel("Direccion de archivo:");
//		direccionArchivo.setForeground(Color.WHITE);
//		direccionArchivo.setFont(new Font("Consolas", Font.PLAIN, 15));
//		direccionArchivo.setBounds(211, 193, 266, 14);
//		fondo.add(direccionArchivo);
//		
//		JButton cargarArchivo = new JButton("Cargar archivo");
//		cargarArchivo.setFont(new Font("Consolas", Font.PLAIN, 14));
//		cargarArchivo.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(buscador.getText().isEmpty() || !buscador.getText().contains("jugadores.JSON")){
//					JOptionPane.showMessageDialog(null, "Debe buscar el archivo correspondiente", "Mensaje", JOptionPane.ERROR_MESSAGE);
//				}else{
//					Equipo equipo=new Equipo();
//					equipo.setVisible(true);
//					frame.dispose();
//				}
//			}});
//		cargarArchivo.setBounds(237, 316, 316, 23);
//		fondo.add(cargarArchivo);
//			 
//	}
//
//	public JTextField getBuscador() {
//		return buscador;
//	}
//}
