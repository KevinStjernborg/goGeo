package Gui;

import java.awt.*;
import javax.swing.*;

import client.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMenu2 extends JPanel {

	private ImageIcon image;
	private JLabel jLabel;

	public GUIMenu2() {
		image = new ImageIcon("images/wm.png");
		setLayout(null);

		JFrame frame = new JFrame("Meny");

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this, BorderLayout.CENTER); // JPanel på JFrame
		
		JButton btnEuropa = new JButton("Europa");
		btnEuropa.addActionListener(e -> {
			System.out.println("btnEuropa was pressed");
		});
		btnEuropa.setBackground(new Color(0, 153, 255));
		btnEuropa.setForeground(SystemColor.controlHighlight);
		btnEuropa.setBounds(395, 120, 170, 59);
//		if(btnEuropa == 
//				btnEuropa.setFocusPainted(false);
		add(btnEuropa);

		JButton btnAfrika = new JButton("Afrika");
		btnAfrika.addActionListener(e -> {
			System.out.println("btnAfrika was pressed");
		});
		btnAfrika.setForeground(SystemColor.controlHighlight);
		btnAfrika.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnAfrika.setBackground(new Color(0, 153, 255));
		btnAfrika.setBounds(395, 212, 170, 59);
		add(btnAfrika);


		JButton btnNordamerika = new JButton("Nordamerika");
		btnNordamerika.addActionListener(e -> {
			System.out.println("btnNordamerika was pressed");
		});
		btnNordamerika.setBackground(new Color(0, 153, 255));
		btnNordamerika.setForeground(SystemColor.controlHighlight);
		btnNordamerika.setBounds(395, 304, 170, 59);
		add(btnNordamerika);

		JButton btnSydamerika = new JButton("Sydamerika");
		btnSydamerika.addActionListener(e -> {
			System.out.println("btnSydamerika was pressed");
		});
		btnSydamerika.setBackground(new Color(0, 153, 255));
		btnSydamerika.setForeground(SystemColor.controlHighlight);
		btnSydamerika.setBounds(395, 396, 170, 59);
		add(btnSydamerika);

		jLabel = new JLabel();
		jLabel.setBounds(-118, 5, 1236, 628);

		jLabel.setIcon(new ImageIcon("/Users/malinhallstrom/Desktop/wm.png"));
		this.add(jLabel);
		jLabel.setLabelFor(btnAfrika);

		frame.setSize(900, 630);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		new GUIMenu2();
	}
}