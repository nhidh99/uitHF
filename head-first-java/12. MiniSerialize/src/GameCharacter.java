import java.io.Serializable;

public class GameCharacter implements Serializable {
	private static final long serialVersionUID = 1L;
	int power;
	String type;
	String[] weapons;
	
	public GameCharacter(int power, String type, String[] weapons) {
		this.power = power;
		this.type = type;
		this.weapons = weapons;
	}
	
	public int getPower() { 
		return power;
	}
	
	public String getType() {
		return type;
	}
	
	public String getWeapons() {
		String weaponList = "";
		for (var weapon : weapons) {
			weaponList += weapon + " ";
		}
		return weaponList;
	}
}