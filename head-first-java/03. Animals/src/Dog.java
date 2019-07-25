public class Dog extends Canine implements IPet {
	public Dog() {
		name = "Dog";
	}
	
	public void makeNoise() {
		System.out.println("Wuff!");
	}

	public void eat() {
		System.out.println("Dog eats bones!");
	}

	public void pet() {
		System.out.println("Wuff wuff!");
	}

	public void play() {
		System.out.println("I caught the ball!");
	}
}