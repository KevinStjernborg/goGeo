package server;

import shared.Guess;
import shared.Message;


/*
 * TODO
 * Ta bort inre klass, on�digt? 
 */
public class Game {
	private Client clientOne;
	private Client clientTwo;
	private GuessListener guessListener;
	
	public Game(Client clientOne, Client clientTwo) {
		this.clientOne = clientOne;
		this.clientTwo = clientTwo;
		guessListener = new GuessListener();
		guessListener.start();
		System.out.println("Game started");
	}
	
	
	/**
	 * Skicka ut timer eller bara meddelande att starta i b�da klienterna
	 */
	
	public void sendStartMessage() {
		Message message = new Message();
		message.setStartMessage();
		clientOne.sendMessage(message);
		clientTwo.sendMessage(message);
		
	}
	
	
	/**
	 * Klass f�r att ta emot gissning och skicka vidare till en annan klient
	 */
	private class GuessListener extends Thread {
		
		public void run() {
			while(true) {
				try {
					Thread.sleep(500);
					if(clientOne.getBooleanGuess() == true && clientTwo.getBooleanGuess() == true) {
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
