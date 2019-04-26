package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;



public class Connection {
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private int port;
	private String address;
	
	
	public Connection(String address, int port) {
		this.address = address;
		this.port = port;
	}
	
	public void sendGuess(Guess guess) {
		try {
			socket = new Socket(address, port);
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void connect() {
		
	}
}
