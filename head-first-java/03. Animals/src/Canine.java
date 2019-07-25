public abstract class Canine extends Animal {
	public abstract void makeNoise();
	public abstract void eat();
	public void roam() {
		System.out.println("Canine " + name + " roam!");
	}
}