import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
	ArrayList<PrintWriter> clientOutputStreams;

	public static void main(String[] args) {
		new ChatServer().go();
	}

	@SuppressWarnings("resource")
	public void go() {
		clientOutputStreams = new ArrayList<PrintWriter>();
		try {
			var port_number = 5000;
			var server = new ServerSocket(port_number);

			while (true) {
				var socket = server.accept();
				var writer = new PrintWriter(socket.getOutputStream());
				clientOutputStreams.add(writer);

				var thread = new Thread(new ClientHandler(socket));
				thread.start();
				System.out.println("Got a connection!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	class ClientHandler implements Runnable {
		BufferedReader reader;

		public ClientHandler(Socket clientSocket) {
			try {
				var stream = new InputStreamReader(clientSocket.getInputStream());
				reader = new BufferedReader(stream);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
					System.out.println("Read: " + message);
					tellEveryone(message);
				}
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void tellEveryone(String message) {
			var it = clientOutputStreams.iterator();
			while (it.hasNext()) {
				try {
					var writer = (PrintWriter)it.next();
					writer.println(message);
					writer.flush();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
	}
}