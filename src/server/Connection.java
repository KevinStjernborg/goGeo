package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {
	private int port;
	private Handler handler ;
	
	public Connection(int port) {
		this.port = port;
		
	}
	
	private class Handler extends Thread{
		public Handler() {
			
		}
		
		public void run() {
			try {
				ServerSocket sSocket = new ServerSocket();
				while(true) {
					Socket socket = sSocket.accept();
					Client client = new Client(socket);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
