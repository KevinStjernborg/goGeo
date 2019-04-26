package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



public class Connection {
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private int port;
	private String address;
//	private serverSender sender;
	private serverReceiver receiver;
	
	
	public Connection(String address, int port) {
		this.address = address;
		this.port = port;
		
	}
	
	public void sendGuess(Guess guess) {
		try {
			socket = new Socket(address, port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(guess);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void connect() {
		
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
			try {
				ois = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			while(true) {
				try {
					Guess guess = (Guess) ois.readObject();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}
