package gui;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import shared.Guess;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Component;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;

//import Gui.GameW;
import client.Controller;
import client.Viewer;

//import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;


import java.awt.Color;

import java.awt.Font;

import java.awt.GridBagConstraints;

import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;



public class GameW extends JFrame implements ActionListener {

	private JPanel promptPanel = new JPanel();
	private JLabel promptLabel = new JLabel("Get Ready!!!");
	private JPanel buttonPanel = new JPanel();
	private JPanel underColorPanel = new JPanel();
	private JPanel btnGridPanel = new JPanel();
	private JButton infoBtn = new JButton("Instructions");
	private JButton exitButton = new JButton("Resign & Exit");
	private JPanel mapPanel = new JPanel();
	private JPanel zoomInnerPanel = new JPanel();
	private JButton zoomInBtn = new JButton("");
	private JButton zoomOutBtn = new JButton("");
	private JPanel BoardPanel = new JPanel();
	private JPanel outerScorePanel = new JPanel();
	private JPanel panel = new JPanel();
	private JLabel player1lbl = new JLabel("YOU                    ");
	private JLabel scorelbl1 = new JLabel("0 ");
	private JPanel innerScorePanel = new JPanel();
	private JLabel player2lbl = new JLabel("OPPONENT            ");
	private JLabel scorelbl2 = new JLabel("0  ");
	private JPanel outerTmerPanel = new JPanel();
	private JPanel innerTimerPanel = new JPanel();
	private	JLabel lblTimer = new JLabel("TIMER :     ");
	private	JLabel timerValueLabel = new JLabel("10");
	private	JPanel textPanel = new JPanel();
	private	JScrollPane scrollPane = new JScrollPane();
	private	JTextArea textArea = new JTextArea();
	private	JLabel lblBl = new JLabel("Welcome to goGeo! ");
	private	JPanel innerSubmitPanel = new JPanel();
	private	JButton submitButton = new JButton("SUBMIT");

	
	private ImageIcon arrowDown = new ImageIcon("images\\MINUS.png");
	private ImageIcon arrowUp = new ImageIcon("images\\PLUS.png");
	private final JPanel outerSubmitPanel = new JPanel();
	private final JPanel zoomOuterPanel = new JPanel();

	private Viewer viewer;
	private Controller controller;
	
	private int playerOneScore;
	private int playerTwoScore;
	private int timerCount;
	private int rounds = 0;
	private final JLabel lblGogeo = new JLabel("goGeo");

