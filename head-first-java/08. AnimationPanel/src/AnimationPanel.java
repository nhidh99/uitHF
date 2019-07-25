import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnimationPanel {
	int x = 70;
	int y = 70;
	
	public static void main(String[] args) {
		var gui = new AnimationPanel();
		gui.go();
	}
	
	void go() {
		var frame = new JFrame();
		var panel = new MyPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		for (int i = 0; i < 130; i++) {
			x++;
			y++;
			panel.repaint();
			
			try {
				Thread.sleep(20);
			} catch (Exception ex) {}
		}
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			// Paint background white
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());

			// Random start Color
			int red = (int)(Math.random() * 255);
			int green = (int)(Math.random() * 255);
			int blue = (int)(Math.random() * 255);
			var startColor = new Color(red, green, blue);			
			
			// Random end Color
			red = (int)(Math.random() * 255);
			green = (int)(Math.random() * 255);
			blue = (int)(Math.random() * 255);
			var endColor = new Color(red, green, blue);
		
			// Draw gradiend-color-circle
			var gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
			var g2d = (Graphics2D)g;
			g2d.setPaint(gradient);
			g2d.fillOval(x, y, 40, 40);
		}
	}
}