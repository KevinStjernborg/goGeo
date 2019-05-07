package Gui;
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

import javax.swing.JButton;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.DropMode;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener{

	
	private Controller controller;
	private String res;
	private Viewer viewer = new Viewer();

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
	private JLabel scorelbl2 = new JLabel("999,999,999");
	private JPanel submitPanel = new JPanel();
	private JButton submitButton = new JButton(""); 
	private JPanel zoomPanel = new JPanel();
	private JButton zoomUp = new JButton("");
	private JButton zoomDown = new JButton("");
	private JPanel resignPanel = new JPanel();
	private JButton resignButton = new JButton("");
	private JPanel infoPanel = new JPanel();
	private JButton infoButton = new JButton();

	public GameWindow() {
		initialize();
	}
	
	public GameWindow(Controller controller) {
		this.controller = controller;
		initialize();
	}

	public void initialize() {
		getContentPane().setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setVisible(true);
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

		infoButton.setBounds(444, 0, 54, 45);
		infoPanel.add(infoButton);
		fitIconToButton(infoButton, infoIcon);
		
		JButton menuButton = new JButton("Menu");
		menuButton.setBounds(0, 0, 415, 44);
		infoPanel.add(menuButton);
	
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
	public String getText() {
		return textPane.getText();
	}
	
	public void setTimerText(String text) {
		timerLabel.setText(text);
		timerLabel.updateUI();
	}
	
	public void setPromptText(String text) {
		promptLabel.setText(text);
		promptLabel.updateUI();
	}
	public void setPlayer1(String name) {
		player1lbl.setText(name);
		player1lbl.updateUI();
	}
	public void setPlayer2(String name) {
		player2lbl.setText(name);
		player2lbl.updateUI();
	}
	
	public void setScorePlayer1(int score) {
		String res = Integer.toString(score);
		scorelbl1.setText(res);
		scorelbl1.updateUI();
	}
	
	public void setScorePlayer2(int score) {
		String res = Integer.toString(score);
		scorelbl2.setText(res);
		scorelbl2.updateUI();
	}
	
//	@Override  TODO: Denna funkar ej, kolla hur det görs i listener för viewer.. 
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == zoomUp) {
//			viewer.getViewer().setZoom(18);
//		}
//		
//	}
//	
	
	
	public static void main(String[] args) {
		GameWindow gw = new GameWindow();
		gw.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		gw.setVisible(true);
		gw.setConsoleText("\n"+"\n");
		gw.setConsoleText("hej");
		gw.setConsoleText("\n"+"\n");
		gw.setConsoleText("hej");
		gw.setConsoleText("\n"+"\n");
		gw.setConsoleText("hej");
		gw.setConsoleText("\n"+"\n");
		gw.setConsoleText("hej");
		gw.setConsoleText("\n"+"\n");
		gw.setConsoleText("hej");
		gw.setConsoleText("\n"+"\n");
		gw.setConsoleText("hej");
		gw.setConsoleText("\n"+"\n");
		gw.setConsoleText("hej");
	}

	
}
