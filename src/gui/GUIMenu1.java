package gui;

import java.awt.*;
import javax.swing.*;

import client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class GUIMenu1 extends JPanel implements ActionListener {

	private ImageIcon image;
	private JLabel jLabel;
	JButton btnNyttSpel;
	JButton btnInstruktioner;
	JButton btnAvsluta;
	JFrame frame;
	private Controller controller;

	public GUIMenu1(Controller controller) {
		this.controller = controller;
		image = new ImageIcon("images/wm.png");
		setLayout(null);

		frame = new JFrame("Meny");

		btnNyttSpel = new JButton("Nytt spel");
		btnNyttSpel.setBackground(new Color(0, 153, 255));
		btnNyttSpel.setForeground(SystemColor.controlHighlight);
		btnNyttSpel.setBounds(395, 150, 170, 59);
		this.add(btnNyttSpel);
		btnNyttSpel.addActionListener(this);

		btnInstruktioner = new JButton("Instruktioner");
		btnInstruktioner.setBackground(new Color(0, 153, 255));
		btnInstruktioner.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnInstruktioner.setForeground(SystemColor.controlHighlight);
		btnInstruktioner.setBounds(395, 250, 170, 59);
		btnInstruktioner.addActionListener(this);
		add(btnInstruktioner);

		btnAvsluta = new JButton("Avsluta");
		btnAvsluta.setBackground(new Color(0, 153, 255));
		btnAvsluta.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnAvsluta.setForeground(SystemColor.controlHighlight);
		btnAvsluta.setBounds(395, 349, 170, 59);
		btnAvsluta.addActionListener(this);
		add(btnAvsluta);

		jLabel = new JLabel();
		jLabel.setBounds(-118, 5, 1236, 628);

		jLabel.setIcon(new ImageIcon("images/wm.png"));
		this.add(jLabel);

		frame.getContentPane().add(this, BorderLayout.CENTER); // JPanel på JFrame
		frame.setSize(900, 630);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNyttSpel) {
			controller.startGameModeMenu();
			this.frame.dispose();
		}

		if (e.getSource() == btnInstruktioner) {
			frame.setVisible(false);

		}
		if (e.getSource() == btnAvsluta) {
			frame.setVisible(false);

		}

	}


}