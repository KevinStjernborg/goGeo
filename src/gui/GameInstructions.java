package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * A class that shows the instructions in the game in a new window.
 * 
 * @author Malin Hällström
 *
 */
public class GameInstructions extends JPanel {

	private JButton btnBack;
	private JLabel jLabel;
	private JFrame frame;

	public GameInstructions() {

		frame = new JFrame();

		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(245, 245, 245));
		btnBack.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnBack.setForeground(new Color(0, 128, 128));
		btnBack.setBounds(30, 30, 100, 50);
		btnBack.setBorder(new LineBorder(new Color(0, 128, 128), 3));
		btnBack.addActionListener(e -> {
			frame.setVisible(false);
		});
		setLayout(new BorderLayout(0, 0));

		jLabel = new JLabel();
		Image img = new ImageIcon("images/i.png").getImage();
		Image scale = img.getScaledInstance(900, 650, 0);
		ImageIcon im = new ImageIcon(scale);
		jLabel.setIcon(im);
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