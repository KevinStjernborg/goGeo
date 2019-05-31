package server;

public class Controller {
	private ServerController connection;
	
	public Controller() {
	}
	
	
	public void start() {
		connection = new ServerController(8050);
	}
}
