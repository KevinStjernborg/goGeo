package shared;

import java.io.Serializable;
import java.util.ArrayList;
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

	/**
	 * A method that generates 3 random ints and places them into an array.
	 * Uses an arraylist to avoid duplicates in the array.
	 */
	public void generateChoices() {
		int size = 14;

		ArrayList<Integer> list = new ArrayList<Integer>(size);
		for (int i = 1; i <= size; i++) {
			list.add(i);
		}

		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			caseChoices[i] = rand.nextInt(list.size());
			list.remove(caseChoices[i]);
		}
	}

	
	/**
	 * A getter for the array with case choices.
	 * @return caseChoices
	 */
	public int[] getChoices() {
		return caseChoices;
	}

}
