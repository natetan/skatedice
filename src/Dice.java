/*
 * Yulong Tan
 * July 2nd, 2015
 * 
 * This class represents dice with x number of sides
 */

import java.util.Random;

public class Dice {
	private Random r;
	private int sides;
	
	// Constructs a die with x number of sides
	public Dice(int sides) {
		this.sides = sides;
		this.r = new Random();
	}
	
	// Returns the number on the dice
	public int getNumber() {
		return this.r.nextInt(this.sides);
	}
}
