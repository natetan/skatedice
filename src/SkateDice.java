import java.io.FileNotFoundException;


public class SkateDice {
	
	public static void main(String[] args) throws FileNotFoundException {
		TrickManager manager = new TrickManager();
		giveIntro();
		getTrick(manager);
	}
	
	public static void giveIntro() {
		System.out.println("This generates random tricks for me to do.");
		System.out.println("Technically, this should help me work on some tricks");
		System.out.println();
	}
	
	public static void getTrick(TrickManager manager) {
		System.out.println("Here's the trick: " + manager.printTrick());
	}

}
