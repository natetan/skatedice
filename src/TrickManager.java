import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TrickManager {
	private Dice stance;
	private Dice direction;
	private Dice degrees;
	private Dice trick;
	private List<String> tricks;
	
	public static final String FILE = "trick-list";
	public static final int STANCES = 4;
	public static final int DIRECTIONS = 2;
	public static final int DEGREES = 4;
	
	public TrickManager() throws FileNotFoundException {
		Scanner list = new Scanner(new File(FILE));
		this.tricks = new ArrayList<String>();
		while (list.hasNext()) {
			tricks.add(list.next());
		}
		this.stance = new Dice(STANCES);
		this.direction = new Dice(DIRECTIONS);
		this.degrees = new Dice(DEGREES);
		this.trick = new Dice(tricks.size());
	}
	
	public String getStance() {
		int number = this.stance.getNumber();
		if (number == 0) {
			return "regular ";
		} else if (number == 1) {
			return "switch ";
		} else if (number == 2) {
			return "nollie ";
		} else {
			return "fakie ";
		}
	}
	
	public String getDirection() {
		int number = this.stance.getNumber();
		if (number == 0) {
			return "frontside ";
		} else {
			return "backside ";
		}
	}
	
	public int getDegrees() {
		int number = this.stance.getNumber();
		if (number == 0) {
			return 0;
		} else if (number == 1) {
			return 180;
		} else if (number == 2) {
			return 360;
		} else {
			return 540;
		}
	}
	
	public String getTrick() {
		return " " + this.tricks.get(this.trick.getNumber());
	}
	
	public String printTrick() {
		return this.getStance() + this.getDirection()
				+ this.getDegrees() + this.getTrick();
	}
}
