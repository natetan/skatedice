/*
 * Yulong Tan
 * July 2nd, 2015
 * 
 * This class represents Dice that deal with Skateboarding. 
 * This class was intended to help me learn some more tricks,
 * and it revolves around a dice that generates the stance, 
 * direction (frontside or backside), degrees (rotation), and
 * the trick itself. 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrickManager {
	private List<String> tricks;
	
	public static final String FILE = "trick-list";
	public static final int STANCES = 4;
	public static final int DIRECTIONS = 2;
	public static final int ROTATIONS = 4;
	
	// Constructs a list of tricks from an external file
	public TrickManager() throws FileNotFoundException {
		Scanner list = new Scanner(new File(FILE));
		this.tricks = new ArrayList<String>();
		while (list.hasNext()) {
			tricks.add(list.next());
		}
		list.close();
	}
	
	// Returns the String representation of the stance
	public String getStance() {
		Dice stance = new Dice(STANCES);
		int number = stance.getNumber();
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
	
	// Returns the String representation of the direction
	public String getDirection() {
		Dice direction = new Dice(DIRECTIONS);
		int number = direction.getNumber();
		if (number == 0) {
			return "frontside ";
		} else {
			return "backside ";
		}
	}
	
	// Returns the number of degrees of the rotation
	public int getDegrees() {
		Dice degrees = new Dice(ROTATIONS);
		int number = degrees.getNumber();
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
	
	// Returns the String representation of the trick name
	public String getTrick() {
		Dice trick = new Dice(this.tricks.size());
		return " " + this.tricks.get(trick.getNumber());
	}
	
	// Returns the String representation of the full trick to do
	public String printTrick() {
		return this.getStance() + this.getDirection()
				+ this.getDegrees() + this.getTrick();
	}
}
