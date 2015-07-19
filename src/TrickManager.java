/*
 * Yulong Tan
 * July 2nd, 2015
 * 
 * This class represents Dice that deal with Skateboarding. 
 * This class was intended to help me learn some more tricks,
 * and it revolves around a dice that generates the stance
 * (regular, switch, nollie, fakie), direction (frontside, backside), 
 * degrees (180, 360, 540), and then the trick itself. 
 */

import java.util.ArrayList;
import java.util.List;

public class TrickManager {
	// Fields
	private List<String> tricks;
	
	// Class constants
	public static final int STANCES = 4;
	public static final int DIRECTIONS = 3;
	public static final int ROTATIONS = 3;
	public static final boolean EASY = false;
	
	// Constructs a list of standard skateabord tricks
	public TrickManager() {
		String[] list = {"ollie", "kickflip", "heelflip", "revert",
				"bigspin", "shuvit"
		};
		this.tricks = new ArrayList<String>();
		for (String trick : list) {
			this.tricks.add(trick);
		}
	}
	
	// Returns the String representation of the stance
	private String getStance() {
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
	private String getDirection() {
		Dice direction = new Dice(DIRECTIONS);
		int number = direction.getNumber();
		if (number == 0) {
			return "frontside ";
		} else {
			return "backside ";
		}
	}
	
	// Returns the number of degrees of the rotation
	private int getDegrees() {
		Dice degrees = new Dice(ROTATIONS);
		int number = degrees.getNumber();
		if (number == 0) {
			return 180;
		} else if (number == 1) {
			return 360;
		} else {
			return 540;
		}
	}
	
	// Returns the String representation of the trick name
	private String getTrick() {
		Dice trick = new Dice(this.tricks.size());
		return this.tricks.get(trick.getNumber());
	}
	
	// Returns the String representation of the full trick to do
	public String printTrick() {
		String trick = this.getTrick();
		if (EASY) {
		return this.getStance() + this.getDirection()
				+ this.getDegrees() + " " + trick;
		} else {
			return this.getStance() + this.getDirection()
					+ this.getDegrees() + " " + trick + 
					" " + this.ender(trick);
		}
	}
	
	// This method takes a String as an argument and returns a new trick to the
	// end of the trick name
	private String ender(String trick) {
		String[] flipTricks = {"heelflip", "kickflip"};
		Dice flipDice = new Dice(flipTricks.length);
		if (trick.equals("heelflip") || trick.equals("kickflip")) {
			return "shuvit";
		} else if (trick.equals("shuvit")) {
			// return either heelflip or kickflip
			return flipTricks[flipDice.getNumber()];
		} else {
			return "";
		}
	}
}
