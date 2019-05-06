package Gui;

import java.awt.*;
import javax.swing.*;

import client.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMenu1 extends JPanel {

	private ImageIcon image;
	private JLabel jLabel;

	public GUIMenu1() {
		image = new ImageIcon("images/wm.png");
		setLayout(null);

		JFrame frame = new JFrame("Meny");

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this, BorderLayout.CENTER); // JPanel på JFrame

		JButton btnNyttSpel = new JButton("Nytt spel");
		btnNyttSpel.addActionListener(e -> {
			
			// kod som ska hända om trycker på knappen
		});

		btnNyttSpel.setBackground(new Color(0, 153, 255));
		btnNyttSpel.setForeground(SystemColor.controlHighlight);
		btnNyttSpel.setBounds(395, 152, 170, 59);
		add(btnNyttSpel);

		JButton btnInstruktioner = new JButton("Instruktioner");
		btnInstruktioner.addActionListener(e -> {
			// kod som ska hända om trycker på knappen
		});
		btnInstruktioner.setBackground(new Color(0, 153, 255));
		btnInstruktioner.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnInstruktioner.setForeground(SystemColor.controlHighlight);
		btnInstruktioner.setBounds(395, 250, 170, 59);
		add(btnInstruktioner);

		JButton btnAvsluta = new JButton("Avsluta");
		btnAvsluta.addActionListener(e -> {
			// kod som ska hända om trycker på knappen
		});
		btnAvsluta.setBackground(new Color(0, 153, 255));
		btnAvsluta.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnAvsluta.setForeground(SystemColor.controlHighlight);
		btnAvsluta.setBounds(395, 349, 170, 59);
		add(btnAvsluta);

		jLabel = new JLabel();
		jLabel.setBounds(-118, 5, 1236, 628);

		jLabel.setIcon(new ImageIcon("/Users/malinhallstrom/Desktop/wm.png"));
		this.add(jLabel);

		frame.setSize(900, 630);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		new GUIMenu1();
	}
}
