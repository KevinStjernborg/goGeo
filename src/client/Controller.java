package client;

import shared.Guess;

/*
 * Ska fungera som en länk mellan klassen för spelfönstret och connection. 
 * Kan också vara användbar om det ska hanteras flera fönster, ex startmeny, spelfönster, instruktioner osv.
 */
public class Controller {
	private DemoWindow demoWindow;
	private Connection connection;
	
//	public Controller(DemoWindow demoWindow,Connection connection ) {
//		this.demoWindow = demoWindow;
//		this.connection = connection;
//	}
	
	
	/*
	 * Tillfällig lösning ska ändras till att connect sker på anrop från startmenyn
	 */
	public Controller() {
		 demoWindow = new DemoWindow(this);
		 connection = new Connection("Localhost", 9000,this);
//		 connect();  bortkommenterad för test, bör finnas sen
		 demoWindow.getViewer().setController(this);
	}
	
	
	/*
	 * bortkommenterad för test, bör finnas sen
	 */
	
//	public void connect() {
//		connection.connect();
//	}
	
	public void sendMessage(Guess guess) {
		connection.sendMessage(guess);
	}
	
	/*
	 * Lägg till kod för vad som sker om de bara är ett bekräftelsemeddelande från servern att ett spel har startats
	 * 
	 */
	public void receiveMessage(Guess guess) {
		demoWindow.getViewer().addOtherPlayersGuess(guess.getGeo());
	}
	
	
	

	
}
