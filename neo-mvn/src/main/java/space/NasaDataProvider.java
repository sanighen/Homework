package space;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.JSONObject;

public class NasaDataProvider {

	private final static String API_KEY = "Ok7lflgXxbtbRKSwQXi78CxAfbLW69HR16YJMluj";
	private final static String NEO_ENDPOINT = "https://api.nasa.gov/neo/rest/v1/feed";
	private final static Calendar calendar = Calendar.getInstance();
	private final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public List<Asteroid> getNeoAsteroids(String startDate, String endDate) throws Exception {

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

		List<Asteroid> asteroids = new ArrayList<>(count);

		calendar.setTime(format.parse(startDate));

		do {
			startDate = format.format(calendar.getTime());
			calendar.add(Calendar.DATE, 1);

			for (int j = 0; j < data.getJSONObject("near_earth_objects").getJSONArray(startDate).length(); j++) {

				Float diameter = data.getJSONObject("near_earth_objects")
									 .getJSONArray(startDate)
									 .getJSONObject(j)
									 .getJSONObject("estimated_diameter")
									 .getJSONObject("kilometers")
									 .getFloat("estimated_diameter_min");

				Double distance = data.getJSONObject("near_earth_objects")
									  .getJSONArray(startDate)
									  .getJSONObject(j)
									  .getJSONArray("close_approach_data")
									  .getJSONObject(0)
									  .getJSONObject("miss_distance")
									  .getDouble("kilometers");

				Boolean isHazardous = data.getJSONObject("near_earth_objects")
										  .getJSONArray(startDate)
										  .getJSONObject(j)
										  .getBoolean("is_potentially_hazardous_asteroid");
				
				asteroids.add(new Asteroid(startDate, diameter, distance, isHazardous));

			}
			System.out.println();
		} while (!startDate.equals(endDate));

		for (Asteroid asteroid : asteroids) {
			System.out.printf("%s - diameter: %.2f km, ", asteroid.getDate(), asteroid.getDiamteter());
			System.out.printf("distance: %4.1f mln km, ", asteroid.getDistance() / 1000000);
			System.out.println(asteroid.isHazardous() ? "it's hazardous!" : "it's not hazardous");
		}
		return asteroids;
	}

}