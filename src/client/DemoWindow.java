package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

/**
 * Ett draft pÃ¥ hur grÃ¤nssnittet kan komma att se ut i spelet. 
 * @author Said
 *
 *
 *Bytas ut mot annat fönster när de är klart men samma metoder// Kevin 
 */

public class DemoWindow {
	
	Viewer viewer = new Viewer();
	private Controller controller;

	private JFrame frame;

	private JPanel panelEast;
	private JPanel GameMenuPanel;
	private JPanel centerPanel;
	private JPanel scorePanel;
	private JPanel imagePanel;
	private JPanel bottomPanel;
	private JPanel CoordPanel;
	private Panel panel_4;

	private JLabel label;
	private JLabel lblCoordHeading;
	private JLabel lblScore;
	private Label lblCoordinatesDisplay;

	private JComboBox<ImageIcon> comboBox;

	private JButton btnNewGame;
	private JButton btnExitGame;
	private JButton btnRandomPicture;


	public DemoWindow(Controller controller) {
		initialize();
		this.controller = controller;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelEast = new JPanel();
		frame.getContentPane().add(panelEast, BorderLayout.EAST);
		panelEast.setLayout(new BorderLayout(0, 0));

		GameMenuPanel = new JPanel();
		panelEast.add(GameMenuPanel, BorderLayout.NORTH);

		btnNewGame = new JButton("New Game");
		GameMenuPanel.add(btnNewGame);

		btnExitGame = new JButton("Exit Game");
		GameMenuPanel.add(btnExitGame);

		scorePanel = new JPanel();
		panelEast.add(scorePanel, BorderLayout.SOUTH);

		lblScore = new JLabel("Score");
		scorePanel.add(lblScore);

		panel_4 = new Panel();
		panelEast.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));




		centerPanel = new JPanel();
		frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		centerPanel.add(viewer.getViewer());
		
		
//		frame.add(viewer.getViewer(),BorderLayout.CENTER);
////		frame.add(lblScore, BorderLayout.CENTER);

		bottomPanel = new JPanel();
		frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));

		CoordPanel = new JPanel();
		bottomPanel.add(CoordPanel, BorderLayout.WEST);
		CoordPanel.setLayout(new GridLayout(0, 2, 0, 0));

		lblCoordHeading = new JLabel("Coordinates:  ");
		lblCoordHeading.setFont(new Font("Tahoma", Font.BOLD, 16));
		CoordPanel.add(lblCoordHeading);

		lblCoordinatesDisplay = new Label("New label");
		CoordPanel.add(lblCoordinatesDisplay);
		frame.setVisible(true);
		
		frame.pack();
	}

	public Viewer getViewer() {
		return viewer;
	}

	


		
//		public static void main(String[] args) {
//
//		DemoWindow window = new DemoWindow();
//
//		window.frame.setVisible(true);
//	}
}
