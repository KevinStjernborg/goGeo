package assignment2;

public class Reader implements Runnable {
	private Buffer<Character> buffer;

	public Reader(Buffer<Character> buffer) {
		this.buffer = buffer;
		Thread t = new Thread(this);
		t.start();
	}
	
	
	
	public void run() {
		
	}
	

}
