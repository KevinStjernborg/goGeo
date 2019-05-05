package shared;

import org.jxmapviewer.viewer.GeoPosition;

public class Guess {
	private double x;
	private double y;
	private double kilometers;
	private double time;
	private int score;
	private GeoPosition geo;

	/*
	 * TODO
	 * ta bort x och y variabler, behövs inte, allt finns i geo
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
	
	public void setDistance(Double kilometers) {
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
	 * Metod kan flyttas beroende på vad som passar bäst länge fram
	 */
	public void calculateScore() {
		score = (int) (this.kilometers * time / 2);
	}
	
	
	public int getScore() {
		return score;
	}

}
