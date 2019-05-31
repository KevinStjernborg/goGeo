package client;

import java.util.Timer;
import gui.GameWindow;
import gui.Menu1;
import gui.Menu2;
import shared.Guess;
import shared.Locations;
import shared.Message;

/**
 * 
 * @author Said Mohammed & Kevin Stjernborg
 *
 */

public class Controller {

	private Connection connection;
	private Locations locations;
	private int hashMapChoice = 1;
	private Menu1 guiOne;
	private Menu2 guiTwo;
	private GameWindow gameWindowMP;


	/**
	 * Starts the main menu when the {@link Controller} object is created. 
	 */
	public Controller() {
		guiOne = new Menu1(this);
	}

	/**
	 * Sets the targeted city on the prompt Label on {@link GameWindow}. 
	 * 
	 * @param name of the city that the user should find. 
	 */
	public void setPromptInstruction(String name) {
		gameWindowMP.setInstruction(name);
	}

	/**
	 * Sets the timer value on the timer label on {@link GameWindow}. 
	 * 
	 * @param the value that the timer will show. 
	 */
	public void setTimer(String nr) {
		gameWindowMP.setTimerText(nr);
	}

	/**
	 * Sets the current score for each player on {@link GameWindow}. 
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
	 * Sets the players name on the correct label on {@link GameWindow}. 
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
	 * Writes a new line on the console on the {@link GameWindow}.
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
	 * Starts the second menu, {@link Menu2}
	 */

	public void startGameModeMenu() {
		guiTwo = new Menu2(this);
		
	}
	
	/**
	 * Initiates a multiplayer game by starting a {@link GameWindow} and setting up a connection 
	 * through {@link Connection}
	 */

	public void startMultiplayerGame() {
		gameWindowMP = new GameWindow(this, 1);
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
