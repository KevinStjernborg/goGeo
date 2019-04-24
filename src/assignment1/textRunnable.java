package assignment1;

import java.util.Random;

import javax.swing.JLabel;

/**
 * A class that extends and acts as a {@link JLabel} and changes the location of the
 * label via {@link Random}.
 * The boolean textBoolean acts as a condition for the thread to start or to stop.
 * @author Kevin Stjernborg
 */
public class textRunnable extends JLabel implements Runnable {
	private Boolean textBoolean;
	private Random rand;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A constructor for the class that initiates the boolean as false and sets the text and size of the 
	 * class
	 */
	public textRunnable() {
		textBoolean = false;
		setText("Text Thread");
		setSize(200, 200);
		setBounds(100, 100, 200, 200);
		rand = new Random();
	}

	/**
	 * A method for stopping the text by changing the boolean to false
	 */
	public void stop() {
		textBoolean = false;
	}

	/**
	 * a method for starting the random text by changing the boolean to true
	 */
	public void start() {
		textBoolean = true;
	}

	/**
	 * An endless loop waits and listen for the boolean to change to either false or true.
	 * 
	 */
	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (textBoolean == true)

				setLocation(rand.nextInt(100), rand.nextInt(100));

		}

	}

}