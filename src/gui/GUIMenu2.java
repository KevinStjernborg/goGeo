package gui;

import java.awt.*;
import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMenu2 extends JPanel {

	private ImageIcon image;
	private JLabel jLabel;

	public GUIMenu2() {
		image = new ImageIcon("images/wm.png");
		setLayout(null);

		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this, BorderLayout.CENTER); // JPanel på JFrame

		JButton btnEuropa = new JButton("Tyskland");
		btnEuropa.addActionListener(e -> {
			GameWindowSP gameWindow = new GameWindowSP(3);
		});
		btnEuropa.setBackground(new Color(0, 153, 255));
		btnEuropa.setForeground(SystemColor.controlHighlight);
		btnEuropa.setBounds(395, 120, 170, 59);
		add(btnEuropa);

		JButton btnAfrika = new JButton("Storbritannien");
		btnAfrika.addActionListener(e -> {
			GameWindowSP gameWindow = new GameWindowSP(2);
		});
		btnAfrika.setForeground(SystemColor.controlHighlight);
		btnAfrika.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnAfrika.setBackground(new Color(0, 153, 255));
		btnAfrika.setBounds(395, 212, 170, 59);
		add(btnAfrika);

		JButton btnNordamerika = new JButton("Frankrike");
		btnNordamerika.addActionListener(e -> {
			GameWindowSP gameWindow = new GameWindowSP(1);
		});
		btnNordamerika.setBackground(new Color(0, 153, 255));
		btnNordamerika.setForeground(SystemColor.controlHighlight);
		btnNordamerika.setBounds(395, 304, 170, 59);
		add(btnNordamerika);

//		JButton btnSydamerika = new JButton("Sydamerika"); // inget fjärde alternativ just nu //Kevin
//		btnSydamerika.addActionListener(e -> {
//			System.out.println("btnSydamerika was pressed");
//		});
//		btnSydamerika.setBackground(new Color(0, 153, 255));
//		btnSydamerika.setForeground(SystemColor.controlHighlight);
//		btnSydamerika.setBounds(395, 396, 170, 59);
//		add(btnSydamerika);

		jLabel = new JLabel();
		jLabel.setBounds(-118, 5, 1236, 628);

		jLabel.setIcon(new ImageIcon("images/wm.png"));
		this.add(jLabel);
		jLabel.setLabelFor(btnAfrika);

		frame.setSize(900, 630);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}