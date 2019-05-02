package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos; 
	
	public Client(Socket socket) {
		this.socket = socket;
		
	}
	
	private class receiver{
		
	}
	
	private class sender{
		
	}
	
	
}
