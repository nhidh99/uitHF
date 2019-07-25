import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class MyGUI implements ActionListener {
	JFrame frame;
	
	public static void main(String[] args) {
		var gui = new MyGUI();
		gui.go();
	}
	
	void go() {
		frame = new JFrame("Random Circle Color");
		var button = new JButton("Change Color!");
		var panel = new MyDrawPanel();
		button.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		frame.repaint();
	}
}