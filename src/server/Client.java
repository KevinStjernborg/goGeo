package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import shared.Guess;


public class Client {
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Guess guess;
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
	
	public void setGuess(Guess guess) {
		this.guess = guess;
	}
	
	public Guess getGuess() {
		return guess;
	}
	
//	public void setGame(Game game) {
//		this.game = game;
//	}
	
	public void setBooleanGuessTrue() {
		hasGuess = true;
	}
	
	public void setBooleanGuessFalse() {
		hasGuess = false;
	}
	
	public boolean getBooleanGuess() {
		return hasGuess;
	}
	
	public void sendOtherPlayersGuess(Guess guess) {
		try {
			oos.writeObject(guess);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class Receiver extends Thread{
		
		public void run() {
			while(true) {
				try {
					ois = new ObjectInputStream(socket.getInputStream());
					guess = (Guess) ois.readObject();
					setGuess(guess);
					setBooleanGuessTrue();
					System.out.println("Guess recieved");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	

	
	
}
