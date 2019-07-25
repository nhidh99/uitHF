import java.io.*;

public class SerializeTest {
	public static void main(String[] args) {
		var characters = new GameCharacter[3];
		characters[0] = new GameCharacter(50, "Elf", new String[] {"bow", "sword", "dust"});
		characters[1] = new GameCharacter(200, "Troll", new String[] {"bare hand", "big axe"});
		characters[2] = new GameCharacter(120, "Magician", new String[] {"spells", "invisibility"});
		
		// write objects
		try {
			var os = new ObjectOutputStream(new FileOutputStream("game.ser"));
			for (var character : characters) {
				os.writeObject(character);
			}
			os.close();
		} catch (Exception ex) { ex.printStackTrace(); }
		
		// release references to null to not access objects from the heap
		for (int i = 0; i < 3; i++) {
			characters[i] = null;
		}
		
		// read objects
		try {
			var is = new ObjectInputStream(new FileInputStream("game.ser"));
			for (int i = 0; i < 3; i++) {
				characters[i] = (GameCharacter)is.readObject();
			}
			is.close();
		} catch (Exception ex) { ex.printStackTrace(); }
		
		// print read objects
		for (var character : characters) {
			System.out.println(character.getType());
		}
	}
}