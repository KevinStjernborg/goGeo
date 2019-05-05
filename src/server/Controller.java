package server;

public class Controller {
	private Connection connection;
	
	public Controller() {
		connection = new Connection(9000);
	}
}
