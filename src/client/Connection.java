package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import shared.Message;

/**
 * A class for connecting to the server with functionality for send and
 * receiving {@link Message} objects.
 * 
 * @author Kevin Stjernborg
 *
 */

public class Connection {
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private int port;
	private String address;
	private serverReceiver receiver;
	private Controller controller;

	/**
	 * Constructor for the class
	 * 
	 * @param address    The IP address to connect to
	 * @param port       Port to connect to
	 * @param controller a {@link Controller} for the class.
	 */
	public Connection(String address, int port, Controller controller) {
		this.address = address;
		this.port = port;
		this.controller = controller;
		connect();
		

	}

	/**
	 * Method for sending a {@link Message} object.
	 * 
	 * @param message Message object to be sent.
	 */
	public void sendMessage(Message message) {
		try {
			oos.writeObject(message);
			System.out.println("Guess sent from connection class");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * A method for connecting to the server and initializing the Objectinput and
	 * output streams.
	 */
	public void connect() {
		try {
			socket = new Socket(address, port);
//			System.out.print("Connected to server // klient");
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			receiver = new serverReceiver();
			receiver.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A private class that listens for incoming {@link Message} objects
	 * 
	 * @author Kevin Stjernborg
	 *
	 */

	private class serverReceiver extends Thread {
		public void run() {
			while (true) {
				try {
					Message message;
					message = (Message) ois.readObject();
					controller.receiveMessage(message);
					System.out.println("Message received on Clientside " + message.containsGuess() + message.containsStartMessage() + message.containsRequest());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
	}
}