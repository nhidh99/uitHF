import java.util.ArrayList;

public class ListAnimal {
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	
	public void add(Animal a) {
		animals.add(a);
	}
	
	public void makeNoise() {
		for (Animal a : animals) {
			a.makeNoise();
		}
	}
	
	public void roam() {
		for (Animal a : animals) {
			a.roam();
		}
	}
	
	public void eat() {
		for (Animal a : animals) {
			a.eat();
		}
	}
	
	public void sleep() {
		for (Animal a : animals) {
			a.sleep();
		}
	}
	
	public void play() {
		for (Animal a : animals) {
			if (a instanceof Cat) {
				Cat c = (Cat)a;
				c.play();
			}
			else if (a instanceof Dog) {
				Dog d = (Dog)a;
				d.play();
			}
		}
	}
	
	public void pet() {
		for (Animal a : animals) {
			if (a instanceof Cat) {
				Cat c = (Cat)a;
				c.pet();
			}
			else if (a instanceof Dog) {
				Dog d = (Dog)a;
				d.pet();
			}
		}
	}
}