package client;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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

public class Viewer {
	private static int eventCnt;
	private JXMapViewer viewer;
	private Timer timer;
	private GeoPosition Paris = new GeoPosition(48.8566, 2.3522);
	private Guess guess;
	
	
	
	/**
	 * Constructor for the class
	 */
	public Viewer() {
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
		timer = new Timer();
		

	}
	/**
	 * Adds a marker on the map that shows where the player clicked
	 * @param p1
	 */
	public void addLocation(GeoPosition p1) {
		Set<SwingWaypoint> waypoints = new HashSet<SwingWaypoint>(Arrays.asList(new SwingWaypoint("p1", p1)));

		WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<Waypoint>();
		waypointPainter.setWaypoints(waypoints);
		List<Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
		painters.add(waypointPainter);

		CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(painters);
		viewer.setOverlayPainter(painter);

	}

	public void setOtherPlayersCoordinate(GeoPosition geo) {
		addLocation(geo);
	}

	/**
	 * Adds double click and sets the action once double click occours
	 * Clears the map of existing markers and creates, and if one already exists, replaces the existing one
	 */
	public void addDoubleClick() {
		viewer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {
				if (e.getButton() == 1 && e.getButton() == 1) {
					eventCnt = e.getClickCount();
					if (e.getClickCount() == 1) {
						timer.schedule(new TimerTask() {
							@Override
							public void run() {
								if (eventCnt == 1) {
								} else if (eventCnt > 1) {
									removePaint();
									Point p = e.getPoint();
									Point2D pt = viewer.convertGeoPositionToPoint(Paris);
									GeoPosition geo = viewer.convertPointToGeoPosition(p);
									guess = new Guess(geo.getLatitude(), geo.getLongitude(), geo );
									System.out.println("Distance in kilometers: " + distFrom(geo.getLatitude(),
											geo.getLongitude(), Paris.getLatitude(), Paris.getLongitude()));
									addLocation(geo);
								}
								eventCnt = 0;
							}
						}, 400);
					}
				}
				if (e.getButton() == 3) {
					System.out.println("right click");
					removePaint();
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
	 * Removes the marker that represents the position that the player clicks
	 */

	public void removePaint() {
		List<Painter<JXMapViewer>> painters = new ArrayList<Painter<JXMapViewer>>();
		CompoundPainter<JXMapViewer> painter = new CompoundPainter<JXMapViewer>(painters);
		viewer.setOverlayPainter(painter);
		painter.clearCache();
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
		int distance = (int) dist;

		return distance;
	}

}
