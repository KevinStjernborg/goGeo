package client;

import gui.GameW;
import gui.GameWindowMP;
import gui.GameWindowSP;
import gui.Menu1new;
import gui.Menu2new;
import shared.Guess;
import shared.Locations;
import shared.Message;



public class Controller {

	private Connection connection;
	private Locations locations;
	private int hashMapChoice = 1;
	private Menu1new guiOne;
	private Menu2new guiTwo;
	private GameW gameWindowMP;


	public Controller() {
		guiOne = new Menu1new(this);
	}

	public void setPromptInstruction(String name) {
		locations.getLocation(name);
		gameWindowMP.setInstruction(name);
	}

	public void setTimer(String nr) {
		gameWindowMP.setTimerText(nr);
	}

	
	public void showPlayerScore(int score, int player) {
		if (player == 1 || player == 2) {
			gameWindowMP.setPlayerScore(score, player);
		}
	}

	
	
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

	

	public void startGameModeMenu() {
		guiTwo = new Menu2new(this);
		
	}

	public void startMultiplayerGame() {
		gameWindowMP = new GameW(this, 1);
		connection = new Connection("localhost", 8050, this);
		gameWindowMP.setConsoleText("Searching for a game...");
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
			guess.calculateScore();
			gameWindowMP.getViewer().addOtherPlayersGuess(guess.getGeo());
			gameWindowMP.getViewer().setRoundAsFinished();
			gameWindowMP.setPlayerScore(guess.getScore(), 2);
		}
		if (message.containsStartMessage()) { // Lägg till att skicka användarnamn till den andra
			System.out.println("Start message received");
			gameWindowMP.getViewer().getLocationHashMap(message);
			gameWindowMP.setConsoleText(message.getStartMessage());
			gameWindowMP.startConsoleTimer();
		}
		if (message.containsRequest() == true && message.containsGuess()) { // Lägga till markers för den andra och rätt plats?
			gameWindowMP.setPlayerScore(message.getGuess().getScore(), 2);
			gameWindowMP.setConsoleText("Other player made it in time, their score has been updated.");
			gameWindowMP.setConsoleText("C'mon you can do it!");
		}

		if (message.containsRequest() == true && message.containsGuess() == false) {
			gameWindowMP.setConsoleText("You are in luck, other player timed out as well!");
		}
	}

}
