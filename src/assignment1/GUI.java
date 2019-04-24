package assignment1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

import javax.swing.*;
import javax.swing.border.*;

/**
 * A class that acts as an interface for the user and via {@link Controller} handles the input.
 */
public class GUI {
	/**
	 * These are the components you need to handle. You have to add listeners and/or
	 * code
	 */
	private JFrame frame; // The Main window
	private JButton btnDisplay; // Start thread moving display
	private JButton btnDStop; // Stop moving display thread
	private JButton btnTriangle;// Start moving graphics thread
	private JButton btnTStop; // Stop moving graphics thread
	private JButton btnOpen; // Open audio file
	private JButton btnPlay; // Start playing audio
	private JButton btnStop; // Stop playing
	private JButton btnGo; // Start game catch me
	private JPanel pnlMove; // The panel to move display in
	private JPanel pnlRotate; // The panel to move graphics in
	private JPanel pnlGame; // The panel to play in
	private JLabel lblPlaying; // Playing text
	private JLabel lblAudio; // Audio file
	private JLabel lblAudioLoaded;
	private JLabel lbl1; // loaded audio lbl
	private JTextArea txtHits; // Display hits
	private JComboBox cmbSkill; // Skill combo box, needs to be filled in
	private Controller controller; // A controller object which acts as a facade for the musicRunnable and textRunnable objects

	/**
	 * Constructor
	 */
	public GUI() {
	}

