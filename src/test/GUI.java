package test;

import java.awt.BorderLayout;
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
import java.util.Random;

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


public class GUI {
		
		private JFrame frame;

		private JPanel panelEast;
		private JPanel GameMenuPanel;
		private JPanel centerPanel;
		private JPanel scorePanel;
		private JPanel bottomPanel;
		private JPanel CoordPanel;
		private Panel panel_4;
		
		private JXMapViewer mapViewer;

		private JLabel label;
		private JLabel lblCoordHeading;
		private JLabel lblScore;
		private Label lblCoordinatesDisplay;

		private JComboBox<ImageIcon> comboBox;

		private JButton btnNewGame;
		private JButton btnExitGame;
		private JButton btnRandomPicture;


		public GUI() {
			mapInit();
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		
		private void initialize() {
			frame = new JFrame();
			frame.addMouseListener(new MListener());
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

			comboBox = new JComboBox<ImageIcon>();
			comboBox.setToolTipText("Choose a new map!");
			panel_4.add(comboBox);

			btnRandomPicture = new JButton("Random Picture");
			panel_4.add(btnRandomPicture);
			btnRandomPicture.addActionListener(new MListener());

			centerPanel = new JPanel();
			frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
			centerPanel.setLayout(new BorderLayout(0, 0));

//			imagePanel = new JPanel();
			//centerPanel.add(imagePanel, BorderLayout.CENTER);
	//
//			//label = new JLabel(new ImageIcon("images\\Skärmklipp.JPG"));
//			//imagePanel.add(label);
			
			frame.add(mapViewer,BorderLayout.CENTER);

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
			
			 MouseInputListener mia = new PanMouseInputListener(mapViewer);
		        mapViewer.addMouseListener(mia);
		        mapViewer.addMouseMotionListener(mia);
		        mapViewer.addMouseListener(new CenterMapListener(mapViewer));
		        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(mapViewer));
		        mapViewer.addKeyListener(new PanKeyListener(mapViewer));
		}

		public void mapInit() {
			mapViewer = new JXMapViewer();
			
			TileFactoryInfo info = new OSMTileFactoryInfo("Test", "http://c.tile.stamen.com/watercolor");
			DefaultTileFactory tileFactory = new DefaultTileFactory(info);
			mapViewer.setTileFactory(tileFactory);

			// Use 8 threads in parallel to load the tiles
			tileFactory.setThreadPoolSize(10);
			
			// Set the focus
			GeoPosition frankfurt = new GeoPosition(55.00, 13.68);

			mapViewer.setZoom(10);
			mapViewer.setAddressLocation(frankfurt);
		}
		
		public class MListener implements MouseListener, MouseMotionListener, ActionListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				lblCoordinatesDisplay.setText("X: "+e.getX()+", Y: "+e.getY());
				lblCoordinatesDisplay.setFont(new Font("Tahoma", Font.BOLD, 12));
				System.out.println(lblCoordinatesDisplay);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseDragged(MouseEvent e) {
			}
			@Override
			public void mouseMoved(MouseEvent e) {
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnRandomPicture) {
//					Random rand = new Random();
//					int r;
//					r = rand.nextInt(3)+1;
//					if (r==1) {
//						label.setIcon(new ImageIcon("images\\Skärmklipp.JPG"));
////						imagePanel.add(label);
//					}
//					if (r==2) {
//						label.setIcon(new ImageIcon("images\\Europe.JPG"));
////						imagePanel.add(label);
//					}
//					if (r==3) {
//						label.setIcon(new ImageIcon("images\\NorthAfrica.JPG"));
////						imagePanel.add(label);
					}
				}
			}
		
		
		public static void main(String[] args) {
			GUI gui = new GUI();
			gui.initialize();
			gui.mapInit();
		}
}
