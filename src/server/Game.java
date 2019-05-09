package server;

import shared.Guess;
import shared.Message;

/**
 * A class containing two {@link Client} object representing a game.
 * 
 * @author Kevin Stjernborg
 *
 */
public class Game {
	private Client clientOne;
	private Client clientTwo;
	private GuessListener guessListener;

	/**
	 * Constructor
	 * 
	 * @param clientOne A client object representing player one
	 * @param clientTwo Player two A client object representing player two
	 */
	public Game(Client clientOne, Client clientTwo) {
		this.clientOne = clientOne;
		this.clientTwo = clientTwo;
		guessListener = new GuessListener();
		guessListener.start();
		System.out.println("Game started");
	}

	/**
	 * A method for sending out a message to the clients that a game has been found.
	 */

	public void sendStartMessage() {
		Message message = new Message();
		message.setStartMessage();
		clientOne.sendMessage(message);
		clientTwo.sendMessage(message);

	}

	/**
	 * Inner class that checks if a guess from both player has been received at the
	 * server. If the condition is met it will then forward the guess to the other
	 * player
	 * 
	 * @author Kevin Stjernborg
	 *
	 */
	private class GuessListener extends Thread {

		public void run() {
			while (true) {
				try {
					Thread.sleep(500);
					if (clientOne.getBooleanGuess() == true && clientTwo.getBooleanGuess() == true) {
						clientOne.sendMessage(clientTwo.getMessage());
						clientTwo.sendMessage(clientOne.getMessage());
						clientOne.setBooleanGuessFalse();
						clientTwo.setBooleanGuessFalse();
						System.out.println("Guess retrieved from both clients");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

}
