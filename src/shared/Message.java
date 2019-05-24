package shared;

import java.io.Serializable;
import java.util.Random;

/**
 * A class containing either a startmessage and a playername or a {@link Guess}
 * object.
 * 
 * @author Kevin Stjernborg
 *
 */

public class Message implements Serializable {
	private Guess guess;
	private String playerName;
	private String startMessage;
	private boolean containsGuess;
	private boolean containsStartMessage;
	private int[] caseChoices = new int[3];
	private boolean requestOtherPlayersGuess;
	private Random rand = new Random();

	/**
	 * Constructor
	 */
	public Message() {
		containsGuess = false;
		containsStartMessage = false;
		requestOtherPlayersGuess = false;
	}

	/**
	 * A getter for the boolean containsGuess
	 * 
	 * @return
	 */
	public boolean containsGuess() {
		return containsGuess;
	}
	public boolean containsRequest() {
		return requestOtherPlayersGuess;
	}
	
	public void setRequestBooleanAsTrue() {
		requestOtherPlayersGuess = true;
	}
	


	/**
	 * A getter for the boolean containsStartMessage
	 * 
	 * @return
	 */
	public boolean containsStartMessage() {
		return containsStartMessage;
	}

	/**
	 * A getter for the {@link Guess} object
	 * 
	 * @return
	 */
	public Guess getGuess() {
		return guess;
	}

	/**
	 * A method for setting the class {@link Guess} guess object
	 * 
	 * @param guess
	 */

	public void setGuess(Guess guess) {
		containsGuess = true;
		this.guess = guess;
	}

	/**
	 * A method for initializing the start message and changing the boolean
	 * containsStartMessage as true
	 */
	public void setStartMessage() {
		generateChoices();
		containsStartMessage = true;
	}

	/**
	 * A method for getting the start message
	 * 
	 * @return the start message
	 */

	public String getStartMessage() {
		return startMessage;
	}
	
	public void generateChoices() {
		for (int i = 0; i < caseChoices.length; i++) {
			caseChoices[i] = rand.nextInt(14) + 1;
		}
	}
	
	public int[] getChoices() {
		return caseChoices;
	}

}
