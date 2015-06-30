import java.util.Random;

public class Dice {
	private Random r;
	private int number;
	
	public Dice(int sides) {
		this.r = new Random();
		this.number = this.r.nextInt(sides);
	}
	
	public int getNumber() {
		return this.number;
	}
}
