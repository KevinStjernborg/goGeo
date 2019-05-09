package shared;

import java.util.HashMap;

import org.jxmapviewer.viewer.GeoPosition;

public class Locations {
	
	private HashMap<String, GeoPosition> locations = new HashMap<String, GeoPosition>();
	
	
	public Locations() {
		addEurope();
		
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
	
	public void addEurope() {
		locations.put("Paris", new GeoPosition(48.864716, 2.349014));
		locations.put("Lyon", new GeoPosition(45.763420, 4.834277 ));
		locations.put("Marseille", new GeoPosition(43.29695, 5.38107));
		locations.put("Monaco", new GeoPosition(43.740070, 7.426644));
		locations.put("Nice", new GeoPosition(43.675819, 7.289429 ));
		
		locations.put("London", new GeoPosition(51.509865, -0.118092));
		locations.put("Birmingham", new GeoPosition(52.489471, -1.898575));
		locations.put("Liverpool", new GeoPosition(53.41058, 2.97794 ));
		locations.put("Manchester", new GeoPosition(53.483959, -2.244644));
		
		locations.put("Berlin", new GeoPosition(52.520008, 13.404954));
		locations.put("Hamburg", new GeoPosition(53.551086, 9.993682));
		locations.put("Munich", new GeoPosition(48.137154, 11.576124));
		locations.put("Cologne", new GeoPosition(50.935173, 6.953101));
		locations.put("Frankfurt", new GeoPosition(50.110924, 8.682127));

	}
	
	
	public HashMap getHashMap(int caseNumber)	{
		HashMap<String, GeoPosition> hashMap = new HashMap<String, GeoPosition>();
		switch(caseNumber) {
		case 1:
			hashMap.put("Paris", new GeoPosition(48.864716, 2.349014));
			hashMap.put("Lyon", new GeoPosition(45.763420, 4.834277 ));
			hashMap.put("Marseille", new GeoPosition(43.29695, 5.38107));
			hashMap.put("Monaco", new GeoPosition(43.740070, 7.426644));
			hashMap.put("Nice", new GeoPosition(43.675819, 7.289429 ));
			break;
		case 2:
			hashMap.put("London", new GeoPosition(51.509865, -0.118092));
			hashMap.put("Birmingham", new GeoPosition(52.489471, -1.898575));
			hashMap.put("Liverpool", new GeoPosition(53.41058, 2.97794 ));
			hashMap.put("Manchester", new GeoPosition(53.483959, -2.244644));
			break;
		case 3:
			hashMap.put("Berlin", new GeoPosition(52.520008, 13.404954));
			hashMap.put("Hamburg", new GeoPosition(53.551086, 9.993682));
			hashMap.put("Munich", new GeoPosition(48.137154, 11.576124));
			hashMap.put("Cologne", new GeoPosition(50.935173, 6.953101));
			hashMap.put("Frankfurt", new GeoPosition(50.110924, 8.682127));
			break;
		}
		return hashMap;
	}
}
