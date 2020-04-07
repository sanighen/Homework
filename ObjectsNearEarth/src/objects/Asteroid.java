package objects;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONObject;

public class Asteroid {

	private final static String API_KEY = "Ok7lflgXxbtbRKSwQXi78CxAfbLW69HR16YJMluj";
	private final static String NEO_ENDPOINT = "https://api.nasa.gov/neo/rest/v1/feed";
	private final static Calendar calendar = Calendar.getInstance();
	private final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public void getNeoAsteroids(String startDate, String endDate) throws Exception {
		
		URL nasaUrl = new URL(NEO_ENDPOINT + "?start_date=" + startDate + "&end_date=" + endDate + "&api_key=" + API_KEY);
		BufferedReader in = new BufferedReader(new InputStreamReader(nasaUrl.openStream()));
		
		String stringData = "";
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			stringData += inputLine;
		in.close();
		
		JSONObject data = new JSONObject(stringData);
		
		int count = data.getInt("element_count");
		System.err.println("Found " + count + " asteroids");
		
		calendar.setTime(format.parse(startDate));
		
		do {
			startDate = format.format(calendar.getTime());
			calendar.add(Calendar.DATE, 1);

			for (int j = 0; j < data.getJSONObject("near_earth_objects").getJSONArray(startDate).length(); j++) {

				float diameter = data.getJSONObject("near_earth_objects")
									 .getJSONArray(startDate)
									 .getJSONObject(j)
									 .getJSONObject("estimated_diameter")
									 .getJSONObject("kilometers")
									 .getFloat("estimated_diameter_min");

				double distance = data.getJSONObject("near_earth_objects")
									  .getJSONArray(startDate)
									  .getJSONObject(j)
									  .getJSONArray("close_approach_data")
									  .getJSONObject(0)
									  .getJSONObject("miss_distance")
									  .getDouble("kilometers");

				boolean isHazardous = data.getJSONObject("near_earth_objects")
										  .getJSONArray(startDate)
										  .getJSONObject(j)
										  .getBoolean("is_potentially_hazardous_asteroid");

				System.out.printf("%s - Minimum asteroid diameter: %.2f km, ",startDate, diameter);
				System.out.printf("Distance from object to Earth %.1f mln km, ", distance / 1000000);
				System.out.println("Is potentially hazardous asteroid: " + isHazardous);

			}
			System.out.println();
		} while (!startDate.equals(endDate));
	}
	
	
}