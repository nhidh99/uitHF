public abstract class Animal {
	protected String name;
	public abstract void makeNoise();
	public abstract void roam();
	public abstract void eat();
	public void sleep() {
		System.out.println(name + ": go to sleep!");
	}
}