	public GameW(Controller controller, int hashMapChoice) {
		viewer = new Viewer(hashMapChoice);
		this.controller = controller;
		initialize();
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public GameW(int hashMapChoice) {
		viewer = new Viewer(hashMapChoice);
		initialize();
	}

	public void initialize() {
		setTitle("goGeo");
		getContentPane().setBackground(new Color(245, 255, 250));
		setForeground(Color.MAGENTA);
		getContentPane().setForeground(Color.WHITE);
		setBackground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[799.00,grow][][436.00,grow,right]", "[64.00,grow][581.00,grow][65.00,grow,fill]"));
		promptPanel.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 128, 128)));

		promptPanel.setForeground(Color.YELLOW);
		promptPanel.setBackground(new Color(0, 128, 128));
		getContentPane().add(promptPanel, "cell 0 0,grow");
		promptPanel.setLayout(new BorderLayout(0, 0));

		promptLabel.setBackground(new Color(0, 128, 128));
		promptLabel.setForeground(new Color(245, 255, 250));
		promptLabel.setFont(new Font("Snap ITC", Font.BOLD, 27));
		promptLabel.setHorizontalAlignment(SwingConstants.CENTER);
		promptPanel.add(promptLabel, BorderLayout.CENTER);
		buttonPanel.setBorder(new CompoundBorder(new MatteBorder(1, 1, 5, 1, (Color) new Color(0, 128, 128)), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));

		buttonPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(buttonPanel, "cell 2 0,growx,aligny top");
		buttonPanel.setLayout(new BorderLayout(0, 0));

		underColorPanel.setBackground(new Color(245, 245, 245));
		buttonPanel.add(underColorPanel, BorderLayout.SOUTH);
		lblGogeo.setForeground(new Color(0, 128, 128));
		lblGogeo.setFont(new Font("Snap ITC", Font.ITALIC, 50));
		
		underColorPanel.add(lblGogeo);

		btnGridPanel.setBackground(Color.DARK_GRAY);
		buttonPanel.add(btnGridPanel, BorderLayout.NORTH);
		btnGridPanel.setLayout(new GridLayout(0, 2, 0, 0));
		infoBtn.setBackground(new Color(220, 220, 220));
		infoBtn.setFont(new Font("Snap ITC", Font.ITALIC, 17));
		infoBtn.setForeground(new Color(0, 128, 128));
		btnGridPanel.add(infoBtn);
		exitButton.setBackground(new Color(255, 0, 0));
		exitButton.setFont(new Font("Snap ITC", Font.ITALIC, 16));
		exitButton.setForeground(new Color(0, 0, 0));
		btnGridPanel.add(exitButton);
		mapPanel.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 128, 128)));
		exitButton.addActionListener(this);
		infoBtn.addActionListener(this);

		mapPanel.setForeground(Color.WHITE);
		mapPanel.setBackground(Color.GRAY);
		getContentPane().add(mapPanel, "cell 0 1,grow");
		mapPanel.setLayout(new BorderLayout(0, 0));
		mapPanel.add(viewer.getViewer(),BorderLayout.CENTER);
		zoomOuterPanel.setBackground(new Color(245, 255, 250));

		getContentPane().add(zoomOuterPanel, "cell 1 1,grow");
		zoomOuterPanel.setLayout(new MigLayout("", "[]", "[581.00,grow]"));
		zoomOuterPanel.add(zoomInnerPanel, "cell 0 0");
		zoomInnerPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 128), new Color(0, 139, 139)));

		zoomInnerPanel.setBackground(new Color(245, 255, 250));
		GridBagLayout gbl_zoomInnerPanel = new GridBagLayout();
		gbl_zoomInnerPanel.columnWidths = new int[]{56, -26};
		gbl_zoomInnerPanel.rowHeights = new int[]{143, 266, 155, 0};
		gbl_zoomInnerPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_zoomInnerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		zoomInnerPanel.setLayout(gbl_zoomInnerPanel);

		GridBagConstraints gbc_zoomInBtn = new GridBagConstraints();
		gbc_zoomInBtn.gridwidth = 2;
		gbc_zoomInBtn.fill = GridBagConstraints.VERTICAL;
		gbc_zoomInBtn.insets = new Insets(0, 0, 5, 0);
		gbc_zoomInBtn.gridx = 0;
		gbc_zoomInBtn.gridy = 0;

		fitIconToButton(zoomInBtn, arrowUp);
		zoomInBtn.setBorder(new LineBorder(new Color(0,128,128), 12, true));
		zoomInBtn.setBackground(new Color(245, 255, 250));
		zoomInnerPanel.add(zoomInBtn, gbc_zoomInBtn);
		zoomInBtn.addActionListener(this);

		GridBagConstraints gbc_zoomOutBtn = new GridBagConstraints();
		gbc_zoomOutBtn.gridwidth = 2;
		gbc_zoomOutBtn.fill = GridBagConstraints.VERTICAL;
		gbc_zoomOutBtn.gridx = 0;
		gbc_zoomOutBtn.gridy = 2;


		fitIconToButton(zoomOutBtn, arrowDown);
		zoomOutBtn.setBorder(new LineBorder(new Color(0, 128, 128), 12, true));
		zoomOutBtn.setBackground(new Color(245, 255, 250));
		zoomInnerPanel.add(zoomOutBtn, gbc_zoomOutBtn);
		zoomOutBtn.addActionListener(this);

		BoardPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 139, 139), new Color(0, 139, 139), new Color(0, 128, 128), new Color(0, 128, 128)), new BevelBorder(BevelBorder.LOWERED, new Color(0, 139, 139), new Color(0, 139, 139), new Color(0, 128, 128), new Color(0, 128, 128))));
		getContentPane().add(BoardPanel, "cell 2 1,grow");
		BoardPanel.setLayout(new GridLayout(0, 1, 0, 0));

		BoardPanel.add(outerScorePanel);
		outerScorePanel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(248, 248, 255), new Color(0, 0, 0), null, null));

		panel.setBackground(new Color(0, 139, 139));
		outerScorePanel.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel.add(player1lbl);
		player1lbl.setForeground(new Color(245, 255, 250));
		player1lbl.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 22));

		panel.add(scorelbl1);
		scorelbl1.setForeground(new Color(245, 255, 250));
		scorelbl1.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 25));
		innerScorePanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 128, 128), new Color(0, 0, 0), null, null));

		innerScorePanel.setBackground(new Color(245, 245, 245));
		outerScorePanel.add(innerScorePanel);
		innerScorePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		player2lbl.setForeground(new Color(0, 128, 128));
		player2lbl.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 22));
		innerScorePanel.add(player2lbl);

		scorelbl2.setForeground(new Color(0, 128, 128));
		scorelbl2.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 25));
		innerScorePanel.add(scorelbl2);

		BoardPanel.add(outerTmerPanel);
		outerTmerPanel.setLayout(new BorderLayout(0, 0));
		innerTimerPanel.setForeground(Color.WHITE);
		innerTimerPanel.setBackground(new Color(0, 0, 0));
		outerTmerPanel.add(innerTimerPanel, BorderLayout.CENTER);
		innerTimerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblTimer.setForeground(Color.WHITE);
		lblTimer.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 32));
		innerTimerPanel.add(lblTimer);

		timerValueLabel.setForeground(Color.WHITE);
		timerValueLabel.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 61));
		innerTimerPanel.add(timerValueLabel);

		BoardPanel.add(textPanel);
		textPanel.setLayout(new BorderLayout(0, 0));
		textPanel.add(scrollPane, BorderLayout.CENTER);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		scrollPane.setColumnHeaderView(lblBl);
		
		outerSubmitPanel.setBackground(new Color(245, 255, 250));

		getContentPane().add(outerSubmitPanel, "cell 2 2,grow");
		submitButton.setBounds(36, 16, 394, 49);
		outerSubmitPanel.setLayout(new BorderLayout(0, 0));
		innerSubmitPanel.setBackground(new Color(245, 255, 250));
		outerSubmitPanel.add(innerSubmitPanel);
		innerSubmitPanel.setLayout(null);
		submitButton.setBackground(new Color(0, 255, 0));
		submitButton.setForeground(Color.DARK_GRAY);
		submitButton.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 24));
		innerSubmitPanel.add(submitButton);
		submitButton.addActionListener(this);
		
		setSize(1600,1000);
		setVisible(true);
		
	}

	public void fitIconToButton(JButton button, ImageIcon icon) {
		Image img = icon.getImage();
		int offset = button.getInsets().left;
		int W = button.getWidth() - offset;
		int H = button.getHeight() - offset;
		Image resizedImage = img.getScaledInstance(W, H, java.awt.Image.SCALE_SMOOTH);
		button.setIcon(new ImageIcon(resizedImage));
	}
	
	public void setConsoleText(String text) {
		textArea.append("\n" + text);
		textArea.getCaret().setDot( Integer.MAX_VALUE );
	}
	
	public String getConsoleText() {
		return textArea.getText();
	}
	
	public Viewer getViewer() {
		return viewer;
	}

	public void setInstruction(String location) {
		promptLabel.setText("Tryck på: " + location);
	}

	public void setTimerText(String text) {
		timerValueLabel.setText(text);
		timerValueLabel.updateUI();
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
			playerOneScore = playerOneScore + score;
			scorelbl1.setText("" + playerOneScore);
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
			int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to\n        Exit goGeo?","EXIT",JOptionPane.YES_NO_OPTION);
	        if(confirmed == JOptionPane.YES_OPTION)
	        {
	        	System.exit(EXIT_ON_CLOSE);
	        }
		
		}

