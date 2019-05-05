package shared;

/**
 * Tänkt att fungera som den klassen som skickas fram och tillbaka, kan byggas på med fler booleans beroende på vad den innehåller
 * @author kevin
 *
 */

public class Message {
	private Guess guess;
	private int timerInt;
	private boolean containsGuess;
	private boolean containsTimerInt;
	
	public Message() {
		containsGuess = false;
		containsTimerInt = false;
	}

	public boolean containsGuess() {
		return containsGuess;
	}


	public boolean containsStartTimer() {
		return containsTimerInt;
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
