import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TwoButtonsTestDrive {
	JFrame frame;
	JLabel label;
	int count = 1;
	
	public static void main(String[] args) {
		var gui = new TwoButtonsTestDrive();
		gui.go();
	}
	
	void go() {
		label = new JLabel("Click x0!");
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		var btnLable = new JButton("Change Lable");
		btnLable.addActionListener(new LabelListener());
		
		var btnColor = new JButton("Change Color");
		btnColor.addActionListener(new ColorListener());
		
		var drawPanel = new DrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, btnColor);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.EAST, btnLable);
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	class LabelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			label.setText("Ouch x" + count);
			count++;
		}
	}
	
	class ColorListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}
}