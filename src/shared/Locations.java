package shared;

import java.util.HashMap;

import org.jxmapviewer.viewer.GeoPosition;

public class Locations {
	
	private HashMap<String, GeoPosition> locations = new HashMap<String, GeoPosition>();
	
	
	public Locations() {
//		addEurope();
		
//		locations.put("Rome", new GeoPosition(, ));
//		locations.put("Milano", new GeoPosition(, ));
//		locations.put("Naples", new GeoPosition(, ));
//		locations.put("Turin", new GeoPosition(, ));
//		
//		locations.put("Madrid", new GeoPosition(, ));
//		locations.put("Barcelona", new GeoPosition(, ));
//		locations.put("Valencia", new GeoPosition(, ));
//		locations.put("Seville", new GeoPosition(, ));
//		locations.put("Bilbao", new GeoPosition(, ));
//		
//		locations.put("Amsterdam", new GeoPosition(, ));
//		locations.put("Rotterdam", new GeoPosition(, ));
//		locations.put("Utrecht", new GeoPosition(, ));
//		
//		locations.put("Antwerp", new GeoPosition(, ));
//		locations.put("Brussels", new GeoPosition(, ));
//		locations.put("Anderlecht", new GeoPosition(, ));
//		
//		locations.put("Warsaw", new GeoPosition(, ));
//		locations.put("Kraków", new GeoPosition(, ));
//		locations.put("Łódź", new GeoPosition(, ));
//		locations.put("Poznań", new GeoPosition(, ));
//		
//		locations.put("Athens", new GeoPosition(, ));
//		locations.put("Thessaloniki", new GeoPosition(, ));
//		locations.put("Patras", new GeoPosition(, ));
//		
//		locations.put("Paris", new GeoPosition(, ));
//		locations.put("Paris", new GeoPosition(, ));
//		locations.put("Paris", new GeoPosition(, ));
	}
	
	public void addLocation(String name, GeoPosition loc) {
		locations.putIfAbsent(name, loc);
	}
	
	public void getLocation(String name) {
		locations.get(name);
//		locations.remove(name);
	}
	
//	public void addEurope() {
//		locations.put("Paris", new GeoPosition(48.864716, 2.349014));
//		locations.put("Lyon", new GeoPosition(45.763420, 4.834277 ));
//		locations.put("Marseille", new GeoPosition(43.29695, 5.38107));
//		locations.put("Monaco", new GeoPosition(43.740070, 7.426644));
//		locations.put("Nice", new GeoPosition(43.675819, 7.289429 ));
//		
//		locations.put("London", new GeoPosition(51.509865, -0.118092));
//		locations.put("Birmingham", new GeoPosition(52.489471, -1.898575));
//		locations.put("Liverpool", new GeoPosition(53.41058, 2.97794 ));
//		locations.put("Manchester", new GeoPosition(53.483959, -2.244644));
//		
//		locations.put("Berlin", new GeoPosition(52.520008, 13.404954));
//		locations.put("Hamburg", new GeoPosition(53.551086, 9.993682));
//		locations.put("Munich", new GeoPosition(48.137154, 11.576124));
//		locations.put("Cologne", new GeoPosition(50.935173, 6.953101));
//		locations.put("Frankfurt", new GeoPosition(50.110924, 8.682127));
//
//	}
	
	
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
		}

		}
	}

