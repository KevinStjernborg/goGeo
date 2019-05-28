package shared;

import java.util.HashMap;

import org.jxmapviewer.viewer.GeoPosition;

public class Locations {
	
	private HashMap<String, GeoPosition> locations = new HashMap<String, GeoPosition>();

	
	
	public HashMap getHashMap() {
		return locations;
	}
	
	
	public void setHashMap(int caseNumber)	{
		HashMap<String, GeoPosition> hashMap = new HashMap<String, GeoPosition>();
		switch(caseNumber) {
		case 1:
			locations.put("Vienna, Austria", new GeoPosition(48.208174, 16.373819));
			locations.put("Bucharest, Romania", new GeoPosition(44.439663, 26.096306));
			locations.put("Budapest, Hungary", new GeoPosition(47.49801, 19.03991));
			break;
		case 2:

			locations.put("Lisbon, Portugal", new GeoPosition(38.71667, -9.13333));
			locations.put("Sofia, Bulgaria", new GeoPosition(42.69751, 23.32415));
			locations.put("Prague, Czech Republic ", new GeoPosition(50.08804, 14.42076));
			break;
			
		case 3:
			locations.put("Dublin, Irland", new GeoPosition( 53.350140, -6.266155));
			locations.put("Kiev, Ukraine ", new GeoPosition(50.45466, 30.5238));
			locations.put("Berlin, Germany", new GeoPosition(52.52437, 13.41053));
			break;

		case 4:
			locations.put("Minsk, Belarus", new GeoPosition(53.9, 27.56667));
			locations.put("Stockholm, Sweden", new GeoPosition(59.33258, 18.0649));
			locations.put("Berlin, Germany", new GeoPosition(52.52437, 13.41053));
			break;

		case 5:
			locations.put("Rabat, Morocco ", new GeoPosition(34.01325, -6.83255));
			locations.put("Nairobi, Kenya ", new GeoPosition(-1.28333, 36.81667));
			locations.put("Dakar, Senegal", new GeoPosition(14.6937, -17.44406));
			break;

		case 6:
			locations.put("Cape Town, South Africa ", new GeoPosition(-33.918861, 18.423300));
			locations.put("Luanda, Angola", new GeoPosition(-8.83682, 13.23432));
			locations.put("Brazzaville, Republic of the Congo", new GeoPosition(-4.26613, 15.28318));
			break;

		case 7:
			locations.put("Maputo, Mozambique", new GeoPosition(-25.96553, 32.58322));
			locations.put("Accra, Ghana", new GeoPosition(5.55602, -0.1969));
			locations.put("Kampala, Uganda", new GeoPosition(0.31628, 32.58219));
			break;

		case 8:
			locations.put("Port Louis, Mauritius", new GeoPosition(-20.16194, 57.49889));
			locations.put("Bamako, Mali", new GeoPosition(12.65, -8));
			locations.put("Tunis, Tunisia", new GeoPosition(36.81897, 10.16579));
			break;
		case 9:
			locations.put("Kabul, Afghanistan", new GeoPosition(34.52813, 69.17233));
			locations.put("Tehran, Iran", new GeoPosition( 35.715298, 51.404343));
			locations.put("Doha, Qatar", new GeoPosition(25.27932, 51.52245));
			break;
		case 10:
			locations.put("Colombo, Sri Lanka", new GeoPosition(6.927079, 79.861244));
			locations.put("New Delhi, India", new GeoPosition(28.65381, 77.22897));
			locations.put("Tokyo, Japan", new GeoPosition(35.652832, 139.839478));
			break;
		case 11:
			locations.put("Taipei City, Taiwan", new GeoPosition(25.105497, 121.597366));
			locations.put("Muscat, Oman", new GeoPosition(23.614328, 58.545284));
			locations.put("Kuala Lumpur, Malaysia", new GeoPosition(3.1412, 101.68653));
			break;
		case 12:
			locations.put("La Paz, Bolivia", new GeoPosition(-16.5, -68.15));
			locations.put("Bogotá, Colombia", new GeoPosition(4.624335, -74.063644));
			locations.put("Lima, Peru", new GeoPosition(-12.04318, -77.02824));
			break;
		case 13:
			locations.put("Santiago, Chile", new GeoPosition(-33.45694, -70.64827));
			locations.put("Caracas, Venezuela", new GeoPosition(10.500000, -66.916664));
			locations.put("Buenos Aires, Argentina", new GeoPosition(-34.61315, -58.37723));
			break;
		case 14:
			locations.put("Asunción, Paraguay", new GeoPosition(-25.30066, -57.63591));
			locations.put("San José, Costa Rica", new GeoPosition(9.934739, -84.087502));
			locations.put("Ottowa, Canada", new GeoPosition(45.41117, -75.69812));
			break;
		}

		}
	}