	/**
	 * Starts the application
	 */
	public void Start() {
		frame = new JFrame();
		frame.setBounds(0, 0, 819, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle("Multiple Thread Demonstrator");
		InitializeGUI(); // Fill in components
		frame.setVisible(true);
		frame.setResizable(false); // Prevent user from change size
		frame.setLocationRelativeTo(null); // Start middle screen
	}

	/**
	 * Sets up the GUI with components
	 */
	
	public void setController(Controller cont) {
		this.controller = cont;
	}
	private void InitializeGUI() {
		// The music player outer panel
		JPanel pnlSound = new JPanel();
		Border b1 = BorderFactory.createTitledBorder("Music Player");
		pnlSound.setBorder(b1);
		pnlSound.setBounds(12, 12, 450, 100);
		pnlSound.setLayout(null);

		// Add labels and buttons to this panel
		lblPlaying = new JLabel("Pick an audio file to be played"); 
		lblPlaying.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPlaying.setBounds(128, 16, 300, 20);
		pnlSound.add(lblPlaying);
		lblAudioLoaded = new JLabel("No audio loaded"); 
		lblAudioLoaded.setBounds(10, 44, 130, 13);
		pnlSound.add(lblAudioLoaded);
		lblAudio = new JLabel("..."); 
		lblAudio.setBounds(115, 44, 300, 13);
		pnlSound.add(lblAudio);
		btnOpen = new JButton("Open");
		btnOpen.setBounds(6, 71, 75, 23);
		pnlSound.add(btnOpen);
		btnPlay = new JButton("Play");
		btnPlay.setBounds(88, 71, 75, 23);
		btnPlay.setEnabled(false);
		pnlSound.add(btnPlay);
		btnStop = new JButton("Stop");
		btnStop.setBounds(169, 71, 75, 23);
		btnStop.setEnabled(false);
		pnlSound.add(btnStop);
		frame.add(pnlSound);

		// The moving display outer panel
		JPanel pnlDisplay = new JPanel();
		Border b2 = BorderFactory.createTitledBorder("Display Thread");
		pnlDisplay.setBorder(b2);
		pnlDisplay.setBounds(12, 118, 222, 269);
	
		pnlDisplay.setLayout(null);

		// Add buttons and drawing panel to this panel
		btnDisplay = new JButton("Start Display");
		btnDisplay.setBounds(10, 226, 121, 23);
		pnlDisplay.add(btnDisplay);
		pnlDisplay.add(controller.getText());  // Adds the textRunnable to the panel
		btnDStop = new JButton("Stop");
		btnDStop.setEnabled(false);  //Disables the stop button until text is showing
		btnDStop.setBounds(135, 226, 75, 23);
		pnlDisplay.add(btnDStop);
		pnlMove = new JPanel();
		pnlMove.setBounds(10, 19, 200, 200);
		Border b21 = BorderFactory.createLineBorder(Color.black);
		pnlMove.setBorder(b21);
		pnlDisplay.add(pnlMove);
		frame.add(pnlDisplay);

		// The moving graphics outer panel
		JPanel pnlTriangle = new JPanel();
		Border b3 = BorderFactory.createTitledBorder("Triangle Thread");
		pnlTriangle.setBorder(b3);
		pnlTriangle.setBounds(240, 118, 222, 269);
		pnlTriangle.setLayout(null);

		// Add buttons and drawing panel to this panel
		btnTriangle = new JButton("Start Rotate");
		btnTriangle.setBounds(10, 226, 121, 23);
		pnlTriangle.add(btnTriangle);
		btnTStop = new JButton("Stop");
		btnTStop.setBounds(135, 226, 75, 23);
		pnlTriangle.add(btnTStop);
		pnlRotate = new JPanel();
		pnlRotate.setBounds(10, 19, 200, 200);
		Border b31 = BorderFactory.createLineBorder(Color.black);
		pnlRotate.setBorder(b31);
		pnlTriangle.add(pnlRotate);
		// Add this to main window
		frame.add(pnlTriangle);

		// The game outer panel
		JPanel pnlCatchme = new JPanel();
		Border b4 = BorderFactory.createTitledBorder("Catch Me");
		pnlCatchme.setBorder(b4);
		pnlCatchme.setBounds(468, 12, 323, 375);
		pnlCatchme.setLayout(null);

		// Add controls to this panel
		JLabel lblSkill = new JLabel("Skill:");
		lblSkill.setBounds(26, 20, 50, 13);
		pnlCatchme.add(lblSkill);
		JLabel lblInfo = new JLabel("Hit Image with Mouse");
		lblInfo.setBounds(107, 13, 150, 13);
		pnlCatchme.add(lblInfo);
		JLabel lblHits = new JLabel("Hits:");
		lblHits.setBounds(240, 20, 50, 13);
		pnlCatchme.add(lblHits);
		cmbSkill = new JComboBox(); // hejehejehjej
		cmbSkill.setBounds(19, 41, 61, 23);
		pnlCatchme.add(cmbSkill);
		btnGo = new JButton("GO");
		btnGo.setBounds(129, 41, 75, 23);
		pnlCatchme.add(btnGo);
		txtHits = new JTextArea(); // Needs to be updated
		txtHits.setBounds(233, 41, 71, 23);
		Border b40 = BorderFactory.createLineBorder(Color.black);
		txtHits.setBorder(b40);
		pnlCatchme.add(txtHits);
		pnlGame = new JPanel();
		pnlGame.setBounds(19, 71, 285, 283);
		Border b41 = BorderFactory.createLineBorder(Color.black);
		pnlGame.setBorder(b41);
		pnlCatchme.add(pnlGame);
		frame.add(pnlCatchme);
		addListeners();
	}

	/**
	 * A method for adding the listener to the buttons
	 * 
	 */
	public void addListeners() {
		ButtonListener listener = new ButtonListener();
		btnDisplay.addActionListener(listener);
		btnDStop.addActionListener(listener); // Stop moving display thread
		btnTriangle.addActionListener(listener);// Start moving graphics thread
		btnTStop.addActionListener(listener); // Stop moving graphics thread
		btnOpen.addActionListener(listener); // Open audio file
		btnPlay.addActionListener(listener); // Start playing audio
		btnStop.addActionListener(listener);// Stop playing
		btnGo.addActionListener(listener);
	}
/**
 * 
 *  A private class which implements {@link ActionListener} and listens for input from the user.
 *  
 * @author Kevin Stjernborg
 *
 */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			/*
			 * Starts random text and disables the button to start it again.
			 * Enables the stop button.
			 */
			if (e.getSource() == btnDisplay) {
				controller.startText();
				btnDisplay.setEnabled(false);
				btnDStop.setEnabled(true);
			}
			/*
			 * Stops random text and disables the button to stop it again.
			 * Enables the start button.
			 */
			if (e.getSource() == btnDStop) {
				controller.getText().stop();
				btnDisplay.setEnabled(true);
				btnDStop.setEnabled(false);
			}
			if (e.getSource() == btnTriangle) {
			}
			if (e.getSource() == btnTStop) {
				
			}
			
			/*
			 * Creates a JFileChooser and sends the chosen file to the controller.
			 * 
			 */
			if (e.getSource() == btnOpen) {
				JFileChooser j = new JFileChooser();
				j.setCurrentDirectory(new java.io.File("C:\\Users\\kstje\\git\\DA218A"));
				j.showOpenDialog(j);
				controller.setMusic(j.getSelectedFile().getAbsolutePath());
				lblAudio.setText(j.getSelectedFile().getAbsolutePath());
				btnPlay.setEnabled(true);
				lblAudioLoaded.setText("Loaded audio file:");
			}
			
			/*
			 * Starts playing the music and disables the play and open button until its stopped
			 */
			if (e.getSource() == btnPlay) {
				controller.playMusic();
				btnStop.setEnabled(true);
				btnPlay.setEnabled(false);
				btnOpen.setEnabled(false);
			}
			
			/*
			 * Stops playing the music and enables the button play and open
			 */
			if (e.getSource() == btnStop) {
				controller.stopMusic();
				btnPlay.setEnabled(true);
				btnOpen.setEnabled(true);
			}
			if (e.getSource() == btnGo) {
				// Start game catch me
			}
		}
	}


}