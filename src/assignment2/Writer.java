package assignment2;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javafx.beans.InvalidationListener;

public class Writer extends Observable implements Runnable {

	private String text;
	private Buffer<Character> buffer;
	private char [] chars;
	private Random rand;
	

	public Writer(Buffer<Character> buffer) {
		this.buffer = buffer;
		rand = new Random();
	}

	public void setText(String text) {
		this.text = text;
		System.out.println(text);
		chars = text.toCharArray();
		Thread t = new Thread(this);
		t.start();
	}
	


	public void run() {
		for (int i = 0; i < chars.length; i++) {
			buffer.put(chars[i]);
			setChanged();
			notifyObservers(chars[i]);
			try {
				Thread.sleep(rand.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
