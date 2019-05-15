package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import client.Viewer;

import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;


public class testtest extends JFrame {

	private JPanel contentPane;
	private Viewer viewer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testtest frame = new testtest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testtest() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		viewer = new Viewer(1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 674);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel viewerPanel = new JPanel();
		viewerPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		viewerPanel.setBounds(10, 34, 651, 490);
		viewerPanel.add(viewer.getViewer());
		
		contentPane.add(viewerPanel);
		viewerPanel.setLayout(new CardLayout(0, 0));
		
		JPanel eastPanel = new JPanel();
		eastPanel.setBounds(672, 0, 118, 520);
		contentPane.add(eastPanel);
		eastPanel.setLayout(null);
		
		JButton btnEndTurn = new JButton("End turn");
		btnEndTurn.setBounds(10, 39, 89, 23);
		eastPanel.add(btnEndTurn);
		
		JButton btnResign = new JButton("Resign");
		btnResign.setBounds(10, 475, 89, 23);
		eastPanel.add(btnResign);
		
		JButton btnInstructions = new JButton("Help");
		btnInstructions.setVerticalAlignment(SwingConstants.TOP);
		btnInstructions.setBounds(10, 441, 89, 23);
		eastPanel.add(btnInstructions);
		
		JPanel southPanel = new JPanel();
		southPanel.setBounds(10, 531, 780, 80);
		contentPane.add(southPanel);
		southPanel.setLayout(null);
		
		JLabel lblYourScore = new JLabel("Your score");
		lblYourScore.setBounds(10, 11, 83, 14);
		southPanel.add(lblYourScore);
		
		JLabel label = new JLabel("0");
		label.setBounds(10, 36, 46, 14);
		southPanel.add(label);
		
		JLabel lblOpponentsScore = new JLabel("Opponents score");
		lblOpponentsScore.setBounds(118, 11, 111, 14);
		southPanel.add(lblOpponentsScore);
		
		JLabel label_1 = new JLabel("0");
		label_1.setBounds(118, 36, 46, 14);
		southPanel.add(label_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(336, 29, 418, 46);
		southPanel.add(textArea);
		
		JLabel lblGamelog = new JLabel("Gamelog");
		lblGamelog.setBounds(518, 11, 73, 14);
		southPanel.add(lblGamelog);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 0, 651, 23);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblTryToFind = new JLabel("Try to find: ");
		lblTryToFind.setBounds(10, 0, 84, 23);
		panel_3.add(lblTryToFind);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(89, 4, 46, 14);
		panel_3.add(label_2);
	}
}
