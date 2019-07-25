import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;

public class ChatClient {
	JTextArea incoming, outgoing;
	BufferedReader reader;
	PrintWriter writer;
	Socket socket;
	
	public static void main(String[] args) {
		new ChatClient().go();
	}
	
	public void go() {
		buildGUI();
		setupNetworking();
		createReaderThread();
	}
	
	public void buildGUI() {
		var frame = new JFrame("Messenger");
		var panel = new JPanel();
		
		incoming = new JTextArea(12,45);
		var iscroller = new JScrollPane(incoming);
		iscroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		iscroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		incoming.setEditable(false);

		outgoing = new JTextArea(3,38);
		var oscroller = new JScrollPane(outgoing);
		oscroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		oscroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		var button = new JButton("Send");
		button.addActionListener(new SendListener());
		
		var sendBox = new Box(BoxLayout.X_AXIS);
		sendBox.add(oscroller);
		sendBox.add(Box.createHorizontalStrut(7));
		sendBox.add(button);
		
		panel.add(iscroller);
		panel.add(sendBox);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setSize(500, 305);
		frame.setResizable(false);
		frame.setVisible(true);
		outgoing.requestFocus();
	}
	
	public void setupNetworking() {
		try {
			var local_host = "127.0.0.1";
			var port_number = 5000;
			socket = new Socket(local_host, port_number);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream());
			System.out.println("Network established!");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
		
	public void createReaderThread() {
		var thread = new Thread(new IncomingReader());
		thread.start();
	}

	class SendListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				var message = outgoing.getText();
				writer.println(message);
				writer.flush();
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}

	class IncomingReader implements Runnable {
		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
					incoming.append(message + "\n");
				}
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}