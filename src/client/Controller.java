package client;

import shared.Guess;

/*
 * Ska fungera som en l�nk mellan klassen f�r spelf�nstret och connection. 
 * Kan ocks� vara anv�ndbar om det ska hanteras flera f�nster, ex startmeny, spelf�nster, instruktioner osv.
 */
public class Controller {
	private DemoWindow demoWindow;
	private Connection connection;
	
	public Controller(DemoWindow demoWindow,Connection connection ) {
		this.demoWindow = demoWindow;
		this.connection = connection;
	}
	
	
	public void connect() {
		connection.connect();
	}
	
	public void sendMessage(Guess guess) {
		connection.sendMessage(guess);
	}
	
	/*
	 * L�gg till kod f�r vad som sker om de bara �r ett bekr�ftelsemeddelande fr�n servern att ett spel har startats
	 * 
	 */
	public void receiveMessage(Guess guess) {
		demoWindow.getViewer().addOtherPlayersGuess(guess.getGeo());
	}
	
	
	

	
}