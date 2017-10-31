package imagenes;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Fondo extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;

	public Fondo() {
		this.setSize(800, 550);
	}

	@Override
	public void paintComponent(Graphics g) {
		Dimension tama�o = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource(
				"/imagenes/cancha.jpg"));
		g.drawImage(imagenFondo.getImage(), 0, 0, tama�o.width,
				tama�o.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}