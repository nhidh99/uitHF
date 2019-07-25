import java.io.*;
import java.net.*;

public class AdviserServer {
	String[] adviseList = { "Take smaller bites!", "Do more exercises!", "Drink water, not cola!" };

	public static void main(String[] args) {
		new AdviserServer().go();
	}
	
	public void go() {
		try {
			var port_number = 4242;
			var server = new ServerSocket(port_number);
			System.out.println("Sucess!");
			
			while (true) {
				var socket = server.accept();
				var writer = new PrintWriter(socket.getOutputStream());
				var advise = getAdvise();
				writer.println(advise);
				writer.close();
				server.close();
				System.out.println(advise);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String getAdvise() {
		int random = (int)(Math.random() * adviseList.length);
		return adviseList[random];
	}
}