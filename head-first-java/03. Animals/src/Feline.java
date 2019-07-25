public abstract class Feline extends Animal {
	public abstract void makeNoise();
	public abstract void eat();
	public void roam() {
		System.out.println("Feline " + name + " roam!");
	}
}