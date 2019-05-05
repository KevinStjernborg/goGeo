package server;

import shared.Guess;


/*
 * TODO
 * Ta bort inre klass, onödigt? 
 */
public class Game {
	private Client clientOne;
	private Client clientTwo;
	private GuessListener guessListener;
	
	public Game(Client clientOne, Client clientTwo) {
		this.clientOne = clientOne;
		this.clientTwo = clientTwo;
		guessListener.start();
	}
	
	
	/**
	 * Skicka ut timer eller bara meddelande att starta i båda klienterna
	 */
	
	public void start() {
		
	}
	
	
	/**
	 * Klass för att ta emot gissning och skicka vidare till en annan klient
	 */
	private class GuessListener extends Thread {
		
		public void run() {
			while(true) {
				try {
					Thread.sleep(500);
					if(clientOne.getBooleanGuess() == true && clientTwo.getBooleanGuess() == true) {
						clientOne.sendOtherPlayersGuess(clientTwo.getGuess());
						clientTwo.sendOtherPlayersGuess(clientOne.getGuess());
						clientOne.setBooleanGuessFalse();
						clientTwo.setBooleanGuessFalse();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

}
