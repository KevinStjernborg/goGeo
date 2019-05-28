package client;

import java.util.Timer;

import gui.GameW;
import gui.GameWindowMP;
import gui.GameWindowSP;
import gui.Menu1new;
import gui.Menu2new;
import server.Game;
import shared.Guess;
import shared.Locations;
import shared.Message;

/**
 * 
 * @author 
 *
 */

public class Controller {

	private Connection connection;
	private Locations locations;
	private int hashMapChoice = 1;
	private Menu1new guiOne;
	private Menu2new guiTwo;
	private GameW gameWindowMP;


	/**
	 * Starts the main menu when the {@link Controller} object is created. 
	 */
	public Controller() {
		guiOne = new Menu1new(this);
	}

	/**
	 * Sets the targeted city on the prompt Label on {@link GameW}. 
	 * 
	 * @param name of the city that the user should find. 
	 */
	public void setPromptInstruction(String name) {
		locations.getLocation(name);
		gameWindowMP.setInstruction(name);
	}

	/**
	 * Sets the timer value on the timer label on {@link GameW}. 
	 * 
	 * @param the value that the timer will show. 
	 */
	public void setTimer(String nr) {
		gameWindowMP.setTimerText(nr);
	}

	/**
	 * Sets the current score for each player on {@link GameW}. 
	 * 
	 * @param score, the calculated score based on the players participation in the game. 
	 * @param player, the player receiving the score. 
	 */
	
	public void showPlayerScore(int score, int player) {
		if (player == 1 || player == 2) {
			gameWindowMP.setPlayerScore(score, player);
		}
	}

	/**
	 * Sets the players name on the correct label on {@link GameW}. 
	 * 
	 * @param name, the identifier for the player
	 * @param player, which player that gets the identifier. 
	 */
	
	public void showPlayerName(String name, int player) {
		if (player == 1 || player == 2) {
			gameWindowMP.setPlayerName(name, player);
		}
	}

	/**
	 * Writes a new line on the console on the {@link GameW}.
	 * 
	 * @param message, the message that is shown. 
	 */
	public void showConsoleMessage(String message) {
		gameWindowMP.setConsoleText(message);
	}

	/**
	 * takes in a Guess object which is converted to a {@link Message} 
	 * and sent through the server via {@link Connection}. 
	 * 
	 * @param guess 
	 */
	public void sendMessage(Guess guess) {
		Message message = new Message();
		message.setGuess(guess);
		connection.sendMessage(message);
	}

	
	/**
	 * Starts the second menu, {@link Menu2new}
	 */

	public void startGameModeMenu() {
		guiTwo = new Menu2new(this);
		
	}
	
	/**
	 * Initiates a multiplayer game by starting a {@link GameW} and setting up a connection 
	 * through {@link Connection}
	 */

	public void startMultiplayerGame() {
		gameWindowMP = new GameW(this, 1);
		connection = new Connection("localhost", 8050, this);
		gameWindowMP.setConsoleText("Searching for a game...");
	}

	public void startSinglePlayerMenu() {
	}

	/**
	 * Whenever a {@link Timer} timed out this method requests the guess of the opponent player. 
	 * 
	 */
	public void requestOtherPlayersGuess() {
		Message message = new Message();
		message.setRequestBooleanAsTrue();
		connection.sendMessage(message);
	}

	/**
	 * this method handles the {@link Message} object depending on the boolean values that
	 * the object contains. 
	 * 
	 * @param message
	 */
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
