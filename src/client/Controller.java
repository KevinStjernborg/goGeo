package client;

import gui.GUIMenu1;
import gui.GUIMenu2;
import gui.GameWindowMP;
import gui.GameWindowSP;
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
//	private GameWindowSP gameWindow;
	private int hashMapChoice = 1;
	private GUIMenu1 guiOne;
	private GUIMenu2 guiTwo;
	private GameWindowMP gameWindowMP;
//	private User user;
//	private Buffer<Locations> buffer = new Buffer<Locations>();

	public Controller() {
//		gameWindow = new GameWindowSP(this, hashMapChoice);
		guiOne = new GUIMenu1(this);
	}

	public void setPromptInstruction(String name) {
		locations.getLocation(name);
		gameWindowMP.setInstruction(name);
	}

	public void setTimer(String nr) {
		gameWindowMP.setTimerText(nr);
	}

	/**
	 * visar poängen i Guit.
	 * 
	 * @param score
	 * @param player Måste vara antingen 1 eller 2.
	 */
	public void showPlayerScore(int score, int player) {
		if (player == 1 || player == 2) {
			gameWindowMP.setPlayerScore(score, player);
		}
	}

	/**
	 * Visar spelarnamnet i Guit
	 * 
	 * @param name
	 * @param player - Måste vara antingen 1 eller 2.
	 */
	public void showPlayerName(String name, int player) {
		if (player == 1 || player == 2) {
			gameWindowMP.setPlayerName(name, player);
		}
	}

	public void showConsoleMessage(String message) {
		gameWindowMP.setConsoleText(message);
	}

	public void sendMessage(Guess guess) {
		Message message = new Message();
		message.setGuess(guess);
		connection.sendMessage(message);
	}

	/*
	 * L�gg till kod f�r vad som sker om de bara �r ett bekr�ftelsemeddelande fr�n
	 * servern att ett spel har startats
	 * 
	 */

	public void startGameModeMenu() {
		guiTwo = new GUIMenu2(this);
	}

	public void startMultiplayerGame() {
		gameWindowMP = new GameWindowMP(this, 1);
		connection = new Connection("localhost", 8050, this);
		gameWindowMP.setConsoleText("Searching for a game...");
		guiTwo.dispose();
	}

	public void startSinglePlayerMenu() {

	}

	public void requestOtherPlayersGuess() {
		Message message = new Message();
		message.setRequestBooleanAsTrue();
		connection.sendMessage(message);
	}

	public void receiveMessage(Message message) {
		if (message.containsGuess() && message.containsRequest() == false) {
			Guess guess = message.getGuess();
			gameWindowMP.getViewer().addOtherPlayersGuess(guess.getGeo());
			gameWindowMP.getViewer().setRoundAsFinished();
			gameWindowMP.setPlayerScore(guess.getScore(), 2);
		}
		if (message.containsStartMessage()) { // Lägg till att skicka användarnamn till den andra
			System.out.println("Start message received");
			gameWindowMP.setConsoleText(message.getStartMessage());
			gameWindowMP.startConsoleTimer();
		}
		if (message.containsRequest() == true && message.containsGuess()) { // Lägga till markers för den andra och rätt plats?
			gameWindowMP.setPlayerScore(message.getGuess().getScore(), 2);
			gameWindowMP.setConsoleText("Other player made it in time, their score has been updated.");
			gameWindowMP.setConsoleText("C'mon you can do it!");
		}

		if (message.containsRequest() == true && message.getGuess() == null) {
			gameWindowMP.setConsoleText("You are in luck, other player timed out as well!");
		}
	}

}
