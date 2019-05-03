package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import client.Guess;

public class Client {
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Guess guess;
	private Receiver receiver;
	
	public Client(Socket socket) {
		this.socket = socket;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
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
					Guess guess = (Guess) ois.readObject();
					setGuess(guess);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	

	
	
}
