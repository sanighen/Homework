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

	public void getNeoAsteroids(String startDate) throws Exception {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		calendar.setTime(format.parse(startDate));
		
		for (int i = 0; i <= 6; i++) {
			calendar.add(Calendar.DATE, i);
			calendar.add(Calendar.DATE, -(i - 1));
			
			startDate = format.format(calendar.getTime());
			
			URL nasaUrl = new URL(NEO_ENDPOINT + "?start_date=" + startDate + "&end_date=" + startDate + "&api_key=" + API_KEY);
			BufferedReader in = new BufferedReader(new InputStreamReader(nasaUrl.openStream()));
			
			String stringData = "";
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				stringData += inputLine;
			in.close();

			JSONObject data = new JSONObject(stringData);

			System.out.println("----------------" + startDate + "----------------");

			int count = data.getInt("element_count");

			 for (int j = 0; j < count; j++) {
				System.out.println();
				System.err.println("Data on asteroid №" + (j + 1));
				
				float diameter = data.getJSONObject("near_earth_objects")
									 .getJSONArray(startDate)
									 .getJSONObject(j)
									 .getJSONObject("estimated_diameter")
									 .getJSONObject("kilometers")
									 .getFloat("estimated_diameter_min");
				System.out.printf("Estimated diameter min: %.2f km%n", diameter);

				double distance = data.getJSONObject("near_earth_objects")
									  .getJSONArray(startDate)
									  .getJSONObject(j)
									  .getJSONArray("close_approach_data")
									  .getJSONObject(0)
									  .getJSONObject("miss_distance")
									  .getDouble("kilometers");
				System.out.printf("Distance from object to Earth %.1f mln km %n", distance / 1000000);
				
				boolean isHazardous = data.getJSONObject("near_earth_objects")
										  .getJSONArray(startDate)
										  .getJSONObject(j)
										  .getBoolean("is_potentially_hazardous_asteroid");
				System.out.println("Is potentially hazardous asteroid: " + isHazardous);


			}
		}

		

	}
	

	
	
	
	
	
	
	
	
	
	
//	public void setDate(String startDate) throws ParseException {
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		calendar.setTime(format.parse(startDate));
//		calendar.add(Calendar.DATE, 3);
//		startDate = format.format(calendar.getTime());
//	}
	
}
