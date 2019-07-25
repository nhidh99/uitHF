import java.net.*;
import java.io.*;

public class AdviserClient {
	public static void main(String[] args) {	
		try {
			var local_host = "127.0.0.1";
			var port_number = 4242;
			var socket = new Socket(local_host, port_number);
			
			var streamReader = new InputStreamReader(socket.getInputStream());
			var reader = new BufferedReader(streamReader);
			var advise = reader.readLine();
			
			System.out.println("Today you should: " + advise);
			reader.close();
			socket.close();
		} 
		catch (Exception ex) {
			System.out.println("Cannot connect to server!");
			ex.printStackTrace();
		}
	}
}