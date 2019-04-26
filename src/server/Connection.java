package server;

import java.io.IOException;
import java.net.ServerSocket;

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
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
