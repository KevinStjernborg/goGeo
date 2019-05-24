package shared;

import java.io.Serializable;
import org.jxmapviewer.viewer.GeoPosition;

/**
 * A class representing a players guess with coordinates for the markers placed
 * onto the {@link Viewer}
 * 
 * @author Kevin Stjernborg
 *
 */
public class Guess implements Serializable {
	private double x;
	private double y;
	private int kilometers;
	private double time;
	private int score;
	private GeoPosition geo;

	/**
	 * Constructor
	 * 
	 * @param geo Geoposition representing the marker placed on the map
	 */
	public Guess(GeoPosition geo) {
		this.x = geo.getLatitude();
		this.y = geo.getLongitude();
		this.geo = geo;
	}

	/**
	 * A method for printing out the coordinates
	 */
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}

	/**
	 * A method for setting the distance between the players guess and the
	 * coordinate representing the target
	 * 
	 * @param kilometers Distance between the two coordinates
	 */
	public void setDistance(int kilometers) {
		this.kilometers = kilometers;
	}

	/**
	 * A method for setting the time it took to guess the location
	 * 
	 * @param time
	 */
	public void setTime(double time) {
		this.time = time;
	}

	/**
	 * A method for getting the latitude coordinate
	 * 
	 * @return latitude coordinate
	 */
	public double getX() {
		return x;
	}

	/**
	 * A method for getting the longitude coordinate
	 * 
	 * @return longitude coordinate
	 */
	public double getY() {
		return y;
	}

	/**
	 * A method for getting the distance
	 * 
	 * @return
	 */
	public double getKilometers() {
		return kilometers;
	}

	/**
	 * A method for getting the time
	 * 
	 * @return
	 */
	public double getTime() {
		return time;
	}

	/**
	 * A method for getting the {@link GeoPosition} reprsenting a players guess
	 * 
	 * @return
	 */
	public GeoPosition getGeo() {
		return geo;
	}

	/**
	 * A method for calculating the score
	 */
	public void calculateScore() {
		score = (int) (800 - kilometers);
		score = (int) (score * time);
		if (score <= 0) {
			score = 0;
		}
	}

	/**
	 * A method for getting a guess score.
	 * 
	 * @return score
	 */
	public int getScore() {
		return score;
	}

}
