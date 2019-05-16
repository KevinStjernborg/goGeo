package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import client.Controller;
import client.Viewer;
import shared.Guess;

import javax.swing.JButton;

import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.DropMode;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;

public class GameWindowMP extends JFrame implements ActionListener{


	private Controller controller;
	private String res;
	private Viewer viewer;

	//Bör skapa en dir med alla resources för att inte hårdkoda. 

	private ImageIcon infoIcon = new ImageIcon("images//icon.png");
	private ImageIcon arrowUpIcon = new ImageIcon("images//arrowUp.png");
	private ImageIcon arrowDownIcon = new ImageIcon("images//arrowDown.png");
	private ImageIcon resignImage = new ImageIcon("images//resign.png");
	private ImageIcon submitImage = new ImageIcon("images//Backgroundtestsa.png");

	private JPanel mapPanel = new JPanel();

	private JTextArea textPane = new JTextArea();
	private JScrollPane PanelTextConsole = new JScrollPane(textPane);
	private JPanel panel = new JPanel();
	private JPanel promptPanel = new JPanel();
	private JLabel promptLabel = new JLabel("InstructionPrompt");
	private JPanel boardPanel = new JPanel();
	private JLabel scoreHeader = new JLabel("SCORE");
	private JLabel player1lbl = new JLabel("Player 1");
	private JLabel player2lbl = new JLabel("Player 2");
	private JLabel timerLabel = new JLabel("5");
	private JSeparator separator = new JSeparator();
	private JLabel scorelbl1 = new JLabel("0");
	private JLabel scorelbl2 = new JLabel("0");
	private JPanel submitPanel = new JPanel();
	private JButton submitButton = new JButton(""); 
	private JPanel zoomPanel = new JPanel();
	private JButton zoomUp = new JButton("");
	private JButton zoomDown = new JButton("");
	private JPanel resignPanel = new JPanel();
	private JButton resignButton = new JButton("");
	private JPanel infoPanel = new JPanel();
	private JButton infoButton = new JButton();
	private JButton menuButton = new JButton("Menu");
	private JButton exitButton = new JButton("Exit");
	private int timerCount;
	private int rounds = 0;
	private int playerOneScore;
	private int playerTwoScore;
	private boolean consoleTimerAlive = false;
	private boolean gameTimerAlive;
	

	public GameWindowMP(int hashMapChoice) {
		viewer = new Viewer(hashMapChoice);
		initialize();
//		startConsoleTimer();

	}

	public GameWindowMP(Controller controller, int hashMapChoice) {
		viewer = new Viewer(hashMapChoice);
		this.controller = controller;
		initialize();
	}

	public void initialize() {
		getContentPane().setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		mapPanel.setBounds(15, 76, 1230, 743);
		getContentPane().add(mapPanel,BorderLayout.CENTER);
		mapPanel.add(viewer.getViewer());
		mapPanel.setLayout(new BoxLayout(mapPanel, BoxLayout.X_AXIS));

		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.BLACK);
		panel.setBounds(15, 835, 758, 135);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(PanelTextConsole);
		promptPanel.setBackground(SystemColor.activeCaption);
		getContentPane().add(promptPanel);

		textPane.setRows(10);
		textPane.setLineWrap(true);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textPane.setForeground(Color.WHITE);
		textPane.setBackground(Color.BLACK);
		textPane.setText("Welcome to goGeo! I Hope you'll have a great stay!");
		promptPanel.setBounds(98, 16, 1060, 44);

		PanelTextConsole.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		PanelTextConsole.setViewportView(textPane);

		promptLabel.setBackground(Color.BLACK);
		promptLabel.setForeground(new Color(0, 255, 0));
		promptLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		promptPanel.add(promptLabel);

		boardPanel.setBackground(new Color(0, 128, 128));
		boardPanel.setBounds(1398, 76, 498, 743);
		getContentPane().add(boardPanel);
		boardPanel.setLayout(null);

