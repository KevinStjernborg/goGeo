package gui;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu2new extends JPanel implements ActionListener {

	private JLabel jLabel;
	private JButton btnSingle;
	private JButton btnMulti;
	private JButton btnBack;
	private JFrame frame;
	private Controller controller;

	public Menu2new(Controller controller) {
		this.controller = controller;

		frame = new JFrame();

		btnSingle = new JButton("Singleplayer");
		btnSingle.setBackground(new Color(245, 245, 245));
		btnSingle.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnSingle.setForeground(new Color(0, 128, 128));
		btnSingle.setBounds(405, 170, 150, 60);
		btnSingle.addActionListener(this);
		btnSingle.setBorder(new LineBorder(new Color(0,128,128),3));
		btnSingle.setToolTipText("Not avalable at this moment");
		btnSingle.setEnabled(false);

		btnMulti = new JButton("Multiplayer");
		btnMulti.setBackground(new Color(245, 245, 245));
		btnMulti.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnMulti.setForeground(new Color(0, 128, 128));
		btnMulti.setBounds(405, 270, 150, 60);
		btnMulti.addActionListener(this);
		btnMulti.setBorder(new LineBorder(new Color(0,128,128),3));
		
		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(245, 245, 245));
		btnBack.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnBack.setForeground(new Color(0, 128, 128));
		btnBack.setBounds(30, 30, 100, 50);
		btnBack.addActionListener(this);
		setLayout(new BorderLayout(0, 0));
		btnBack.setBorder(new LineBorder(new Color(0, 128, 128),3));

		jLabel = new JLabel();
		jLabel.setForeground(new Color(0, 128, 128));
		jLabel.setIcon(new ImageIcon("images/worldmap.png"));
		jLabel.setBounds(0, 0, getWidth(), getHeight());
		jLabel.add(btnSingle);
		jLabel.add(btnMulti);
		jLabel.add(btnBack);
		this.add(jLabel);
		

		frame.getContentPane().add(this, BorderLayout.CENTER); 
		frame.setSize(900, 650);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
	
	public void dispose() {
		frame.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSingle) {
//			frame.setVisible(false);
		}

		if (e.getSource() == btnMulti) {
			controller.startMultiplayerGame();
			dispose();
	}
		if (e.getSource() == btnBack) {
			new Menu1new(controller);
			frame.setVisible(false);

	}

}
}