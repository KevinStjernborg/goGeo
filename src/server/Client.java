package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import shared.Message;

/**
 * A class representing a connected client which receives {@link Message} objects for the {@link Game}.
 * @author Kevin Stjernborg & Agnes Hägnestrand
 *
 */

public class Client {
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Message message;
	private Game game;
	private int identifier;

	private Boolean hasMessage;

	public Client(Socket socket) {
		this.socket = socket;
		hasMessage = false;
		Receiver receiver = new Receiver();
		receiver.start();
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * A method for setting the current message.
	 * 
	 * @param message
	 */
	public void setMessage(Message message) {
		this.message = message;
	}

	/**
	 * A method for getting the current message.
	 * 
	 * @return
	 */
	public Message getMessage() {
		setMessageBooleanFalse();
		return message;
	}

	public void markAsClientOne() {
		identifier = 1;
	}

	public void markAsClientTwo() {
		identifier = 2;
	}

	/**
	 * A method for setting the boolean hasMessage as true.
	 */
	public void setMessageBooleanTrue() { // rename
		hasMessage = true;
	}

	/**
	 * A method for setting the boolean hasMessage as false.
	 */

	public void setMessageBooleanFalse() { // rename
		hasMessage = false;
	}

	/**
	 * A method for getting the boolean hasMessage
	 */

	public boolean getMessageBoolean() { // rename
		return hasMessage;
	}

	/**
	 * A method for sending a {@link Message} to the connected client
	 * 
	 * @param message
	 */
	public void sendMessage(Message message) {
		try {
			oos.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A private class listening for incoming {@link Message} objects. If a message
	 * is receive the boolean hasMessage is changed and the message is set as the
	 * current message.
	 * 
	 * @author Kevin Stjernborg
	 *
	 */

	private class Receiver extends Thread {

		public Receiver() {
			try {
				ois = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			while (true) {
				try {
					message = (Message) ois.readObject();
					if (message.containsGuess()) {
						if (identifier == 1) {
							game.setMessageFromClientOne(message);
						
						} else {
							game.setMessageFromClientTwo(message);
						}
					}

					if (message.containsRequest()) {
						game.getOtherPlayersGuess(identifier);
						System.out.println("Request message received on serverside");
					}
				} catch (Exception e) {
					if (e.getMessage().contains("Socket closed")) {
						// Thrown with message "socket closed" when the client is shutting down. No need
						// to print.
					} else if (e.getMessage().contains("Connection reset")) {
						// No need to print.

					} else {
						e.printStackTrace();
					}
				}
			}

		}

	}
}