		scoreHeader.setHorizontalAlignment(SwingConstants.CENTER);
		scoreHeader.setFont(new Font("Tahoma", Font.BOLD, 17));
		scoreHeader.setBounds(195, 16, 88, 38);
		boardPanel.add(scoreHeader);
		player1lbl.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 19));

		player1lbl.setBounds(15, 81, 137, 38);
		boardPanel.add(player1lbl);
		player2lbl.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 19));

		player2lbl.setBounds(15, 152, 137, 38);
		boardPanel.add(player2lbl);

		timerLabel.setFont(new Font("Tahoma", Font.BOLD, 99));
		timerLabel.setForeground(Color.BLACK);
		timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timerLabel.setBounds(15, 316, 468, 411);
		boardPanel.add(timerLabel);

		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(0, 316, 498, 2);
		boardPanel.add(separator);
		scorelbl1.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 19));

		scorelbl1.setBounds(234, 81, 249, 38);
		boardPanel.add(scorelbl1);
		scorelbl2.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 19));

		scorelbl2.setBounds(234, 152, 249, 38);
		boardPanel.add(scorelbl2);
		submitPanel.setBackground(SystemColor.activeCaption);

		submitPanel.setBounds(788, 835, 370, 135);
		getContentPane().add(submitPanel);
		submitPanel.setLayout(null);

		submitButton.setIcon(submitImage);
		submitButton.setForeground(Color.GREEN);
		submitButton.setBackground(Color.GREEN);
		submitButton.setBounds(15, 16, 342, 103);
		submitPanel.add(submitButton);
		zoomPanel.setBackground(SystemColor.activeCaption);
		submitButton.addActionListener(this);

		zoomPanel.setBounds(1260, 76, 123, 743);
		getContentPane().add(zoomPanel);
		zoomPanel.setLayout(null);

		zoomUp.setBounds(15, 102, 45, 115);
		zoomPanel.add(zoomUp);
		fitIconToButton(zoomUp, arrowUpIcon);
		zoomUp.addActionListener(this);

		zoomDown.setBounds(15, 404, 45, 115);
		zoomPanel.add(zoomDown);
		fitIconToButton(zoomDown, arrowDownIcon);
		resignPanel.setBackground(SystemColor.activeCaption);
		zoomDown.addActionListener(this);

		resignPanel.setBounds(1398, 835, 498, 137);
		getContentPane().add(resignPanel);
		resignPanel.setLayout(null);

		resignButton.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 27));
		resignButton.setBounds(15, 16, 468, 103);
		resignPanel.add(resignButton);
		fitIconToButton(resignButton, resignImage);
		infoPanel.setBackground(SystemColor.activeCaption);

		infoPanel.setBounds(1398, 16, 498, 44);
		getContentPane().add(infoPanel);
		infoPanel.setLayout(null);
		infoButton.setToolTipText("Här");

		infoButton.setBounds(225, -1, 54, 45);
		infoPanel.add(infoButton);
		fitIconToButton(infoButton, infoIcon);

		menuButton.setBounds(0, 0, 210, 44);
		infoPanel.add(menuButton);
		menuButton.addActionListener(this);

		exitButton.setForeground(Color.RED);
		exitButton.setBounds(368, -1, 115, 45);
		infoPanel.add(exitButton);
		exitButton.addActionListener(this);

		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		setVisible(true);

	}

	/**
	 * Resizes the selected {@link ImageIcon} to fit the selected {@link JButton}
	 * @param button
	 * @param icon
	 */
	public void fitIconToButton(JButton button, ImageIcon icon) {
		Image img = icon.getImage();
		int offset = button.getInsets().left;
		int W = button.getWidth() - offset;
		int H = button.getHeight() - offset;
		Image resizedImage = img.getScaledInstance(W, H, java.awt.Image.SCALE_SMOOTH);
		button.setIcon(new ImageIcon(resizedImage));
	}

	public void setConsoleText(String text) {
		textPane.append("\n" + text);
	}

	public String getConsoleText() {
		return textPane.getText();
	}
	
	public Viewer getViewer() {
		return viewer;
	}

	public void setInstruction(String location) {
		promptLabel.setText("Tryck på: " + location);
	}

	public void setTimerText(String text) {
		timerLabel.setText(text);
		timerLabel.updateUI();
	}

	public void setPromptText(String text) {
		promptLabel.setText(text);
		promptLabel.updateUI();
	}
	public void setPlayerName(String name, int player) {
		if (player ==1 ) {
			player1lbl.setText(name);
			player1lbl.updateUI();
		}
		if (player == 2) {
			player2lbl.setText(name);
			player2lbl.updateUI();
		}
	}

	public void setPlayerScore(int score, int player) {
		if(player == 1 ) {
			scorelbl1.setText(res);
			scorelbl1.updateUI();
		}
		if( player == 2) {
			playerTwoScore = playerTwoScore + score;
			scorelbl2.setText("" + playerTwoScore);
			scorelbl2.updateUI();
		}		
	}
	
	
	public void setStartMessage() {
		setConsoleText("Searching for game...");
	}
	
