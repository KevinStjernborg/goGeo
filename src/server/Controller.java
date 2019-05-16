package server;

public class Controller {
	private Connection connection;
	
	public Controller() {
	}
	
	
	public void start() {
		connection = new Connection(8050);
	}
}
