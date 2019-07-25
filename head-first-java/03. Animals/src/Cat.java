public class Cat extends Feline implements IPet {
	public Cat() {
		name = "Cat";
	}
	
	public void makeNoise() {
		System.out.println("Meow!");
	}
	
	public void eat() {
		System.out.println("Cat eats fishes!");
	}

	public void pet() {
		System.out.println("Meow Meow!");
	}

	public void play() {
		System.out.println("I messed the strings!");
	}
}