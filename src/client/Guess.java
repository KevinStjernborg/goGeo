package client;

public class Guess {
	private double x;
	private double y;
	private double kilometers;

	
	public Guess(double x, double y) {
		this.x = x;
		this.y = y;	
	}
	
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}
	
	public void setDistance(Double kilometers) {
		this.kilometers = kilometers;
	}
}
