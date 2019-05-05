package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import shared.Guess;

/*
 * TODO
 * Lägg till vad som sker ett meddelande tas emot
 * skriv controller?
 * Ändra struktur från game till message.
 */

public class Connection {
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private int port;
	private String address;
//	private serverSender sender;
	private serverReceiver receiver;
	private Controller controller;
	
	
	public Connection(String address, int port, Controller controller) {
		this.address = address;
		this.port = port;
		this.controller = controller;
	}
	
	public void sendMessage(Guess guess) {
		try {
			oos.writeObject(guess);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void connect() {
		try {
			socket = new Socket(address, port);
			System.out.print("Connected to server");
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	
//	private class serverSender extends Thread {
//
//		public void run() {
//			oos.writeObject(guess);
//		}
//	}
	
	private class serverReceiver extends Thread{
		public void run() {
			while(true) {
				try {
					Guess guess = (Guess) ois.readObject();
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
	}
}