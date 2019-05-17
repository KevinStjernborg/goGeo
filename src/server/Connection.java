package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 * A server class for the game which handles connecting clients by creating
 * {@link Game} objects.
 * 
 * @author Kevin Stjernborg & Malin Hällström
 *
 */
public class Connection {
	private int port;
	private Handler handler;
	private MatchMaker matchMaker;
	Buffer<Client> clientBuffer = new Buffer<Client>(); // Kanske skriva en queue klass? N�gon f�rdel med att byta?
	ArrayList<Game> games = new ArrayList<Game>();
	private Client tempClientOne;
	private Client tempClientTwo;


	/**
	 * Constructor for the class
	 * 
	 * @param port Port to be opened
	 */
	public Connection(int port) {
		this.port = port;
		handler = new Handler();
		handler.start();
		matchMaker = new MatchMaker();
		matchMaker.start();
		System.out.println("Constructor done // server");
	}

	/**
	 * Inner class handling connecting clients by creating {@link Client} objects
	 * and once an object is created it is put onto the buffer.
	 * 
	 * @author Kevin Stjernborg
	 *
	 */
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
					System.out.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Inner class that waits until atleast two {@link Client} objects are available
	 * from the buffer. The available client object will be used to create a
	 * {@link Game} object.
	 * 
	 * @author Kevin Stjernborg
	 *
	 */
	private class MatchMaker extends Thread {
		public void run() {
			while (true) {
				try {
					Thread.sleep(500);
					if (clientBuffer.size() >= 2) {
						tempClientOne = clientBuffer.get();
						tempClientOne.markAsClientOne();
						tempClientTwo = clientBuffer.get();
						tempClientTwo.markAsClientTwo();
						Game game = new Game(tempClientOne, tempClientTwo);
						tempClientOne.setGame(game);
						tempClientTwo.setGame(game);
						games.add(game);
						System.out.println("Game started // Server");

					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
