import java.util.ArrayList;

public class SimpleDotCom {
	private ArrayList<String> locationCells;

	String checkYourself(String userGuess) {
		int index = locationCells.indexOf(userGuess);
		if (index >= 0) {
			locationCells.remove(index);
		} else return "miss";
		
		if (locationCells.isEmpty()) {
			return "kill";
		} return "hit";
	}
	
	void setLocationCells(ArrayList<String> loc) {
		locationCells = loc;
	}
}