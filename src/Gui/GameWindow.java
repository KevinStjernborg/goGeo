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
import javax.swing.JTextPane;
import client.Viewer;

import javax.swing.JButton;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.DropMode;

public class GameWindow extends JFrame {


	private String res;
	private Viewer viewer = new Viewer();

	//Bör skapa en dir med alla resources för att inte hårdkoda. 

	private ImageIcon infoIcon = new ImageIcon("C:\\Users\\Said\\git\\goGeo\\src\\Gui\\icon.png");
	private ImageIcon arrowUpIcon = new ImageIcon("C:\\Users\\Said\\git\\goGeo\\src\\Gui\\arrow-971322_960_720.png");
	private ImageIcon arrowDownIcon = new ImageIcon("C:\\Users\\Said\\git\\goGeo\\src\\Gui\\arrowDowntest.png");
	private ImageIcon resignImage = new ImageIcon("C:\\Users\\Said\\Desktop\\resign.png");

	private JPanel mapPanel = new JPanel();
	//private JTextPane textPane = new JTextPane();

	private JTextArea textPane = new JTextArea();
	private JScrollPane PanelTextConsole = new JScrollPane(textPane);
	private JPanel panel = new JPanel();
	private JPanel promptPanel = new JPanel();
	private JLabel lblNewLabel = new JLabel("InstructionPrompt");
	private JPanel boardPanel = new JPanel();
	private JLabel scoreHeader = new JLabel("SCORE");
	private JLabel player1lbl = new JLabel("Player 1");
	private JLabel player2lbl = new JLabel("Player 2");
	private JLabel timerLabel = new JLabel("5");
	private JSeparator separator = new JSeparator();
	private JLabel scorelbl1 = new JLabel("New label");
	private JLabel scorelbl2 = new JLabel("New label");
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
		
		
		textPane.setRows(10);
		textPane.setLineWrap(true);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textPane.setForeground(Color.WHITE);
		textPane.setBackground(Color.BLACK);
		textPane.setText("HÄRHRÄ");
		PanelTextConsole.add(textPane);
		promptPanel.setBounds(98, 16, 1060, 44);
		
		PanelTextConsole.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		PanelTextConsole.setViewportView(textPane);

		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		promptPanel.add(lblNewLabel);

		boardPanel.setBackground(Color.WHITE);
		boardPanel.setBounds(1398, 76, 498, 743);
		getContentPane().add(boardPanel);
		boardPanel.setLayout(null);

		scoreHeader.setHorizontalAlignment(SwingConstants.CENTER);
		scoreHeader.setFont(new Font("Tahoma", Font.BOLD, 17));
		scoreHeader.setBounds(195, 16, 88, 38);
		boardPanel.add(scoreHeader);

		player1lbl.setBounds(15, 81, 137, 38);
		boardPanel.add(player1lbl);

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

		scorelbl1.setBounds(346, 81, 137, 38);
		boardPanel.add(scorelbl1);

		scorelbl2.setBounds(346, 152, 137, 38);
		boardPanel.add(scorelbl2);

		submitPanel.setBounds(788, 835, 370, 135);
		getContentPane().add(submitPanel);
		submitPanel.setLayout(null);

		submitButton.setIcon(new ImageIcon("C:\\Users\\Said\\Desktop\\Backgroundtestsa.png"));
		submitButton.setForeground(Color.GREEN);
		submitButton.setBackground(Color.GREEN);
		submitButton.setBounds(15, 16, 342, 103);
		submitPanel.add(submitButton);

		zoomPanel.setBounds(1260, 76, 123, 743);
		getContentPane().add(zoomPanel);
		zoomPanel.setLayout(null);

		zoomUp.setBounds(15, 102, 45, 115);
		zoomPanel.add(zoomUp);
		fitIconToButton(zoomUp, arrowUpIcon);

		zoomDown.setBounds(15, 404, 45, 115);
		zoomPanel.add(zoomDown);
		fitIconToButton(zoomDown, arrowDownIcon);

		resignPanel.setBounds(1398, 835, 498, 137);
		getContentPane().add(resignPanel);
		resignPanel.setLayout(null);

		resignButton.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 27));
		resignButton.setBounds(15, 16, 468, 103);
		resignPanel.add(resignButton);
		fitIconToButton(resignButton, resignImage);

		infoPanel.setBounds(1398, 16, 498, 44);
		getContentPane().add(infoPanel);
		infoPanel.setLayout(null);

		infoButton.setBounds(444, 0, 54, 45);
		infoPanel.add(infoButton);
		fitIconToButton(infoButton, infoIcon);
	
	}

	private Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();  
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
		return new ImageIcon(resizedImage);
	}

	public void fitIconToButton(JButton button, ImageIcon icon) {
		int offset = button.getInsets().left;
		button.setIcon(resizeIcon(icon, button.getWidth() - offset, button.getHeight() - offset));
	}

	public void setText(String text) {
		textPane.setText(textPane.getText() + "\n" + text);
		//textPane.append("\n" + text);
	}
	public String getText() {
		return textPane.getText();
	}

	public static void main(String[] args) {
		GameWindow gw = new GameWindow();
		gw.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		gw.setVisible(true);
		gw.setText("\n"+"\n");
		gw.setText("hej");
	}

}
