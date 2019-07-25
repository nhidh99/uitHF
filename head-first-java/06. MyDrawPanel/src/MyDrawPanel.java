import java.awt.*;
import javax.swing.*;

public class MyDrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
		var g2d = (Graphics2D)g;
		int red = (int)(Math.random() * 255);
		int green = (int)(Math.random() * 255);
		int blue = (int)(Math.random() * 255);
		var startColor = new Color(red, green, blue);
		
		red = (int)(Math.random() * 255);
		green = (int)(Math.random() * 255);
		blue = (int)(Math.random() * 255);
		var endColor = new Color(red, green, blue);
		
		var gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
		g2d.setPaint(gradient);
		g2d.fillOval(50, 50, 150, 150);
	}
}