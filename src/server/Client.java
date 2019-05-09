package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import shared.Guess;
import shared.Message;


public class Client {
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
//	private Guess guess;
	private Message message;
	private Receiver receiver;
	private Game game;
	private Boolean hasGuess;
	
	public Client(Socket socket) {
		this.socket = socket;
		hasGuess = false;
		receiver = new Receiver();
		receiver.start();
		try {
//			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setMessage(Message message) {
		this.message = message;
	}
	
	public Message getMessage() {
		setBooleanGuessFalse();
		return message;
	}
	
//	public void setGame(Game game) {
//		this.game = game;
//	}
	
	public void setBooleanGuessTrue() { //rename
		hasGuess = true;
	}
	
	public void setBooleanGuessFalse() { //rename
		hasGuess = false;
	}
	
	public boolean getBooleanGuess() { //rename
		return hasGuess;
	}
	
	public void sendMessage(Message message) {
		try {
			oos.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class Receiver extends Thread{
		
		public void run() {
			while(true) {
				try {
					ois = new ObjectInputStream(socket.getInputStream());
					
					message = (Message) ois.readObject();
					setMessage(message);
					setBooleanGuessTrue();
					System.out.println("Guess recieved");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	

	
	
}
