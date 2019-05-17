package gui;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Menu1new extends JPanel implements ActionListener {

	private JLabel jLabel;
	private JButton btnNyttSpel;
	private JButton btnInstruktioner;
	private JButton btnAvsluta;
	private JFrame frame;

	public Menu1new() {

		frame = new JFrame();

		btnNyttSpel = new JButton("New Game");
		btnNyttSpel.setBackground(new Color(0, 153, 255));
		btnNyttSpel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnNyttSpel.setForeground(SystemColor.controlHighlight);
		btnNyttSpel.setBounds(405, 170, 150, 60);
		btnNyttSpel.addActionListener(this);

		btnInstruktioner = new JButton("Instructions");
		btnInstruktioner.setBackground(new Color(0, 153, 255));
		btnInstruktioner.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnInstruktioner.setForeground(SystemColor.controlHighlight);
		btnInstruktioner.setBounds(405, 270, 150, 60);
		btnInstruktioner.addActionListener(this);

		btnAvsluta = new JButton("Exit");
		btnAvsluta.setBackground(new Color(0, 153, 255));
		btnAvsluta.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnAvsluta.setForeground(SystemColor.controlHighlight);
		btnAvsluta.setBounds(405, 370, 150, 60);
		btnAvsluta.addActionListener(this);

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
			new GUIMenu2();
			frame.setVisible(false);
		}

		if (e.getSource() == btnInstruktioner) {
			new GameInstructions();
	

		}
		if (e.getSource() == btnAvsluta) {
			frame.setVisible(false);

		}

	}

	public static void main(String[] args) {

		new Menu1new();

	}
}
