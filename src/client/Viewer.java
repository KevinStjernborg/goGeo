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


/**
 * 
 * @author kevin
 *
 */
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
		mouseDoubleClicked();
		enableMarkers();
		locations = new Locations();
		getLocationHashMap(choice);
	}
	/**
	 * Adds a marker on the map that shows where the player clicked
	 * @param p1
	 */
	
	/**
	 * Gets a hashmap of choice from the {@link Locations} class.
	 * @param choice Choice for case switch statement.
	 */
	
	public void getLocationHashMap(int choice) {
		locationHashMap = locations.getHashMap(choice);
	}
	
	/**
	 * Gets the current string describing the location
	 * @return  String describing current location
	 */
	
	public String getCurrentStringLocation() {
		return currentStringLocation;
	}
	
	/**
	 * Iterates through the hashmap by one and removes the key and value it iterates through
	 */
	public void setGameLocation() {
		Iterator iterator = locationHashMap.entrySet().iterator();

			HashMap.Entry pair = (HashMap.Entry)iterator.next();	
			currentGeoLocation = (GeoPosition) pair.getValue();
			currentStringLocation = (String) pair.getKey();
			iterator.remove();

			}
	
	
	

	
	/**
	 * Adds one marker to the map at the x and y coordinates of the {@link GeoPosition}
	 * @param p1 The geoposition containing x and y coordinates
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
	
	/**
	 * Adds two marker to the map at the x and y coordinates of the {@link GeoPosition}
	 * @param p1 The geoposition containing x and y coordinates representing player one
	 * @param p2 The geoposition containing x and y coordinates representing player two
	 */
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

	/**
	 * A method for adding another players {@link GeoPosition}
	 * @param geo Player two's geoposition
	 */
	public void addOtherPlayersGuess(GeoPosition geo) {
		System.out.println("Guess receiver in viewer");
		removePaint();
		addTwoLocations(guess.getGeo(), geo);
	}
	/**
	 * A getter for the boolean representing if a round is finished.
	 * @return Boolean representing the state of current round
	 */
	public boolean isRoundFinished() {
		return roundFinished;
	}
	
	/**
	 * Setting the boolean roundfinished as true
	 */
	public void setRoundAsFinished() {
		roundFinished = true;
	}
	
	/**
	 * Setting the boolean roundfinished as false
	 */
	public void setRoundAsUnfinished() {
		roundFinished = false;
	}
	

	/**
	 * A setter for player one's guess
	 * @param guess
	 */
	public void setPlayerOneGuess(Guess guess) {
		this.guess = guess;
	}

	/**
	 * Adds double click and places a marker at the coordinates the player clicked on and creates a {@link GeoPosition} object.
	 * A {@link Guess} object is created with geoposition and its set as the current guess of the round.
	 * 
	 */
	public void mouseDoubleClicked() {
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
	 /**
	  * Setting the boolean for disabling the doubleclick event
	  */
	public void disableMarkers() {
		doubleClickActive = false;
	}
	/**
	 * Setting the boolean for enabling the doubleclick event
	 */
	public void enableMarkers() {
		doubleClickActive = true;
	}

	/**
	 * Removes all markers on the map
	 */

	public void removePaint() {
		List<Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
		CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(painters);
		viewer.setOverlayPainter(painter);
		painter.clearCache();
	}
	
	/**
	 * A getter for the guess.
	 * @return {@link Guess} The players guess 
	 */
	public Guess getGuess() {
		return this.guess;
	}

	/**
	 * Calculates the distance between two coordinates
	 * 
	 * @param lat1 Latitude of coordinate one
	 * @param lng1 Longitude of coordinate one
	 * @param lat2 Latitude of coordinate one
	 * @param lng2 Longitude of coordinate one
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
	
	
}
