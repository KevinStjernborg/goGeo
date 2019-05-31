package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a menu window that opens when you run the program. In this
 * window there are three buttons. New Game that when pressed opens
 * {@link Menu2new}. Instruction button that when pressed opens
 * {@GameInstructions}. Exit button that exit the window.
 * 
 * @author Agnes Hägnestrand and Malin Hällström
 *
 */
public class Menu1 extends JPanel implements ActionListener {

	private JLabel jLabel;
	private JButton btnNyttSpel;
	private JButton btnInstruktioner;
	private JButton btnAvsluta;
	private JFrame frame;

	private Controller controller;

	public Menu1(Controller controller) {
		this.controller = controller;

		frame = new JFrame("goGeo");

		btnNyttSpel = new JButton("New Game");
		btnNyttSpel.setBackground(new Color(245, 245, 245));
		btnNyttSpel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnNyttSpel.setForeground(new Color(0, 128, 128));
		btnNyttSpel.setBounds(405, 170, 150, 60);
		btnNyttSpel.addActionListener(this);
		btnNyttSpel.setBorder(new LineBorder(new Color(0, 128, 128), 3));

		btnInstruktioner = new JButton("Instructions");
		btnInstruktioner.setBackground(new Color(245, 255, 250));
		btnInstruktioner.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnInstruktioner.setForeground(new Color(0, 128, 128));
		btnInstruktioner.setBounds(405, 270, 150, 60);
		btnInstruktioner.addActionListener(this);
		btnInstruktioner.setBorder(new LineBorder(new Color(0, 128, 128), 3));

		btnAvsluta = new JButton("Exit");
		btnAvsluta.setBackground(new Color(245, 255, 250));
		btnAvsluta.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnAvsluta.setForeground(new Color(0, 128, 128));
		btnAvsluta.setBounds(405, 370, 150, 60);
		btnAvsluta.addActionListener(this);
		btnAvsluta.setBorder(new LineBorder(new Color(0, 128, 128), 3));
		setLayout(new BorderLayout(0, 0));

		jLabel = new JLabel();
		jLabel.setIcon(new ImageIcon("images/worldmap.png"));
		jLabel.setBounds(0, 0, getWidth(), getHeight());
		jLabel.add(btnNyttSpel);
		jLabel.add(btnInstruktioner);
		jLabel.add(btnAvsluta);
		this.add(jLabel);

		frame.getContentPane().add(this, BorderLayout.CENTER);
		frame.setSize(900, 650);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNyttSpel) {
			new Menu2(controller);
			frame.setVisible(false);
		}

		if (e.getSource() == btnInstruktioner) {
			new GameInstructions();

		}
		if (e.getSource() == btnAvsluta) {
			frame.dispose();

		}

	}

}
