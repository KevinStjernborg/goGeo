package Gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import client.Viewer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class GameWindow extends JFrame {
	
	private String res;
	private Viewer viewer = new Viewer();


	public GameWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setVisible(true);
		getContentPane().setLayout(null);


		JPanel mapPanel = new JPanel();
		mapPanel.setBounds(15, 76, 1230, 743);

		getContentPane().add(mapPanel,BorderLayout.CENTER);
		mapPanel.add(viewer.getViewer());
		mapPanel.setLayout(new BorderLayout(0, 0));

		JPanel PanelTextConsole = new JPanel();
		PanelTextConsole.setBounds(15, 835, 758, 135);
		getContentPane().add(PanelTextConsole);
		PanelTextConsole.setLayout(null);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(0, 0, 758, 135);
		PanelTextConsole.add(textPane);
		textPane.setForeground(Color.WHITE);
		textPane.setBackground(Color.BLACK);
		textPane.setText("HÄRHRÄ");
		textPane.setEditable(false);

		JPanel promptPanel = new JPanel();
		promptPanel.setBounds(98, 16, 781, 44);
		getContentPane().add(promptPanel);

		JLabel lblNewLabel = new JLabel("InstructionPrompt");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		promptPanel.add(lblNewLabel);

		JPanel boardPanel = new JPanel();
		boardPanel.setBackground(Color.WHITE);
		boardPanel.setBounds(1398, 76, 498, 743);
		getContentPane().add(boardPanel);
		boardPanel.setLayout(null);

		JLabel scoreHeader = new JLabel("SCORE");
		scoreHeader.setHorizontalAlignment(SwingConstants.CENTER);
		scoreHeader.setFont(new Font("Tahoma", Font.BOLD, 17));
		scoreHeader.setBounds(195, 16, 88, 38);
		boardPanel.add(scoreHeader);

		JLabel player1lbl = new JLabel("Player 1");
		player1lbl.setBounds(15, 81, 137, 38);
		boardPanel.add(player1lbl);

		JLabel player2lbl = new JLabel("Player 2");
		player2lbl.setBounds(15, 152, 137, 38);
		boardPanel.add(player2lbl);

		JLabel timerLabel = new JLabel("5");
		timerLabel.setFont(new Font("Tahoma", Font.BOLD, 99));
		timerLabel.setForeground(Color.BLACK);
		timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timerLabel.setBounds(15, 316, 468, 411);
		boardPanel.add(timerLabel);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(0, 316, 498, 2);
		boardPanel.add(separator);

		JPanel panel = new JPanel();
		panel.setBounds(788, 835, 370, 135);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton submitButton = new JButton("");
		submitButton.setIcon(new ImageIcon("C:\\Users\\Said\\Desktop\\Backgroundtestsa.png"));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		submitButton.setForeground(Color.GREEN);
		submitButton.setBackground(Color.GREEN);
		submitButton.setBounds(15, 16, 342, 103);
		panel.add(submitButton);

		JPanel zoomPanel = new JPanel();
		zoomPanel.setBounds(1260, 76, 123, 743);
		getContentPane().add(zoomPanel);
		zoomPanel.setLayout(null);

		JButton zoomUp = new JButton("New button");
		zoomUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		zoomUp.setIcon(null);
		zoomUp.setBounds(15, 102, 45, 115);
		zoomPanel.add(zoomUp);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(15, 404, 45, 115);
		zoomPanel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1398, 835, 498, 135);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton infoButton = new JButton("New button");
		infoButton.setBounds(408, 16, 65, 55);
		panel_1.add(infoButton);

	}

	public static void main(String[] args) {
		GameWindow gw = new GameWindow();
		gw.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		gw.setVisible(true);
	}
}

