package server;

import shared.Guess;
import shared.Message;

/**
 * A class containing two {@link Client} object representing a game.
 * 
 * @author Kevin Stjernborg & Said Mohammed
 *
 */
public class Game {
	private Client clientOne;
	private Client clientTwo;
	private Message messageOne;
	private Message messageTwo;
	private boolean messageFromClientOneReceived = false;
	private boolean messageFromClientTwoReceived = false;

	/**
	 * Constructor
	 * 
	 * @param clientOne A client object representing player one
	 * @param clientTwo Player two A client object representing player two
	 */
	
	
	public Game(Client clientOne, Client clientTwo) {
		this.clientOne = clientOne;
		this.clientTwo = clientTwo;
		System.out.println("Game started");
		sendStartMessage();
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
 * A method that allows for a client to request the other playes guess
 * @param identifier an int representing the number of the client
 */
	public void getOtherPlayersGuess(int identifier) {
		if(identifier == 1) {
			if(messageFromClientTwoReceived == true) {
				messageTwo.setRequestBooleanAsTrue();
				clientOne.sendMessage(messageTwo);
			}else {
				Message message = new Message(); //create messageobject with message that other player also timed out
				message.setRequestBooleanAsTrue();
				clientOne.sendMessage(message);
			}

		}
		else if(identifier == 2 ) {
			if(messageFromClientOneReceived == true) {
				messageOne.setRequestBooleanAsTrue();
				clientTwo.sendMessage(messageOne);
			}else {
				Message message = new Message(); //create messageobject with message that other player also timed out
				message.setRequestBooleanAsTrue();
				clientTwo.sendMessage(message);
			}

		}
	}

	/**
	 * A setter for the {@link Message} containing guess of client one
	 * 
	 * @param message
	 */
	public void setMessageFromClientOne(Message message) {
		if (messageFromClientTwoReceived == true) {
			messageOne = message;
			clientOne.sendMessage(messageTwo);
			clientTwo.sendMessage(messageOne);
			messageFromClientOneReceived = false;
			messageFromClientTwoReceived = false;
		} else {
			messageOne = message;
			messageFromClientOneReceived = true;
		}
	}

	/**
	 * A setter for the {@link Message} containing guess of client two
	 * 
	 * @param message message
	 */
	public void setMessageFromClientTwo(Message message) {
		if (messageFromClientOneReceived == true) {
			messageTwo = message;
			clientOne.sendMessage(messageTwo);
			clientTwo.sendMessage(messageOne);
			messageFromClientOneReceived = false;
			messageFromClientTwoReceived = false;
		} else {
			messageTwo = message;
			messageFromClientTwoReceived = true;
		}
	}

}
