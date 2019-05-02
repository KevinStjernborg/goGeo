package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Connection {
	private int port;
	private Handler handler;
	private MatchMaker matchMaker;
	ArrayList<Client> clientList = new ArrayList<Client>();
	ArrayList<Game> games = new ArrayList<Game>();

	public Connection(int port) {
		this.port = port;
		handler = new Handler();
		handler.start();
		matchMaker = new MatchMaker();
		matchMaker.start();
	}

	private class Handler extends Thread {
		public Handler() {

		}

		public void run() {
			try {
				ServerSocket sSocket = new ServerSocket();
				while (true) {
					Socket socket = sSocket.accept();
					Client client = new Client(socket);
					clientList.add(client);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private class MatchMaker extends Thread {
		public void run() {
			while(true) {
				try {
					Thread.sleep(500);
					if(clientList.size() >= 2) {
						Game game = new Game(clientList.get(1), clientList.get(2));
						game.start();
						games.add(game);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}
