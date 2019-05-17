package gui;

	import java.awt.*;
	import javax.swing.*;

	public class GameInstructions extends JPanel {

		private JButton btnBack;
		private JLabel jLabel;
		private JFrame frame;

		public GameInstructions() {

			frame = new JFrame();
			
			btnBack = new JButton("Back");
			btnBack.setBackground(new Color(0, 153, 255));
			btnBack.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			btnBack.setForeground(SystemColor.controlHighlight);
			btnBack.setBounds(30, 30, 100, 50);
			btnBack.addActionListener(e -> { 
			frame.setVisible(false);
			});


			jLabel = new JLabel();
			jLabel.setIcon(new ImageIcon("images/i.png"));
			jLabel.setBounds(0, 0, getWidth(), getHeight());
			jLabel.add(btnBack);
			this.add(jLabel);
			

			frame.getContentPane().add(this, BorderLayout.CENTER); 
			frame.setSize(900, 650);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setUndecorated(true);
			frame.setVisible(true);

		}


	}

