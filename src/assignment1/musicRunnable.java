package assignment1;

import javax.swing.JComponent; 

/**
 * 
 * @author Kevin Stjernborg
 * A class that implements {@link Runnable} and plays music and is called by {@link Controller}
 * The musicBoolean acts as a condition for the thread to excecute or to stop.
 */

public class musicRunnable implements Runnable {
	private String URL;
	private Boolean musicBoolean;
	private Sound aSound;
	
	/**
	 * A constructor for the class which initiates the thread boolean as false
	 */
	public musicRunnable() {
		musicBoolean = false;
	}
 /**
  * A setter for the String which contains location and filename
  * @param url directory location and filename
  */
	public void setSong(String url) {
		this.URL = url;
	}
 /**
  *  A method to start playing the music by initiating the {@link Sound} class and changing the boolean to true
  */
	public void play() {
		aSound = Sound.getSound(URL);
		this.musicBoolean = true;
	}
/**
 *  A method to stop playing the music by changing the music boolean to false
 */
	public void stop() {
		this.musicBoolean = false;
	}
	
	/**
	 * A run method for the thread.
	 * The thread waits in an endless and and further listens to the conditions of the boolean to either start or stop playing music.
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
				if (musicBoolean == false) {
					if(aSound != null) {
						aSound.stop();
					}
				}
				if (musicBoolean == true) {
					if (aSound != null) {
						aSound.play();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
