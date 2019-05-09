package shared;

import java.io.Serializable;

import org.jxmapviewer.viewer.GeoPosition;

public class Guess implements Serializable {
	private double x;
	private double y;
	private int kilometers;
	private double time;
	private int score;
	private GeoPosition geo;

	/*
	 * TODO
	 * ta bort x och y variabler, beh�vs inte, allt finns i geo
	 * 
	 */
	public Guess(double x, double y, GeoPosition geo) {
		this.x = x;
		this.y = y;
		this.geo = geo;
	}
	
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}
	
	public void setDistance(int kilometers) {
		this.kilometers = kilometers;
	}
	
	public void setTime(double time) {
		this.time = time;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getKilometers() {
		return kilometers;
	}

	public double getTime() {
		return time;
	}

	public GeoPosition getGeo() {
		return geo;
	}
	/*
	 * Metod kan flyttas beroende p� vad som passar b�st l�nge fram
	 */
	public void calculateScore() {
		score = (int) (400 - kilometers);
		score = (int) (score * time);
		if(score <=0) {
			score = 0;
		}
	}
	
	
	public int getScore() {
		return score;
	}

}