//	public void setFoundGameMessage() {
//		setConsoleText("Round starts in:");
//	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == exitButton) {
			System.exit(EXIT_ON_CLOSE);

		}

		if(e.getSource() == menuButton) {
			dispose();
			new GUIMenu1(controller);
		}

		if (e.getSource() == submitButton) {
			Guess guess = viewer.getGuess();
			guess.setTime(timerCount);
			guess.calculateScore();
			setConsoleText("You were " + guess.getKilometers() + " Kilometers away from ");
			playerOneScore = playerOneScore +  guess.getScore();
			scorelbl1.setText("" + playerOneScore);
			controller.sendMessage(guess);
		}

		if (e.getSource() == resignButton) {
			//TODO Resign from game
		}

		if(e.getSource() == zoomDown) {
			int z = viewer.getViewer().getZoom();
			viewer.getViewer().setZoom(z+1);

		}
		if(e.getSource() == zoomUp) {
			int z = viewer.getViewer().getZoom();
			viewer.getViewer().setZoom(z-1);
		}


	}
	/**
	 * Starts the timer thats printed to the console in the gamewindow.
	 * 
	 */
	public void startConsoleTimer() {
		timerCount = 10;
        setConsoleText( "Round " + rounds + " will start in "  + timerCount + " seconds.");
        setConsoleText( "You will have 30 seconds each round, the timer is to the right!");
		viewer.setRoundAsUnfinished();
		Timer timer = new Timer();
		TimerTask myTask = new TimerTask() {
			
		    @Override
		    public void run() {
		    	if(rounds != 5) {
		    		if(timerCount <= -1 ) {
			        	timer.cancel();
			        	startGameTimer();
		    		}

		        } else {
		        	setConsoleText("You finished with a score of " + playerOneScore );
		        }
		        timerCount--;
		        
		        
		    }
		};

		timer.schedule(myTask, 0, 1000);
	}
	/*
	 * Lägg till metod för vad som sker när timern når noll, ex ett meddelande etc
	 */

	/**
	 * Starts the 30 second timer that defines each round, once the timer has run out
	 * and the the counter for rounds isnt at five it will start the three second timer again.
	 */

	public void startGameTimer() {
		viewer.enableMarkers();
		viewer.setGameLocation();
		viewer.removePaint();
		promptLabel.setText(" Find: " + viewer.getCurrentStringLocation());
		setConsoleText("Find: " + viewer.getCurrentStringLocation());
		rounds++;
		timerCount = 30;
		Timer timer = new Timer();
		TimerTask myTask = new TimerTask() {
			
		    @Override
		    public void run() {
		        setTimerText("" + timerCount);
		        timerCount--;
		        if(timerCount == -1 || viewer.isRoundFinished()) {
		        	timer.cancel();
		        	viewer.disableMarkers();
		        	startConsoleTimer();
		        }
		        
		    }
		};

		timer.schedule(myTask, 0, 1000);
	}



	public static void main(String[] args) {
//		GameWindow gw = new GameWindow();
	}
}
