package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolTip;
import javax.swing.event.MouseInputListener;

import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

import shared.Guess;
import shared.Locations;

public class Viewer {
	
	private JXMapViewer viewer;

	private GeoPosition currentGeoLocation;
	private String currentStringLocation;
	private Guess guess = null;
	private Guess playerTwoGuess;
	private HashSet hashset = new HashSet<SwingWaypoint>();
	private boolean doubleClickActive;
	private Locations locations;
	private boolean roundFinished;
	private int hashMapController;
	private HashMap locationHashMap;
	private int locationsInt;

	
	
	/**
	 * Constructor for the class
	 */
	public Viewer(int choice) {
		/*
		 * initierar kartdelen
		 */
		TileFactoryInfo info = new OSMTileFactoryInfo("Test", "http://c.tile.stamen.com/watercolor");
		DefaultTileFactory tileFactory = new DefaultTileFactory(info);
		tileFactory.setThreadPoolSize(8);
		viewer = new JXMapViewer();
		viewer.setTileFactory(tileFactory);
		MouseInputListener mia = new PanMouseInputListener(viewer);
		viewer.addMouseListener(mia);
		viewer.addMouseMotionListener(mia);
		viewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(viewer));
		viewer.setZoom(16);
		addDoubleClick();
		enableMarkers();
		locations = new Locations();
		getLocationHashMap(choice);
	}
	/**
	 * Adds a marker on the map that shows where the player clicked
	 * @param p1
	 */
	
	
	public void getLocationHashMap(int choice) {
		locationHashMap = locations.getHashMap(choice);
	}
	
	public String getCurrentStringLocation() {
		return currentStringLocation;
	}
	
	
	public void setGameLocation() {
		Iterator iterator = locationHashMap.entrySet().iterator();

			HashMap.Entry pair = (HashMap.Entry)iterator.next();	
			currentGeoLocation = (GeoPosition) pair.getValue();
			currentStringLocation = (String) pair.getKey();
			iterator.remove();

			}
	
	
	
	/*
	 * TODO 
	 * Kontrollera att flera waypoints kan synas utan att skickas med som parameter direkt
	 */
	public void addOneLocation(GeoPosition p1) {
		Set<SwingWaypoint> waypoints = new HashSet<SwingWaypoint>(Arrays.asList(new SwingWaypoint("p1", p1)));
		WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<Waypoint>();
		waypointPainter.setWaypoints(waypoints);
		List<Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
		painters.add(waypointPainter);
		CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(painters);
		viewer.setOverlayPainter(painter);

	}
	
	public void addTwoLocations(GeoPosition p1, GeoPosition p2) {
		Set<MyWaypoint> waypoints = new HashSet<MyWaypoint>(Arrays.asList(new MyWaypoint("p1",Color.BLUE, p1), new MyWaypoint("p2",Color.RED, p2)));
		WaypointPainter<MyWaypoint> waypointPainter = new WaypointPainter<MyWaypoint>();
		waypointPainter.setWaypoints(waypoints);
		waypointPainter.setRenderer(new FancyWaypointRenderer());
		List<Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
		painters.add(waypointPainter);

		CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(painters);
		viewer.setOverlayPainter(painter);

	}

	public void addOtherPlayersGuess(GeoPosition geo) {
		System.out.println("Guess receiver in viewer");
		removePaint();
		addTwoLocations(guess.getGeo(), geo);
	}
	
	public boolean isRoundFinished() {
		return roundFinished;
	}
	
	public void setRoundAsFinished() {
		roundFinished = true;
	}
	
	public void setRoundAsUnfinished() {
		roundFinished = false;
	}
	
	/*
	 * Ska tas bort, tillf�llig l�sning f�r testning
	 */
	
//	public void setController(Controller controller) {
//		this.controller = controller;
//	}
	
	public void setPlayerOneGuess(Guess guess) {
		this.guess = guess;
	}

	/**
	 * Adds double click and sets the action once double click occours
	 * Clears the map of existing markers and creates, and if one already exists, replaces the existing one
	 */
	public void addDoubleClick() {
		viewer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount()==2 && doubleClickActive == true) {
					Point p = e.getPoint();
					Point2D pt = viewer.convertGeoPositionToPoint(currentGeoLocation);
					GeoPosition geo = viewer.convertPointToGeoPosition(p);
					guess = new Guess(geo.getLatitude(), geo.getLongitude(), geo );
					setPlayerOneGuess(guess);
					int distance = (int) distFrom(geo.getLatitude(), geo.getLongitude(), currentGeoLocation.getLatitude(), currentGeoLocation.getLongitude());
					guess.setDistance(distance);
					System.out.println("Distance in kilometers: " + distFrom(geo.getLatitude(),
							geo.getLongitude(), currentGeoLocation.getLatitude(), currentGeoLocation.getLongitude()));
					addOneLocation(geo);
					
					System.out.println("Guess sent");
				}

				if (e.getButton() == 3) {
					System.out.println("right click");
					removePaint();
					disableMarkers();
				}
			}
		});

	}

	/**
	 * Returns the JXMapviewer
	 * 
	 * @return {@link JXMapViewer}
	 */

	public JXMapViewer getViewer() {
		return viewer;
	}
	
	public void disableMarkers() {
		doubleClickActive = false;
	}
	
	public void enableMarkers() {
		doubleClickActive = true;
	}

	/**
	 * Removes the marker that represents the position that the player clicks
	 */

	public void removePaint() {
		List<Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
		CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(painters);
		viewer.setOverlayPainter(painter);
		painter.clearCache();
	}
	
	public Guess getGuess() {
		return this.guess;
	}

	/**
	 * Calculates the distance between two coordinates
	 * 
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return distance in kilometers
	 */

	public static float distFrom(double lat1, double lng1, double lat2, double lng2) {
		double earthRadius = 6371000; // meters
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(dLng / 2) * Math.sin(dLng / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		float dist = (float) (earthRadius * c);
		dist = dist / 1000;
		int distance = Math.round(dist);
		return distance;
	}
	
	
//	public static void main(String[] args) {
//		Frame f = new Frame();
//		Viewer v = new Viewer();
//		f.add(v.getViewer());
//		f.setVisible(true);
//		f.setSize(1000, 1000);
//	}
}
