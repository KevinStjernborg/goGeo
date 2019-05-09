package client;


import Gui.GameWindow;
import shared.Guess;
import shared.Locations;
import shared.Message;


/*
 * Ska fungera som en l�nk mellan klassen f�r spelf�nstret och connection. 
 * Kan ocks� vara anv�ndbar om det ska hanteras flera f�nster, ex startmeny, spelf�nster, instruktioner osv.
 */
public class Controller {
	

	private Connection connection;
	private Locations locations;
	private GameWindow gameWindow;
//	private User user;
//	private Buffer<Locations> buffer = new Buffer<Locations>();


	public Controller() {
		gameWindow = new GameWindow(this);
		locations = new Locations();
		connection = new Connection("localhost",9000, this);
		gameWindow.setStartMessage();
	}

	public void setPromptInstruction(String name) {
		locations.getLocation(name);
		gameWindow.setInstruction(name);
	}

	public void setTimer(String nr) {
		gameWindow.setTimerText(nr);
	}
	/**
	 * visar poängen i Guit. 
	 * 
	 * @param score
	 * @param player Måste vara antingen 1 eller 2. 
	 */
	public void showPlayerScore(long score, int player) {
		if (player == 1 || player ==2) {
			gameWindow.setPlayerScore(score, player);
		}
	}
	/**
	 * Visar spelarnamnet i Guit
	 * 
	 * @param name
	 * @param player - Måste vara antingen 1 eller 2. 
	 */
	public void showPlayerName(String name, int player) {
		if(player == 1 || player == 2 ) {
			gameWindow.setPlayerName(name, player);
		}
	}
	public void showConsoleMessage(String message) {
		gameWindow.setConsoleText(message);
	}

	public void sendMessage(Guess guess) {
		Message message = new Message();
		message.setGuess(guess);
		connection.sendMessage(message);
	}

	/*
	 * L�gg till kod f�r vad som sker om de bara �r ett bekr�ftelsemeddelande fr�n servern att ett spel har startats
	 * 
	 */
	public void receiveMessage(Message message) {
		if(message.containsGuess()) {
			Guess guess = message.getGuess();
			gameWindow.getViewer().addOtherPlayersGuess(guess.getGeo());
			
		}
		if(message.containsStartMessage()) {    //Lägg till att skicka användarnamn till den andra
			gameWindow.setConsoleText(message.getStartMessage());
		}
	}
	
	

	public static void main(String[] args) {
		Controller c = new Controller();
		c.setPromptInstruction("Paris");
		c.setTimer("3");
		c.showPlayerScore(200000,1);
		c.showPlayerName("Sara", 1);
		c.showPlayerName("Pelle", 2);
		c.showPlayerScore(214214, 2);
		c.showPlayerScore(214214, 4);
		c.showConsoleMessage("HJSJJS"
				+ "chwonsolekjh\n"
				+ "Ny rad");
		c.showConsoleMessage("Nytt medd: AAAAAAAAAA");
		c.showConsoleMessage("m");


	}
}
