import java.util.Scanner;
import java.util.ArrayList;

public class SimpleDotComDriveTest {
	public static void main(String[] args) {
		int numOfGuesses = 0;
		var dot = new SimpleDotCom();
		int firstLocation = (int)(Math.random() * 5);
		
		ArrayList<String> locations = new ArrayList<String>();
		locations.add(Integer.toString(firstLocation));
		locations.add(Integer.toString(firstLocation + 1));
		locations.add(Integer.toString(firstLocation + 2));
		dot.setLocationCells(locations);

		var scanner = new Scanner(System.in);
		boolean isAlive = true;
		
		while (isAlive) {
			System.out.print("Your guess: ");
			String userGuess = scanner.nextLine();
			String result = dot.checkYourself(userGuess);
			System.out.println("-> Result: " + result);
			numOfGuesses++;
			
			if (result == "kill") {
				isAlive = false;
				System.out.println("-> Number of guesses: " + numOfGuesses);
			}
		}
		scanner.close();
	}
}