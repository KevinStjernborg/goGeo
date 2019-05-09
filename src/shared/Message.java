package shared;

import java.io.Serializable;

/**
 * T�nkt att fungera som den klassen som skickas fram och tillbaka, kan byggas p� med fler booleans beroende p� vad den inneh�ller
 * @author kevin
 *
 */

public class Message implements Serializable{
	private Guess guess;
	private int timerInt;
	private String playerName;
	private boolean containsGuess;
	private boolean containsStartMessage;
	
	public Message() {
		containsGuess = false;
		containsStartMessage = false;
	}

	public boolean containsGuess() {
		return containsGuess;
	}


	public boolean containsStartMessage() {
		return containsStartMessage;
	}

	public Guess getGuess() {
		return guess;
	}

	public int getStartTimer() {
		return timerInt;
	}

	public void setGuess(Guess guess) {
		containsGuess = true;
		this.guess = guess;
	}

	public void setStartTimer(int startTimer) {
		containsGuess = true;
		this.timerInt = startTimer;
	}
	
	
	
	
	
}
