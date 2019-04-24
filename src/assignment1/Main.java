package assignment1;

/**
 *  A class that acts as a main method for assignemnt 1, da218
 * @author Kevin Stjernborg
 */

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		GUI gui = new GUI();
		gui.setController(controller);
		gui.Start();
		
	}
}
