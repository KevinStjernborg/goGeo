package shared;

import java.io.Serializable;

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
	private boolean requestOtherPlayersGuess;

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
		startMessage = "Game found";
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

}
