package assignment1;

import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * A controller class that reveives input from the {@link GUI} and forwards it
 * to the classes {@link musicRunnable} and {@link textRunnable}
 * 
 * @author Kevin Stjernborg
 *
 */

public class Controller {

	private musicRunnable music;
	private textRunnable text;
	private Thread t1;
	private Thread t2;

	/**
	 * Contructor for the class which initiates the variables and starts the threads
	 */
	public Controller() {
		this.music = new musicRunnable();
		this.text = new textRunnable();
		t1 = new Thread(music);
		t2 = new Thread(text);
		t1.start();
		t2.start();
	}

	/**
	 * A method to start playing the music {@link musicRunnable}
	 */
	public void playMusic() {
		music.play();
	}

	/**
	 * A method to start the random text {@link textRunnable}
	 */
	public void startText() {
		text.start();
	}

	/**
	 * A method to stop the random text
	 */
	public void stopRandomText() {
		text.stop();
	}

	/**
	 * Receives the filepath and name of the music to be played and sends it to
	 * {@link musicRunnable}
	 * 
	 * @param url
	 */
	public void setMusic(String url) {
		music.setSong(url);
	}

	/**
	 * A method which stops the music
	 */
	public void stopMusic() {
		music.stop();
	}

	/**
	 * a Getter for the {@link musicRunnable}
	 * 
	 * @return musicRunnable
	 */

	public musicRunnable getMusic() {
		return music;
	}

	/**
	 * a Getter for the {@link textRunnable}
	 * 
	 * @return textRunnable
	 */
	public textRunnable getText() {
		return text;
	}

}
