import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TextArea implements ActionListener {
	JTextArea text = new JTextArea(10, 20);
	
	public static void main(String[] args) {
		var gui = new TextArea();
		gui.go();
	}
	
	void go() {
		var frame = new JFrame();
		var panel = new JPanel();
		var button = new JButton("Click me!");
		var scroller = new JScrollPane(text);
		button.addActionListener(this);
		
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		text.setLineWrap(false);
		panel.add(scroller);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		text.append("Button clicked!\n");
	}
}