public class AnimalDriveTest {
	public static void main(String[] args) {
		ListAnimal animals = new ListAnimal();
		animals.add(new Dog());
		animals.add(new Cat());
		animals.add(new Lion());
		
		System.out.println("TIME TO SLEEP!");
		animals.sleep();
		
		System.out.println("\nTIME TO EAT!");
		animals.eat();
		
		System.out.println("\nTIME TO ROAM!");
		animals.roam();
		
		System.out.println("\nTIME TO PLAY!");
		animals.play();
		
		System.out.println("\nTIME TO PET!");
		animals.pet();
	}
}