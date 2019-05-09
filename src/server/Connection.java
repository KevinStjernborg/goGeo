package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Connection {
	private int port;
	private Handler handler;
	private MatchMaker matchMaker;
	Buffer<Client> clientBuffer = new Buffer<Client>();  //Kanske skriva en queue klass? N�gon f�rdel med att byta? 
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
				ServerSocket sSocket = new ServerSocket(port);
				System.out.println("Server started on port" + port);
				while (true) {
					Socket socket = sSocket.accept();
					Client client = new Client(socket);
					clientBuffer.put(client);
					System.out.println("Client connected // Server");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private class MatchMaker extends Thread {
		public void run() {
			while (true) {
				try {
					Thread.sleep(500);
					if (clientBuffer.size() >= 2) {
						Game game = new Game(clientBuffer.get(), clientBuffer.get());
						game.sendStartMessage();
						games.add(game);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
