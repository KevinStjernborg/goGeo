package server;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * Main method for serverside
 * @author Kevin Stjernborg
 *
 */
public class Main {

	public static void main(String[] args) throws UnknownHostException {
		ServerController serverController = new ServerController(8050);
		
		
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("IP Address:- " + inetAddress.getHostAddress());
        System.out.println("Host Name:- " + inetAddress.getHostName());
	}

}