//		if(e.getSource() == menuButton) {
//			dispose();
//			new GUIMenu1(controller);
//		}

		if (e.getSource() == submitButton) {
			Guess guess = viewer.getGuess();
			guess.setTime(timerCount);
			guess.calculateScore();
			setConsoleText("You were " + guess.getKilometers() + " Kilometers away from ");
//			playerOneScore = playerOneScore +  guess.getScore();
//			scorelbl1.setText("" + playerOneScore);
			setPlayerScore(guess.getScore(), 1);
			controller.sendMessage(guess);
			submitButton.setEnabled(false);
		}

//		if (e.getSource() == resignButton) {
//			//TODO Resign from game
//		}

		if(e.getSource() == zoomOutBtn) {
			int z = viewer.getViewer().getZoom();
			viewer.getViewer().setZoom(z+1);

		}
		if(e.getSource() == zoomInBtn) {
			int z = viewer.getViewer().getZoom();
			viewer.getViewer().setZoom(z-1);
		}
		
		if(e.getSource() == infoBtn) {
			new GameInstructions();
		}


	}
	/**
	 * Starts the timer thats printed to the console in the gamewindow.
	 * 
	 */
	
	public void startConsoleTimer() {
		timerCount = 5;
        setConsoleText( "Round " + rounds + " will start in "  + timerCount + " seconds.");
        setConsoleText( "You will have 50 seconds each round, the timer is to the right!");
		viewer.setRoundAsUnfinished();
		Timer timer = new Timer();
		TimerTask myTask = new TimerTask() {
			
		    @Override
		    public void run() {
		    	if(rounds != 9) {
		    		if(timerCount <= -1 ) {
			        	timer.cancel();
			        	startGameTimer();
		    		}

		        } else {
		        	setConsoleText("You finished with a score of " + playerOneScore );
		        	setConsoleText("Your opponent finished with a score of" + playerTwoScore);
		        	if(playerOneScore > playerTwoScore) {
		        		setConsoleText("Congratulations, you won! Well done!");
		        		timer.cancel();
		        	}else {
		        		setConsoleText("You lost... Better luck next time! :)"); 
		        		timer.cancel();
		        	}
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
		submitButton.setEnabled(true);
		viewer.enableMarkers();
		viewer.setGameLocation();
		viewer.removePaint();
		promptLabel.setText(" Find: " + viewer.getCurrentStringLocation());
		setConsoleText("Find: " + viewer.getCurrentStringLocation());
		rounds++;
		timerCount = 50;
		Timer timer = new Timer();
		TimerTask myTask = new TimerTask() {
			
		    @Override
		    public void run() {
		        setTimerText("" + timerCount);
		        timerCount--;
		        if(timerCount == -1 ) {  //TODO skicka meddelande till servern att skicka den andras gissning om tiden tar slut!
		        	controller.requestOtherPlayersGuess();
		        	setConsoleText("You ran out of time, remember only 30 seconds per round!");
		        	timer.cancel();
		        	viewer.disableMarkers();
		        	startConsoleTimer();
		        }  
		        if(viewer.isRoundFinished() == true) {
		        	timer.cancel();
		        	viewer.disableMarkers();
		        	startConsoleTimer();
		        }
		    }
		};
		timer.schedule(myTask, 0, 1000);
	}


	public static void main(String[] args) {
		 new GameW(1);
//		f.setSize(1600,1000);
//		//f.setExtendedState(MAXIMIZED_BOTH);
//		f.setVisible(true);
	}
	
	
}