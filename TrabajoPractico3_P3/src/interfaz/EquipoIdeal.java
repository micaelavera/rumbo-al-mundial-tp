package interfaz;

import java.awt.Toolkit;
import javax.swing.JDialog;

public class EquipoIdeal extends JDialog {


	public static void main(String[] args) {
		try {
			EquipoIdeal dialog = new EquipoIdeal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public EquipoIdeal(){
		setTitle("Rumbo al mundial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Equipo.class.getResource("/imagenes/pelota.png")));
		setBounds(250, 100, 800, 550);
		getContentPane().setLayout(null);
		
	}

}
