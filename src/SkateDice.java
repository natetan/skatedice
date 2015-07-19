/*
 * Yulong Tan
 * July 2nd, 2015
 * 
 * This class generates a random skateboard trick. 
 */

import java.util.Scanner;

public class SkateDice {

	public static void main(String[] args) {
		TrickManager manager = new TrickManager();
		giveIntro();
		getTrick(manager);
	}
	
	// Gives an introduction to the program
	public static void giveIntro() {
		System.out.println("This generates random tricks for me to do.");
		System.out.println("Technically, this should help me work on some tricks");
		System.out.println();
	}
	
	// Generates a trick from the manager
	public static void getTrick(TrickManager manager) {
		Scanner console = new Scanner(System.in);
		boolean stop = false;
		int i = 1;
		while (!stop) {
			System.out.println("Trick " + i + ": " + manager.printTrick());
			System.out.println();
			i++;
			System.out.print("Do you want another trick? (y/n)? ");
			String response = console.next().toLowerCase();
			if (!response.startsWith("y")) {
				stop = true;
			}
		}
		console.close();
		System.out.println("A total of " + (i - 1) + " tricks were printed out");
	}
}
