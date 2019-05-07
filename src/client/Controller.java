package client;

import Gui.GameWindow;
import shared.Guess;

/*
 * Ska fungera som en l�nk mellan klassen f�r spelf�nstret och connection. 
 * Kan ocks� vara anv�ndbar om det ska hanteras flera f�nster, ex startmeny, spelf�nster, instruktioner osv.
 */
public class Controller {
	//private DemoWindow demoWindow; SSS
	private Connection connection;
	
	private GameWindow window;
	
	
//	public Controller(DemoWindow demoWindow,Connection connection ) {
//		this.demoWindow = demoWindow; 
//		this.connection = connection;
//	}
	
	
	/*
	 * Tillf�llig l�sning ska �ndras till att connect sker p� anrop fr�n startmenyn
	 */
	public Controller() {
		// demoWindow = new DemoWindow(this); SSS
		 connection = new Connection("Localhost", 9000,this);
//		 connect();  bortkommenterad f�r test, b�r finnas sen
		// demoWindow.getViewer().setController(this); SSS
		 window = new GameWindow();
	}
	
	
	/*
	 * bortkommenterad f�r test, b�r finnas sen
	 */
	
//	public void connect() {
//		connection.connect();
//	}
	
	public void sendMessage(Guess guess) {
		connection.sendMessage(guess);
	}
	
	/*
	 * L�gg till kod f�r vad som sker om de bara �r ett bekr�ftelsemeddelande fr�n servern att ett spel har startats
	 * 
	 */
	public void receiveMessage(Guess guess) {
	//	demoWindow.getViewer().addOtherPlayersGuess(guess.getGeo()); SSS
	}
	
	
	

	
}
