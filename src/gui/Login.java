package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Login extends JPanel implements ActionListener {

	JFrame frame;
	private JTextField textField;
	private JButton btnLoggaIn;

	public Login() {

		setBackground(new Color(51, 102, 204));
		setForeground(new Color(51, 102, 255));
		setLayout(null);
		frame = new JFrame("Login");
		frame.setBackground(new Color(51, 102, 255));

		frame.getContentPane().add(this, BorderLayout.CENTER); // JPanel på JFrame

		JRadioButton rdbtnRed = new JRadioButton("Röd");
		rdbtnRed.setForeground(new Color(255, 0, 0));
		rdbtnRed.setBounds(6, 188, 141, 23);
		add(rdbtnRed);

		textField = new JTextField();
		textField.setBounds(80, 47, 196, 46);
		add(textField);
		textField.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Blå");
		rdbtnNewRadioButton.setForeground(new Color(51, 0, 255));
		rdbtnNewRadioButton.setBounds(6, 165, 141, 23);
		add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Grön");
		rdbtnNewRadioButton_1.setForeground(new Color(0, 255, 51));
		rdbtnNewRadioButton_1.setBounds(6, 141, 141, 23);
		add(rdbtnNewRadioButton_1);

		JLabel lblMf = new JLabel("Användarnamn:");
		lblMf.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblMf.setBounds(116, 6, 124, 39);
		add(lblMf);

		JLabel lblFrgPPig = new JLabel("Färg på pig:");
		lblFrgPPig.setBounds(13, 105, 82, 16);
		add(lblFrgPPig);

		JRadioButton rdbtnGul = new JRadioButton("Gul");
		rdbtnGul.setForeground(new Color(204, 255, 0));
		rdbtnGul.setBounds(6, 119, 141, 23);
		add(rdbtnGul);

		btnLoggaIn = new JButton("Logga in");
		btnLoggaIn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnLoggaIn.setBounds(116, 116, 124, 37);
		btnLoggaIn.addActionListener(this);
		add(btnLoggaIn);

		frame.setSize(350, 250);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLoggaIn) {
			new GUIMenu1();
			frame.setVisible(false);
		}
	}

		public static void main(String[] args) {
			new Login();
		}

}
